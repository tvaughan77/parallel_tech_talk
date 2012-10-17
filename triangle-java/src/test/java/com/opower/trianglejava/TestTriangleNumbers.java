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
        assertEquals(new Long(1), TriangleNumbers.get(1));
    }
    
    @Test
    public void testTriangleNumber2() {
        assertEquals(new Long(3), TriangleNumbers.get(2));
    }
    
    @Test
    public void testTriangleNumber3() {
        assertEquals(new Long(6), TriangleNumbers.get(3));
    }
    
    // Skip over asking for #4 to make sure the "rewind until I find something" functionality works
    @Test
    public void testTriangleNumber5() {
        assertEquals(new Long(15), TriangleNumbers.get(5));
    }
    
    
    @Test
    public void testTriangleNumber99() {
        assertEquals(new Long(4950), TriangleNumbers.get(99));
    }
    
}
