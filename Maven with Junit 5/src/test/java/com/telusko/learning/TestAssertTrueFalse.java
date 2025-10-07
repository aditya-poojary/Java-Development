package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class demonstrates the usage of assertTrue and assertFalse in JUnit 5
 * 
 * assertTrue() - Validates that a condition is true
 * assertFalse() - Validates that a condition is false
 */
class TestAssertTrueFalse {

    // ============= assertTrue Examples =============
    
    /**
     * PASSING TEST: assertTrue with a condition that evaluates to true
     * This test will PASS because 10 > 5 is true
     */
    @Test
    void testAssertTrue_Pass() {
        int number = 10;
        // Assert that the number is greater than 5
        assertTrue(number > 5, "Number should be greater than 5");
    }
    
    /**
     * FAILING TEST: assertTrue with a condition that evaluates to false
     * This test will FAIL because 3 > 5 is false
     * The error message will help identify why it failed
     */
    @Test
    void testAssertTrue_Fail() {
        int number = 3;
        // This will fail because 3 is NOT greater than 5
        assertTrue(number > 5, "Expected number to be greater than 5, but got: " + number);
    }
    
    /**
     * PASSING TEST: assertTrue with boolean method
     * This test will PASS because the string is not empty
     */
    @Test
    void testAssertTrue_StringNotEmpty_Pass() {
        String text = "Hello World";
        // Check if string is not empty
        assertTrue(!text.isEmpty(), "String should not be empty");
    }
    
    /**
     * PASSING TEST: assertTrue with multiple conditions
     * This test will PASS because both conditions are true
     */
    @Test
    void testAssertTrue_MultipleConditions_Pass() {
        int age = 25;
        // Check if age is within valid range (18-65)
        assertTrue(age >= 18 && age <= 65, "Age should be between 18 and 65");
    }

    
    // ============= assertFalse Examples =============
    
    /**
     * PASSING TEST: assertFalse with a condition that evaluates to false
     * This test will PASS because 5 > 10 is false
     */
    @Test
    void testAssertFalse_Pass() {
        int number = 5;
        // Assert that the number is NOT greater than 10
        assertFalse(number > 10, "Number should not be greater than 10");
    }
    
    /**
     * FAILING TEST: assertFalse with a condition that evaluates to true
     * This test will FAIL because 15 > 10 is true (we expected false)
     */
    @Test
    void testAssertFalse_Fail() {
        int number = 15;
        // This will fail because 15 IS greater than 10 (condition is true, we expected false)
        assertFalse(number > 10, "Expected number to NOT be greater than 10, but got: " + number);
    }
    
    /**
     * PASSING TEST: assertFalse with boolean method
     * This test will PASS because the string is NOT empty (isEmpty() returns false)
     */
    @Test
    void testAssertFalse_StringEmpty_Pass() {
        String text = "JUnit 5";
        // Check that string is not empty
        assertFalse(text.isEmpty(), "String should not be empty");
    }
    
    /**
     * PASSING TEST: assertFalse to check null condition
     * This test will PASS because the object is not null
     */
    @Test
    void testAssertFalse_NotNull_Pass() {
        String name = "John Doe";
        // Check that name is not null
        assertFalse(name == null, "Name should not be null");
    }
    
    /**
     * PASSING TEST: assertFalse with negative condition
     * This test will PASS because the number is positive (not negative)
     */
    @Test
    void testAssertFalse_NotNegative_Pass() {
        int balance = 100;
        // Check that balance is not negative
        assertFalse(balance < 0, "Balance should not be negative");
    }

    
    // ============= Real-world Examples =============
    
    /**
     * PASSING TEST: Real-world example - Email validation
     * This test will PASS because the email contains '@'
     */
    @Test
    void testEmailContainsAtSymbol_Pass() {
        String email = "user@example.com";
        // Verify email contains @ symbol
        assertTrue(email.contains("@"), "Valid email must contain @ symbol");
    }
    
    /**
     * PASSING TEST: Real-world example - Password strength check
     * This test will PASS because password length is adequate
     */
    @Test
    void testPasswordStrength_Pass() {
        String password = "SecurePass123";
        // Password should be at least 8 characters
        assertTrue(password.length() >= 8, "Password must be at least 8 characters long");
    }
    
    /**
     * PASSING TEST: Real-world example - Discount eligibility
     * This test will PASS because purchase amount qualifies for discount
     */
    @Test
    void testDiscountEligibility_Pass() {
        double purchaseAmount = 150.0;
        double minimumForDiscount = 100.0;
        // Customer should get discount if purchase is >= 100
        assertTrue(purchaseAmount >= minimumForDiscount, 
            "Purchase of $" + purchaseAmount + " should qualify for discount");
    }
}
