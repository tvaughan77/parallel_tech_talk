package com.opower;

import com.opower.trianglejava.Factors;
import com.opower.trianglejava.TriangleNumbers;
import org.apache.commons.lang3.time.StopWatch;

/**
 *  Find the first triangle number to have over 500 unique factors
 */
public class BruteForceMain extends AbstractTriangleProcess {
    
    public static void main( String[] args ) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        for (int i=1; i<=SEARCH_LIMIT; i++) {
        
            Long triangleNumber = TriangleNumbers.get(i);
            
            Integer[] factors = Factors.factors(triangleNumber);
            
            printUpdate(stopWatch, i, triangleNumber, factors);

            if (factors.length > FACTOR_LIMIT) {
                stopWatch.stop();
                printSolution(triangleNumber, i, factors.length, stopWatch.toString());
                break;
            }
        }
    }
}
