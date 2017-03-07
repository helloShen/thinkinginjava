/**
 *  Test Lock
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class Checker2{
    private volatile TestLock tl;
    public Checker2(TestLock tl){this.tl=tl;}
    
    public class Run implements Runnable{
        @Override
        public void run(){
            //synchronized(Checker2.this){  //不行
                long stop=System.currentTimeMillis()+10;
                while(System.currentTimeMillis()<stop){
                    synchronized(tl){   //这里可以
                        tl.increment();
                    }
                }
            //}
        }
    }
    public class Check implements Runnable{
        @Override
        public void run(){
            //synchronized(Checker2.this){  //不行
                long stop=System.currentTimeMillis()+10;
                int num;
                while(System.currentTimeMillis()<stop){
                    synchronized(tl){   //这里可以
                        num=tl.getNum();
                    }
                    if(num%2!=0){
                        System.out.println(num);
                        Thread.yield();
                    }
                }
            //}
        }
    }
    //main execute the runnable
    public static void main(String[] args){
        Checker2 ck=new Checker2(new TestLock());
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(ck.new Run());
        es.execute(ck.new Check());
        es.shutdown();
    }
}