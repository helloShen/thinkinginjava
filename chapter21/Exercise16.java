/**
 *  Exercise 16
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.locks.*;

public class Exercise16 implements Runnable{
    private volatile String str;
    public Exercise16(String name){str=name;}
    private Lock lock=new ReentrantLock();
    public class Aaa implements Runnable{
        public void run(){
            lock.lock();
            try{
                str=str.substring(0,4);
                str+="AAA";
            }finally{
                lock.unlock();
            }
        }
    }
    public class Bbb implements Runnable{
        public void run(){
            lock.lock();
            try{
                str=str.substring(0,4);
                str+="BBB";
            }finally{
                lock.unlock();
            }
        }
    }
    public class Ccc implements Runnable{
        public void run(){
            lock.lock();
            try{
                str=str.substring(0,4);
                str+="CCC";
            }finally{
                lock.unlock();
            }
        }
    }
    public void run(){
        lock.lock();
        try{
            System.out.println(str);
        }finally{
            lock.unlock();
        }
    }
    public static void main(String[] args){
        ExecutorService executor=Executors.newCachedThreadPool();
        Random rand=new Random();
        int x=0;
        Exercise16 theMain=new Exercise16("STR-");
        Runnable aaa=theMain.new Aaa(), bbb=theMain.new Bbb(), ccc=theMain.new Ccc();
        for(int i=0;i<100;i++){
            x=rand.nextInt(3);
            switch(x){
                case 0:
                    executor.execute(aaa); break;
                case 1:
                    executor.execute(bbb); break;
                case 2:
                    executor.execute(ccc); break;
            }
            executor.execute(theMain);
        }
        executor.shutdown();
    }
}