package com.telusko.learning;
import static org.junit.Assert.*;
import org.junit.Test;



public class CalcTest {
    @Test
    public void test(){
        Calc c = new Calc();
        int result = c.divide(10, 2);
        int expected = 5;
        assertEquals(expected, result);
    }    
}
