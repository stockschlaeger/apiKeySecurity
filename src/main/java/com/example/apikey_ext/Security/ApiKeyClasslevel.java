package com.example.apikey_ext.Security;


import java.lang.annotation.*;

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiKeyClasslevel {

    String isKeyRequired() default "no";
}
