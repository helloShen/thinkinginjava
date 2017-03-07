/**
 *  Test ThreadFactory
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class TestThreadFactory{
    public static class MyFacotry implements ThreadFactory{
        public Thread newThread(Runnable r){
            Thread th=new Thread(r);
            System.out.println(this+" is created!");
            return th;
        }
    }
    public static void main(String[] args){
        ExecutorService es=Executors.newCachedThreadPool(new MyFacotry());
        es.execute(new Fibonacci(10));
        es.shutdown();
    }
}