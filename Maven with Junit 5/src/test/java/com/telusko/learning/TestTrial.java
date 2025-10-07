package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTrial {

    @Test
    void test() {
        assertEquals(6, 6);
    }

    @Test
    void testWithErrorMessage() {
        assertEquals(7, 8, ()-> "Optional error message"); 
    }
}
