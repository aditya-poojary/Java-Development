package com.telusko.learning;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestAssertArrayEquals {
    @Test
    void testArrays() {

        int[] expected = {2,4,6,8};
        int[] actual = {2,4,6,8};
    
        assertArrayEquals(expected, actual);
    }
}
