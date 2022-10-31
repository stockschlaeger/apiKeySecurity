package com.example.apikey_ext;


import com.example.apikey_ext.Security.ApiKeyClasslevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ApiKeyClasslevel(isKeyRequired = "yes")
public class FullySecuredController {



    @GetMapping("/classlevel")
    public String proteccted() {
        log.info("test");
        return "protected on classlevel";
    }


    @GetMapping("/classlevel2")
    public String bproteccted() {
        return "protected on classlevel 2";
    }

}
