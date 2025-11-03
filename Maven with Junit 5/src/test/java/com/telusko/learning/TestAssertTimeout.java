package com.telusko.learning;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.example.SortingArray;

public class TestAssertTimeout {
    
    @Test
    void testSortingMethod_Performance() {
        SortingArray array = new SortingArray();

        int unsorted[] = {2,5,1};

        assertTimeout(Duration.ofMillis(10), ()-> array.sortArray(unsorted), ()-> "The sorting function is takinhg time");
    }

        @Test
    void testSortingMethod_Performance2() {
        SortingArray array = new SortingArray();

        int unsorted[] = {2,5,1};

        assertTimeout(Duration.ofMillis(1), ()-> array.sortArray(unsorted), ()-> "The sorting function is takinhg time");
    }
}
