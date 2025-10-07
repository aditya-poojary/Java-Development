package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TestAssertNotEquals {
    @Test
    void testNotEquals() {
        assertNotEquals(567, 5678, "Test Succesful because it is failing");
    }

    @Test
    void testNotEqualsWithErrorMessage() {
        assertNotEquals(5678, 5678, () -> "Test Failed because both values are equal");
    }
}
