package com.opower.trianglejava;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomvaughan
 */
public class TestTriangleNumbers {
    
    @Test
    public void testTriangleNumber1() {
        runTest(1, 1);
    }
    
    @Test
    public void testTriangleNumber2() {
        runTest(3, 2);
    }
    
    @Test
    public void testTriangleNumber3() {
        runTest(6, 3);
    }
    
    // Skip over asking for #4 to make sure the "rewind until I find something" functionality works
    @Test
    public void testTriangleNumber5() {
        runTest(15, 5);
    }
    
    
    @Test
    public void testTriangleNumber99() {
        runTest(4950, 99);
    }
    
    private void runTest(int expectedNumber, int index) {
        assertEquals(new Long(expectedNumber), TriangleNumbers.get(index));
        assertEquals(new Long(expectedNumber), TriangleNumbers.getDumbly(index));
    }
}
