package com.telusko.learning;

import org.junit.Test;
import static org.junit.Assert.assertEquals; // Update import statements for JUnit


public class ReverseTest {
    @Test
    public void test() {
        ReverseString rs = new ReverseString();
        assertEquals("avaj", rs.reverseString("java"));
    }    

    @Test
    public void testMultipleWords() {
        ReverseString rs = new ReverseString();
        assertEquals(" rof ysae si avaj", rs.reverseString("java is easy for "));
    }    
}

// Make sure to include JUnit JAR in your classpath when compiling and running this test.
