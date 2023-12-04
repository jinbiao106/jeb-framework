package com.jeb.framework.controller.user;

import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 2023-12-03 22:47
 * @Author GuYue
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户信息管理", description = "用户信息管理描述")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表")
    public List<User> list(@Validated @RequestBody UserReqDTO userReqDTO){
        System.out.println("name:"+userReqDTO.getName());
        List<User> users = userService.list();
        return users;
    }
}
