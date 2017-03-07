/**
 *  Exercise 9
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise9 implements Runnable{
    public static class Exercise9ThreadFactory implements ThreadFactory{
        private int priority;
        public Exercise9ThreadFactory(int lev){priority=lev;}
        @Override
        public Thread newThread(Runnable r){
            Thread th=new Thread(r);
            th.setPriority(priority);
            return th;
        }
    }
    private int countDown = 5;
    private volatile double d; // No optimization
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    public void run() {
        while(true) {
            // An expensive, interruptable operation:
            for(int i = 1; i < 100000000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
    public static void main(String[] args) {
        ExecutorService exLow = Executors.newCachedThreadPool(new Exercise9.Exercise9ThreadFactory(Thread.MIN_PRIORITY));
        ExecutorService exHigh = Executors.newCachedThreadPool(new Exercise9.Exercise9ThreadFactory(Thread.MAX_PRIORITY));
        for(int i = 0; i < 5; i++){
            exLow.execute(new Exercise9());
        }
        exHigh.execute(new Exercise9());
        exLow.shutdown();
        exHigh.shutdown();
    }
}