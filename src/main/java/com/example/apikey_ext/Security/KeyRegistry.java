package com.example.apikey_ext.Security;

import com.example.apikey_ext.HandlingErrors.UnauthenticatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class KeyRegistry {




    Map <String, AbstractMap.SimpleEntry<String, String>> registry;

    public KeyRegistry() {
        startup();
    }

    public void startup(){
        AbstractMap.SimpleEntry<String, String> entry = new AbstractMap.SimpleEntry("apikey", "testing");
        HashMap<String, AbstractMap.SimpleEntry<String, String>> registrymap = new HashMap<>();
        registry = registrymap;
        registry.put("API_Header", entry);
    }



    public void check(String parsedKey) throws UnauthenticatedException {
        // API_Header Key würde normal auch als Parameter übergeben, momentan nutzen wir allerdings nur eine Variation, daher nicht notwendig

            if(parsedKey == null || parsedKey.equals("")){
                log.debug("API Key ist leer oder ApiKeyProtected wurde nicht gesetzt");
                throw new UnauthenticatedException();
            }

            if(registry.get("API_Header").getValue() == null){
                // Derzeit als Map implementiert
                log.debug("API Key wurde zu dem ID Value nicht in der Datenbank gefunden");
                throw new UnauthenticatedException();
            }

            if(!parsedKey.equals(registry.get("API_Header").getValue())){
                log.debug("API Key in registry entspricht nicht dem geparseten Key aus dem Request Header");
                throw new UnauthenticatedException("API_Key nicht korrekt");
            }
    }

}
