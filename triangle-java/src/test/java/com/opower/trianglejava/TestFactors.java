package com.opower.trianglejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomvaughan
 */
public class TestFactors {
    
    @Test(expected=java.lang.AssertionError.class)
    public void testFactorsOf0() {
        testFactors(0);
    }
    
    @Test
    public void testFactorsOf1() {
        testFactors(1, 1);
    }
    
    @Test
    public void testFactorsOf2() {
        testFactors(2, 1, 2);
    }
    
    @Test
    public void testFactorsOf3() {
        testFactors(3, 1, 3);
    }
    
    @Test
    public void testFactorsOf4() {
        testFactors(4, 1, 2, 4);
    }
    
    @Test
    public void testFactorsOf6() {
        testFactors(6, 1, 2, 3, 6);
    }
    
    @Test
    public void testFactorsOf28() {
        testFactors(28, 1, 2, 4, 7, 14, 28);
    }



    private void testFactors(Integer number, Integer... expected) {
        Integer[] factors = Factors.factors(number);
//        System.out.println(Factors.printFactors(number, factors));
        assertEquals(expected.length, factors.length);
        for (int i=0; i<expected.length; i++) {
            assertEquals(expected[i], factors[i]);
        }
    }
}
