package com.jeb.framework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
@Order(0)
@Slf4j
public class IgnoreLoggerAspect {

    @Before("@annotation(com.jeb.framework.annotation.IgnoreLoggerPrint)")
    public void ignore() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            requestAttributes.setAttribute("isIgnorePrint", "true", 0);
        }
    }
}
