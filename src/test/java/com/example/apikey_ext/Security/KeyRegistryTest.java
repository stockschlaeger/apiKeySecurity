package com.example.apikey_ext.Security;

import com.example.apikey_ext.HandlingErrors.UnauthenticatedException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyRegistryTest {

    static KeyRegistry keyregistry;
    static String EXPECTED = "testing";

    @BeforeAll
    public static void setUp() {
        keyregistry = new KeyRegistry();
    }

    @Test
    void startup() {
        assertNotNull(keyregistry.registry);
        assertEquals(keyregistry.registry.get("API_Header").getValue(), EXPECTED);
    }

    @Test
    void check() throws UnauthenticatedException {

        assertThrows(UnauthenticatedException.class, () -> keyregistry.check("blabla"));
        assertDoesNotThrow(() -> {
            keyregistry.check(EXPECTED);
        });

    }
}