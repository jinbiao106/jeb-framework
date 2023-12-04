package com.jeb.framework.controller.user;

import com.jeb.framework.model.domain.User;
import com.jeb.framework.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date 2023-12-03 22:47
 * @Author GuYue
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/list")
    public List<User> list(){
        List<User> users = userService.list();
        return users;
    }
}
