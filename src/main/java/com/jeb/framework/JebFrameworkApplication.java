package com.jeb.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jeb.framework.mapper")
public class JebFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JebFrameworkApplication.class, args);
    }

}
