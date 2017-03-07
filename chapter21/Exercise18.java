/**
 *  Exercise 18
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise18{
    public Exercise18(){
        try{
            System.out.println("I am awake!");
            long begin=System.currentTimeMillis()+1000;
            while(!Thread.interrupted()){
                if(System.currentTimeMillis()>=begin){
                    System.out.println("Sleeping...");
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("I am awake!");
                    begin=System.currentTimeMillis()+1000;
                }
            }
            System.out.println("Interrupted in daytime!");
        }catch(InterruptedException ie){
            System.out.println("Interrupted while sleeping!");
        }
    }
    public static class GotoSleep implements Runnable{
        public void run(){
            new Sleep();
        }
    }
    
    public static void main(String[] args){
        ExecutorService es=Executors.newCachedThreadPool();
        Future<?> f=es.submit(new Exercise18.GotoSleep());
        es.shutdown();
        try{
            TimeUnit.MILLISECONDS.sleep((long)(new Random().nextInt(10000)));
        }catch(InterruptedException ie){
            System.out.println("Test Interrupted!");
        }finally{
            f.cancel(true);
        }

    }
}