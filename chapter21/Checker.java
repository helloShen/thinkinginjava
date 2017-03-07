/**
 *  Test Lock
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class Checker{
    private TestLock tl;
    public Checker(TestLock tl){this.tl=tl;}
    public TestLock getTL(){return tl;}

    //main execute the runnable
    public static void main(String[] args){
        Checker ck=new Checker(new TestLock());
        ExecutorService es=Executors.newCachedThreadPool();
        
        es.execute(new Runnable(){
            long stop=System.currentTimeMillis()+10;
            @Override
            public void run(){
                while(System.currentTimeMillis()<stop){
                    //synchronized(ck.getTL()){
                        ck.getTL().increment();
                    //}
                }
            }
        });
        es.execute(new Runnable(){
            @Override
            public void run(){
                long stop=System.currentTimeMillis()+10;
                while(System.currentTimeMillis()<stop){
                    int num;
                    //synchronized(ck.getTL()){
                        num=ck.getTL().getNum();
                    //}
                    if(num%2!=0){
                        System.out.println(num);
                        Thread.yield();
                    }
                }
            }
        });
        es.shutdown();
    }
}