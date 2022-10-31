package com.example.apikey_ext.Security;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiKeyProtected {
    // in der aktuellen Version nur als default gebraucht
    String apiKey() default "none";
}
