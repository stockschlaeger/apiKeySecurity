package com.example.apikey_ext.Security;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class Facade {

    public ApiKeyParser parser;

    public Facade(ApiKeyParser parser) {
        this.parser = parser;
    }


    @Before("@annotation(ApiKeyProtected)")
    public void checkApiKey(JoinPoint joinPoint) throws Exception{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //Annotation[] logs = signature.getMethod().getAnnotations();

        String expectedKey = signature.getMethod().getAnnotation(ApiKeyProtected.class).apiKey();

        String realApiKey = parser.getRealApiKey();

        log.info("logging signature: " + String.valueOf(signature));
        log.info("expected key:" + expectedKey);
        log.info("real key:" + parser.getRealApiKey());

        KeyRegistry registry = new KeyRegistry();
        registry.check(realApiKey);







    }

}
