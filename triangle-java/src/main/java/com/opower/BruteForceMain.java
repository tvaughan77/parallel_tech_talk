package com.opower;

import com.opower.trianglejava.Factors;
import com.opower.trianglejava.TriangleNumbers;
import org.apache.commons.lang3.time.StopWatch;

/**
 *  Find the first triangle number to have over 500 unique factors
 */
public class BruteForceMain 
{
    // Find the first number that has more than this number of factors
    private final static Integer FACTOR_LIMIT = 500;
    // The maximum triangle number (the nTh one, not its actual value) to search up to.
    private final static Integer SEARCH_LIMIT = 50000;
    
    public static void main( String[] args )
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=1; i<=SEARCH_LIMIT; i++) {
            Long triangleNumber = TriangleNumbers.get(i);
            Integer[] factors = Factors.factors(triangleNumber);
            
            stopWatch.suspend();
            System.out.print(String.format("%10d is a triangle number with %4d factors:", triangleNumber,factors.length));
            System.out.println(Factors.printFactors(new Long(i), factors));
            stopWatch.resume();

            if (factors.length > FACTOR_LIMIT) {
                stopWatch.stop();
                System.out.println("");
                System.out.println(triangleNumber + " is the first triangle number (the " + i + "th) "
                        + "to have at least " + FACTOR_LIMIT + " factors (it has " + factors.length + " factors)");
                System.out.println("Finding this solution took " + stopWatch.toString());
                break;
            }
        }
    }
}
