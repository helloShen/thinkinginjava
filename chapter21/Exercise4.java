/**
 *  Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise4 {
    
    public static void testDifferentThreadPool(ExecutorService ex){
        for(int i=0;i<10;i++){
            ex.execute(new Fibonacci(i+5));
        }
        ex.shutdown();
    }
    
    public static void main(String[] args){
        Exercise4.testDifferentThreadPool(Executors.newCachedThreadPool());
        Exercise4.testDifferentThreadPool(Executors.newFixedThreadPool(5));
        Exercise4.testDifferentThreadPool(Executors.newScheduledThreadPool(5));
        Exercise4.testDifferentThreadPool(Executors.newSingleThreadExecutor());
    }
}