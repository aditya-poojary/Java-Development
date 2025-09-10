package com.telusko.learning;

public class ReverseString {
    public String reverseString (String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while ( l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
        return new String(arr);
    }
}
