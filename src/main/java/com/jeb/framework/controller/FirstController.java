package com.jeb.framework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023-12-03 21:20
 * @Author GuYue
 */
@RestController
@Slf4j
public class FirstController {
    @RequestMapping("/hello")
    public String test(){
        log.info("hello world");
        return "hello world";
    }
}
