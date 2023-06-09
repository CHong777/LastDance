package com.example.lastdance.aop;

import com.example.lastdance.domain.header.CommonRequestHeader;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Order(0)
@Component
public class AopHeaderSet {

    @Autowired
    private ObjectMapper mapper;

    @Pointcut("execution(public * com.example.lastdance.cont..*(..))")
    void pointcut() {}

    @Around("pointcut()")
    Object headerSet(ProceedingJoinPoint jp) throws Throwable {
        HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        for (int i = 0; i < jp.getArgs().length; i++) {
            if (CommonRequestHeader.class.isInstance(jp.getArgs()[i])) {
                CommonRequestHeader commonRequestHeader = (CommonRequestHeader) jp.getArgs()[i];

                commonRequestHeader.setAuthKey(StringUtils.defaultString(httpRequest.getHeader("authKey")));

                commonRequestHeader.setOsType(StringUtils.defaultString(httpRequest.getHeader("osType")));
                commonRequestHeader.setOsVer(StringUtils.defaultString(httpRequest.getHeader("osVer")));
                commonRequestHeader.setAppVer(StringUtils.defaultString(httpRequest.getHeader("appVer")));
                commonRequestHeader.setAppVerCode(StringUtils.defaultString(httpRequest.getHeader("appVerCode")));
                commonRequestHeader.setDevice(StringUtils.defaultString(httpRequest.getHeader("device")));
                commonRequestHeader.setMdn(StringUtils.defaultString(httpRequest.getHeader("mdn")));

                log.info("HEAD: "+mapper.writeValueAsString(commonRequestHeader));
            }
        }
        return jp.proceed();
    }
}
