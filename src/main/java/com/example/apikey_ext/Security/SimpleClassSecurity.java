package com.example.apikey_ext.Security;


import com.example.apikey_ext.HandlingErrors.UnauthenticatedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class SimpleClassSecurity {

    public ApiKeyParser parser;
    public LeanRegistry registry;


    public SimpleClassSecurity(ApiKeyParser parser, LeanRegistry registry) {
        this.parser = parser;
        this.registry = registry;
        log.info("constructed class level");
    }


    @Pointcut("@within(ApiKeyClasslevel)")
    public void securityIncovation(){}


    @Before("securityIncovation()")
    public void checkApiKey(JoinPoint joinPoint) throws UnauthenticatedException {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        String keyRequired =  signature.getMethod().getDeclaringClass().getAnnotation(ApiKeyClasslevel.class).isKeyRequired();

        if(keyRequired.matches("yes")){
            log.debug("API Key Abfrage ist aktiviert");
            registry.check();
        }

    }



}
