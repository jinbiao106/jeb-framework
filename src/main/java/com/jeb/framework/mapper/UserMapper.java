package com.jeb.framework.mapper;

import com.jeb.framework.model.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;

/**
* @author hujinbiao
* @description 针对表【jeb_user】的数据库操作Mapper
* @createDate 2023-12-03 22:40:35
* @Entity generator.domain.JebUser
*/
public interface UserMapper {

    List<User> selectBatch(@Param("list") List<Long> list);

    @MapKey("id")
    Cursor<User> selectCursor();

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list();


    int batchInsertByForeach(@Param("list") List<User> list);

    int batchUpdate(@Param("list") List<User> list);
}
