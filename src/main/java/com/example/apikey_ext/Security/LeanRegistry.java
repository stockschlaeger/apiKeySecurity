package com.example.apikey_ext.Security;

import com.example.apikey_ext.HandlingErrors.UnauthenticatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LeanRegistry {

    public ApiKeyParser parser;

    public LeanRegistry(ApiKeyParser parser) {
        this.parser = parser;
    }


    public void check() throws UnauthenticatedException {
        String expectedKey = parser.getExpectedKey();
        String actualKey = parser.getRealApiKey();

        if(expectedKey == null || expectedKey.equals("")){
            log.debug("API Key ist leer oder ApiKeyProtected wurde nicht gesetzt");
            throw new UnauthenticatedException("Fehler in der Key Verwaltung");
        }

        if(!expectedKey.matches(actualKey) || expectedKey.isEmpty() || actualKey.isEmpty()){
            log.debug("API Key in registry entspricht nicht dem geparseten Key aus dem Request Header");
            throw new UnauthenticatedException("API Key nicht korrekt");
        }

              /*
        if(registry.get("API_Header").getValue() == null){
            // Derzeit als Map implementiert
            log.debug("API Key wurde zu dem ID Value nicht in der Datenbank gefunden");
            throw new UnauthenticatedException();
        }
         */

    }
}
