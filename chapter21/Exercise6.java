/**
 *  Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;
import java.util.concurrent.*;

public class Exercise6 implements Runnable{
    private static int count=0;
    private int id=++count;
    private Random rand=new Random();
    public void run(){
        int x=rand.nextInt(10);
        try{
            TimeUnit.MILLISECONDS.sleep((long)((x+1)*1E3));
            System.out.println("#"+id+"> Sleeped "+(x+1)+" second!");
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
    }
    public static void main(String[] args){
        ExecutorService ex=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            ex.execute(new Exercise6());
        }
        ex.shutdown();
    }
}