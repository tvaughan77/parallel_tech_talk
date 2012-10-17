package com.opower.trianglejava;

import java.util.Collection;
import java.util.TreeSet;

/**
 *
 * @author tomvaughan
 */
public final class Factors {
    
    private Factors() {
    }
    
    /**
     * @param number A number to return the factors of.  e.g. "28"
     * @return an array of factors for {@code number}. e.g. [1, 2, 4, 7, 14, 28]
     */
    public static Integer[] factors(double number) {
        assert number >= 0;
        Collection<Integer> factors = new TreeSet<Integer>();
        for (int i=1; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                factors.add(i);
                factors.add((int)(number / i));
            }
        }
        
        return factors.toArray(new Integer[1]);
    }
    
    public static String printFactors(Long number, Integer[] factors) {
        StringBuilder sb = new StringBuilder("Factors of " + number + " are: [");
        for(Integer factor : factors) {
            sb.append(factor).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}
