/**
 *  Exercise 12,13
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise12 implements Runnable{
    private volatile int i=0;
    private int duration;
    public Exercise12(int duration){
        this.duration=duration;
    }
    public synchronized void f3(){
        //System.out.println(Thread.currentThread().getName()+"#f3() @ "+System.currentTimeMillis());
        i++;i++;i++;
    }
    public void run(){
        long stop=System.currentTimeMillis()+duration;
        //System.out.println("#stop @ "+stop);
        while(System.currentTimeMillis()<stop){
            //System.out.println(Thread.currentThread().getName()+"#run() @ "+System.currentTimeMillis());
            f3();
        }
        Thread.yield();
    }
    public int getValue(){return i;}
    
    public class Checker implements Runnable{
        public void check(){
            int value;
            synchronized(Exercise12.this){
                value=getValue();
            }
            if(value%3!=0){
                System.out.println(value);
            }
        }
        public void run(){
            while(true){
                //System.out.println(Thread.currentThread().getName()+"#check() @ "+System.currentTimeMillis());
                check();
                Thread.yield();
            }
        }
    }
    
    public static void main(String[] args){
        ExecutorService mainService=Executors.newCachedThreadPool();
        ExecutorService daemonService=Executors.newCachedThreadPool(new ThreadFactory(){
            public Thread newThread(Runnable r){
                Thread th=new Thread(r);
                th.setDaemon(true);
                return th;
            }
        });
        Exercise12 task=new Exercise12(10);
        Checker checker=task.new Checker();
        
        mainService.execute(task);
        daemonService.execute(checker);
        
        mainService.shutdown();
        daemonService.shutdown();
    }
}