package com.opower;


import org.apache.commons.lang3.time.StopWatch;

/**
 *  Find the first triangle number to have over 500 unique factors
 */
public class ThreadPoolMain 
{
    // Find the first number that has more than this number of factors
    private final static Integer FACTOR_LIMIT = 500;
    // The maximum triangle number (the nTh one, not its actual value) to search up to.
    private final static Integer SEARCH_LIMIT = 50000;
    
    public static void main( String[] args )
    {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
    }
}