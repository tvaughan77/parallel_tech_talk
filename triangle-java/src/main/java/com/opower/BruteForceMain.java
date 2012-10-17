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
    private final static Integer FACTOR_LIMIT = 1000;
    // The maximum triangle number (the nTh one, not its actual value) to search up to.
    private final static Integer SEARCH_LIMIT = 50000;
    
    public static void main( String[] args )
    {
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

    private static int BIGGEST_FACTORS_SO_FAR = 0;
    private static void printUpdate(StopWatch stopWatch, int i, Long triangleNumber, Integer[] factors) {
        if(factors.length > BIGGEST_FACTORS_SO_FAR) {
            stopWatch.suspend();
            System.out.print(String.format("%10d is triangle number #%6d with %4d factors: ", triangleNumber, i, factors.length));
            System.out.println(Factors.printFactors(triangleNumber, factors));
            BIGGEST_FACTORS_SO_FAR = factors.length;
            stopWatch.resume();    
        }
    }

    private static void printSolution(Long triangleNumber, int i, int length, String time) {
        System.out.println("");
        System.out.println(triangleNumber + " is the first triangle number (the " + i + "th) "
                + "to have at least " + FACTOR_LIMIT + " factors (it has " + length + " factors)");
        System.out.println("Finding this solution took " + time);
    }
}
