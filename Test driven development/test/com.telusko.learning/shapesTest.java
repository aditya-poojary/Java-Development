package com.telusko.learning;

import org.junit.Test;
import static org.junit.Assert.*;

public class shapesTest {
    @Test
    public void testAreaOfSquare() {
        assertEquals(16.0, Shapes.areaOfSquare(4), 0.001);
    }

    @Test
    public void testAreaOfCircle() {
        assertEquals(78.539, Shapes.areaOfCircle(5), 0.001);
    }
}

// Make sure to include JUnit JAR in your classpath when compiling and running this test.
