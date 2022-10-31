package com.example.apikey_ext.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Component
public class ApiKeyParser {

    @Value("${isKey:000000}")
    String isKey;

    HttpServletRequest request;

    public ApiKeyParser(HttpServletRequest request) {
        this.request = request;
    }

    public String getRealApiKey(){
        String apikey = request.getHeader("apikey");
        return apikey;
    }

    public String getExpectedKey(){
        return  isKey;
    }


}
