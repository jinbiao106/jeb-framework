package com.jeb.framework.service.user;

import com.github.pagehelper.PageHelper;
import com.jeb.framework.mapper.UserMapper;
import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.common.response.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * @Date 2023-12-03 22:50
 * @Author GuYue
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;


    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public PageInfo<User> list(UserReqDTO userReqDTO) {
        PageHelper.startPage(userReqDTO.getPageNum(), userReqDTO.getPageSize());
        List<User> pageVos = userMapper.list();
        return new PageInfo<>(pageVos);
    }

    /** 注意要使用@Transactional注解来维持数据库连接，否则当查询结束后数据库连接就会断开，Cursor就取不到数据了 */
    @Transactional
    public void selectCursor() {
        try( Cursor<User> users = userMapper.selectCursor()) {
            users.forEach(user -> {
                log.info("当前处理到:{}", users.getCurrentIndex());
                log.info("user:{}", user);
            });

            if (users.isConsumed()) {
                log.info("数据已经处理完毕");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Transactional
    public void batchInsert(List<User> userList) {
        // ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
        // ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
        // ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。
        // 关闭session的自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            userList.forEach(user -> mapper.insertSelective(user));
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    public void batchInsertByForeach(List<User> users) {
        userMapper.batchInsertByForeach(users);
    }

    public List<User> selectBatch(List<Long> list) {
        return userMapper.selectBatch(list);
    }

    public int batchUpdate(List<User> list) {
        return userMapper.batchUpdate(list);
    }

    public int save(UserReqDTO userReqDTO) {
        User user = new User();
        BeanUtils.copyProperties(userReqDTO, user);
        return userMapper.insertSelective(user);
    }

    public User selectOne(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
