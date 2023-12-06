package com.jeb.framework.aspect;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Aspect
@Component
@Order(1)
@Slf4j
public class LoggerAspect {

//    @Around("@within(org.springframework.web.bind.annotation.RestController)" +
//            "||@within(org.springframework.stereotype.Controller)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Object isIgnorePrint = null;
        if (requestAttributes != null) {
            isIgnorePrint = requestAttributes.getAttribute("isIgnorePrint", 0);
            if (isIgnorePrint == null) {
                HttpServletRequest request = requestAttributes.getRequest();
                log.info("请求地址 => {}", request.getRequestURI());
                log.info("请求方式 => {}", request.getMethod());
            }
        }
        if (isIgnorePrint == null) {
            log.info("请求类方法 => {}", joinPoint.getSignature());
            log.info("请求类方法入参 => {}", JSON.toJSONString(filterArgs(joinPoint.getArgs()), JSONWriter.Feature.IgnoreErrorGetter));
        }
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        long end = System.currentTimeMillis();
        if (isIgnorePrint == null) {
            log.info("请求类方法返参 => {}", JSON.toJSONString(result, JSONWriter.Feature.IgnoreErrorGetter));
            log.info("执行耗时:{}ms", end - start);
        }
        return result;
    }

    private List<Object> filterArgs(Object[] objects) {
        return Arrays.stream(objects).filter(obj -> !(obj instanceof MultipartFile)
                && !(obj instanceof HttpServletResponse)
                && !(obj instanceof HttpServletRequest)).collect(Collectors.toList());
    }
}
