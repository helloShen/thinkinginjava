/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise11 implements Runnable{
    public static class ThreadFactory11 implements ThreadFactory{
        private int count=0;
        public Thread newThread(Runnable r){
            return new Thread(r,String.valueOf(++count));
        }
    }
    
    private volatile int base1=1;
    private volatile int base2=1;
    
    //public void fiboNext(){
    public synchronized void fiboNext(){
        int sum=base1+base2;
        base1=base2;
        Thread.yield();
        base2=sum;
    }
    
    //public void show(){
    public synchronized void show(){
        System.out.println("Thread #"+Thread.currentThread().getName()+" >>> "+String.valueOf(base1)+"+"+String.valueOf(base2)+"="+String.valueOf(base1+base2));
    }
    
    //public void run(){
    public synchronized void run(){
        for(int i=0;i<5;i++){
            fiboNext();
            show();
        }
    }
    

    public static void main(String[] args){
        Runnable r=new Exercise11();
        ExecutorService es=Executors.newCachedThreadPool(new ThreadFactory11());
        for(int i=0;i<5;i++){
            es.execute(r);
        }
        es.shutdown();
    }
    
}