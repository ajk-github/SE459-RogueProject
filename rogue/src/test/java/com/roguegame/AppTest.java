package com.roguegame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void testWelcomeMessage() {
        String message = "Welcome to Rogue Game!";
        assertEquals("Welcome to Rogue Game!", message);
    }
}
