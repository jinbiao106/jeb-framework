package com.jeb.framework.service.user;

import com.github.pagehelper.PageHelper;
import com.jeb.framework.mapper.UserMapper;
import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.response.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cursor.Cursor;
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

}
