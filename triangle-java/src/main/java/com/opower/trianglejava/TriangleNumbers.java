package com.opower.trianglejava;

import java.util.HashMap;
import java.util.Map;

/**
 * The sequence of triangle numbers is generated by adding the natural numbers. 
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. 
 * 
 * Note that computing TriangleNumbers lends itself to a dynamic programming approach.  Asking for the Nth
 * triangle number should look to see if we've already computed the N-1th triangle number and then just add
 * N to that value.  This class maintains an internal lookup Map to implement that dynamic programming approach.
 * 
 * This approach will improve speed in a single-threaded situation but may actually make things worse in a 
 * parallel situation because of the aggressive synchronization locking I'm using.
 * 
 * @author tomvaughan
 */
public final class TriangleNumbers {
    
    private TriangleNumbers() {
    }
    
    private static Map<Integer, Long> triangles = new HashMap<Integer, Long>();
    static {
        triangles.put(1, 1L);  // seed it with our 1st triangleNumber to allow for recursion in our "get()" method
    }
    
    /**
     * @param index The requested triangle number, as an index. Like "gimme the 7th triangle number"
     * @return The nTh triangle number.  E.g. "The get(7) th triangle number is 28"
     */
    public static synchronized Long get(int index) {
        assert index > 0;
        
        if (triangles.get(index) != null) {
            return triangles.get(index);
        }
        else {
            Long previousNumber = triangles.get(index - 1);
            if (previousNumber == null) {
                previousNumber = get(index - 1);           // note the re-entrant recursion here.
            }
            
            Long triangleNumber = previousNumber + index;
            triangles.put(index, triangleNumber);
            return triangleNumber;
        }
    }
}
