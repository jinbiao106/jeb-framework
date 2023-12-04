package com.jeb.framework.service.user;

import com.jeb.framework.mapper.UserMapper;
import com.jeb.framework.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2023-12-03 22:50
 * @Author GuYue
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> list() {
        return userMapper.list();
    }
}
