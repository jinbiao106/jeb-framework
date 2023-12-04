package com.jeb.framework.mapper;

import com.jeb.framework.model.domain.User;

import java.util.List;

/**
* @author hujinbiao
* @description 针对表【jeb_user】的数据库操作Mapper
* @createDate 2023-12-03 22:40:35
* @Entity generator.domain.JebUser
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list();
}
