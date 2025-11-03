package com.example;

import java.util.Arrays;

public class SortingArray {

    public int[] sortArray(int[] arr) {
        for (int i = 0; i < 1000000; i++) {
            Arrays.sort(arr);
        }
        return arr;
    }
    
}
