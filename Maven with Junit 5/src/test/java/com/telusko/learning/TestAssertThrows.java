package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class demonstrates the usage of assertThrows in JUnit 5
 * 
 * assertThrows() - Validates that a specific exception is thrown
 * It's used to test error handling and exceptional cases in your code
 */
class TestAssertThrows {

    // ============= Basic assertThrows Examples =============
    
    /**
     * PASSING TEST: assertThrows with ArithmeticException
     * This test will PASS because dividing by zero throws ArithmeticException
     */
    @Test
    void testDivideByZero_ThrowsException() {
        // Assert that dividing by zero throws ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }
    
    /**
     * PASSING TEST: assertThrows with custom error message
     * This test will PASS and shows how to add a custom message
     */
    @Test
    void testDivideByZero_WithMessage() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 100 / 0;
        }, "Division by zero should throw ArithmeticException");
    }
    
    /**
     * PASSING TEST: assertThrows with NullPointerException
     * This test will PASS because calling method on null throws NullPointerException
     */
    @Test
    void testNullPointerException() {
        String text = null;
        
        // Assert that calling length() on null string throws NullPointerException
        assertThrows(NullPointerException.class, () -> {
            int length = text.length();
        }, "Calling method on null should throw NullPointerException");
    }
    
    /**
     * PASSING TEST: assertThrows with ArrayIndexOutOfBoundsException
     * This test will PASS because accessing invalid index throws exception
     */
    @Test
    void testArrayIndexOutOfBounds() {
        int[] numbers = {1, 2, 3, 4, 5};
        
        // Assert that accessing index 10 (out of bounds) throws exception
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int value = numbers[10];
        }, "Accessing invalid array index should throw ArrayIndexOutOfBoundsException");
    }

    
    // ============= Capturing Exception for Further Validation =============
    
    /**
     * PASSING TEST: Capturing exception to validate its message
     * This test will PASS and also verifies the exception message
     */
    @Test
    void testExceptionMessage() {
        // Capture the thrown exception
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int result = 50 / 0;
        });
        
        // Verify the exception message contains expected text
        String expectedMessage = "/ by zero";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), 
            "Exception message should contain: " + expectedMessage);
    }
    
    /**
     * PASSING TEST: Capturing NumberFormatException and validating message
     * This test will PASS because parsing invalid number throws exception
     */
    @Test
    void testNumberFormatException_WithMessageValidation() {
        String invalidNumber = "ABC123";
        
        // Assert that parsing invalid string throws NumberFormatException
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt(invalidNumber);
        }, "Parsing invalid number should throw NumberFormatException");
        
        // Validate the exception message
        assertNotNull(exception.getMessage(), "Exception should have a message");
        System.out.println("Exception message: " + exception.getMessage());
    }

    
    // ============= Testing Custom Methods =============
    
    /**
     * PASSING TEST: Testing custom method that throws exception
     * This test will PASS because validateAge throws exception for negative age
     */
    @Test
    void testValidateAge_NegativeAge() {
        // Assert that negative age throws IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateAge(-5);
        });
        
        // Verify exception message
        assertEquals("Age cannot be negative", exception.getMessage());
    }
    
    /**
     * PASSING TEST: Testing email validation that throws exception
     * This test will PASS because invalid email throws exception
     */
    @Test
    void testValidateEmail_InvalidFormat() {
        String invalidEmail = "notanemail";
        
        // Assert that invalid email throws IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateEmail(invalidEmail);
        }, "Invalid email should throw exception");
        
        // Verify the error message
        assertTrue(exception.getMessage().contains("Invalid email"),
            "Exception message should indicate invalid email");
    }
    
    /**
     * PASSING TEST: Testing withdrawal with insufficient balance
     * This test will PASS because withdrawing more than balance throws exception
     */
    @Test
    void testWithdraw_InsufficientBalance() {
        double balance = 100.0;
        double withdrawAmount = 500.0;
        
        // Assert that insufficient balance throws IllegalStateException
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            withdraw(balance, withdrawAmount);
        });
        
        // Verify exception message contains both amounts
        String message = exception.getMessage();
        assertTrue(message.contains("Insufficient"), "Message should mention insufficient balance");
    }

    
    // ============= Multiple Exception Types =============
    
    /**
     * PASSING TEST: Testing that specific exception type is thrown
     * This test will PASS because we're testing for the exact exception type
     */
    @Test
    void testSpecificExceptionType() {
        // This will throw NumberFormatException (which extends IllegalArgumentException)
        // But we're testing for NumberFormatException specifically
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("Not a number!");
        });
    }
    
    /**
     * PASSING TEST: Testing with parent exception class
     * This test will PASS because NumberFormatException is a type of IllegalArgumentException
     */
    @Test
    void testParentExceptionType() {
        // NumberFormatException extends IllegalArgumentException
        // So this assertion will also pass
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("12.34");
        }, "NumberFormatException is a subclass of IllegalArgumentException");
    }

    
    // ============= Real-World Examples =============
    
    /**
     * PASSING TEST: Testing file operation that throws exception
     * This test will PASS because dividing empty list throws exception
     */
    @Test
    void testCalculateAverage_EmptyList() {
        int[] emptyArray = {};
        
        // Assert that calculating average of empty array throws exception
        assertThrows(IllegalArgumentException.class, () -> {
            calculateAverage(emptyArray);
        }, "Empty array should throw IllegalArgumentException");
    }
    
    /**
     * PASSING TEST: Testing string operation that throws exception
     * This test will PASS because getting character at invalid index throws exception
     */
    @Test
    void testStringCharAt_InvalidIndex() {
        String text = "Hello";
        
        // Assert that accessing character at invalid index throws StringIndexOutOfBoundsException
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            char c = text.charAt(100);
        }, "Invalid index should throw StringIndexOutOfBoundsException");
    }

    
    // ============= Helper Methods (Methods being tested) =============
    
    /**
     * Validates if age is positive
     * @param age - age to validate
     * @throws IllegalArgumentException if age is negative
     */
    private void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    /**
     * Validates email format
     * @param email - email to validate
     * @throws IllegalArgumentException if email is invalid
     */
    private void validateEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format: must contain @");
        }
    }
    
    /**
     * Simulates withdrawal operation
     * @param balance - current balance
     * @param amount - amount to withdraw
     * @throws IllegalStateException if insufficient balance
     */
    private void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new IllegalStateException(
                "Insufficient balance. Balance: " + balance + ", Requested: " + amount);
        }
    }
    
    /**
     * Calculates average of array
     * @param numbers - array of numbers
     * @return average
     * @throws IllegalArgumentException if array is empty
     */
    private double calculateAverage(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Cannot calculate average of empty array");
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}
