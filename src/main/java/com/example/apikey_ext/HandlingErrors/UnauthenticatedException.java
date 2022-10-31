package com.example.apikey_ext.HandlingErrors;

public class UnauthenticatedException extends Exception {

    public UnauthenticatedException() {
        super("API Key Autorisierung fehlgeschlagen");
    }

    public UnauthenticatedException(String message) {
        super(message);
    }
}
