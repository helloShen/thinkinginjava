/**
 *  Exercise 15
 *  取消注释，换成synchronized(this)，就变成对三个不同的对象加同步锁。同步就被破坏。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise15 implements Runnable{
    private volatile String str;
    public Exercise15(String name){str=name;}
    public class Aaa implements Runnable{
        public void run(){
            //synchronized (this){
            synchronized (Exercise15.this){
                str=str.substring(0,4);
                str+="AAA";
            }
        }
    }
    public class Bbb implements Runnable{
        public void run(){
            //synchronized (this){
            synchronized (Exercise15.this){
                str=str.substring(0,4);
                str+="BBB";
            }
        }
    }
    public class Ccc implements Runnable{
        public void run(){
            //synchronized (this){
            synchronized (Exercise15.this){
                str=str.substring(0,4);
                str+="CCC";
            }
        }
    }
    public void run(){
        synchronized(this){
            System.out.println(str);
        }
    }
    public static void main(String[] args){
        ExecutorService executor=Executors.newCachedThreadPool();
        Random rand=new Random();
        int x=0;
        Exercise15 theMain=new Exercise15("STR-");
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