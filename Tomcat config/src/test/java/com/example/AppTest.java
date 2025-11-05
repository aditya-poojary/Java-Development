package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void greetNull() {
        assertEquals("Hello, World!", App.greet(null));
    }

    @Test
    void greetName() {
        assertEquals("Hello, Alice!", App.greet("Alice"));
    }
}
