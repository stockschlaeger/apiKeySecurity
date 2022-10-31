package com.example.apikey_ext;

import com.example.apikey_ext.Security.ApiKeyProtected;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DemoController {

    //move to config file
    //this one will remain static and does not change
    public final static String id = "API_Header";



    @GetMapping("/unprotected")
    public String unprotectedRoute() {

        return "not protected";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/protected")
    @ApiKeyProtected()
    public String protectedRoute() {
        return "protected";
    }

}
