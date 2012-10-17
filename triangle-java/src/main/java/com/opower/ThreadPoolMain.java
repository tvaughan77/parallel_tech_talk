package com.opower;


import com.opower.trianglejava.Factors;
import com.opower.trianglejava.TriangleNumbers;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.lang3.time.StopWatch;

/**
 *  Find the first triangle number to have over 500 unique factors
 */
public class ThreadPoolMain extends AbstractTriangleProcess {
    // My Mac has 2 hyperthreaded cores, so I think 4 is a good guess to start with since this whole problem is CPU-bound.
    private final static int THREAD_POOL_SIZE = 4;
    private final static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static CompletionService<Result> completionService = new ExecutorCompletionService<Result>(executorService);
    static {
        System.out.println("Number of processors = " + Runtime.getRuntime().availableProcessors());
    }
    
    public static void main( String[] args ) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        for (int i=1; i<=SEARCH_LIMIT; i++) {
            final int triangleIndex = i;
            completionService.submit(new Callable<Result>() {
                @Override
                public Result call() throws Exception {
                    Long triangleNumber = TriangleNumbers.get(triangleIndex);
                    Integer[] factors = Factors.factors(triangleNumber);
                    return new Result(triangleIndex, triangleNumber, factors);
                }
            });
        }
        
        try {
            for (int i=0; i<=SEARCH_LIMIT; i++) {
                Future<Result> resultFuture = completionService.take();
                Result result = resultFuture.get();
                
                printUpdate(stopWatch, result.triangleIndex, result.triangleNumber, result.factors);
                
                // Note that there's a subtle possible bug here where the return order of futures could give me different
                // answers;  Technically, I should look at the return values of any outstanding futures and decide which
                // of the 4 was the result that exceeded the FACTOR_LIMIT with the lowest-valued triangleNumber
                if (result.factors.length > FACTOR_LIMIT) {
                    stopWatch.stop();
                    printSolution(result.triangleNumber, result.triangleIndex, result.factors.length, stopWatch.toString()) ;
                    executorService.shutdown();
                    break;
                }
            }
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();  // what else could/should I do here?
        }
        catch (ExecutionException ee) {
            ee.printStackTrace();  // what else could/should I do here?
        }
    }
    
    static class Result {
        public Integer triangleIndex;
        public Long triangleNumber;
        public Integer[] factors;
        public Result(Integer triangleIndex, Long triangleNumber, Integer[] factors) {
            this.triangleIndex = triangleIndex;
            this.triangleNumber = triangleNumber;
            this.factors = factors;
        }
    }
}