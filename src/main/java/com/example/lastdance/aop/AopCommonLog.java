package com.example.lastdance.aop;

import com.example.lastdance.domain.req.RootReq;
import com.example.lastdance.util.CalculateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Order(1)
@Component
public class AopCommonLog {
    @Autowired
    private ObjectMapper mapper;

    @Pointcut("@within(com.example.lastdance.annotation.CommonLog)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object commonLog(ProceedingJoinPoint jp) throws Throwable {
        CalculateTime calculateTime = new CalculateTime();
        String reqStr = null;
        Object[] jpObject = jp.getArgs();
        for( Object obj : jpObject ) {
            if (RootReq.class.isAssignableFrom(obj.getClass())) {
                reqStr = mapper.writeValueAsString(obj);
            }
        }

        log.info("REQ: "+reqStr);

        Object retObj = jp.proceed();

        log.info("RES: " + mapper.writeValueAsString(retObj));
        log.info("-- END ResTime=" + calculateTime.getElapsedTime() + "ms");
        return retObj;
    }
}
