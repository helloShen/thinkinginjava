/**
 * Exercise39.java
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;
import java.io.*;

public class Exercise39{
    private static final int N_ELEMENTS=100000;
    private static final int N_GENES=30;
    private static final int N_EVOLVERS=50;
    private static final int[][] GRID=new int[N_ELEMENTS][N_GENES];
    private static Random rand=new Random();

    public static class Evoler implements Runnable{
        public void run(){
            while(!Thread.interrupted()){
                int element=rand.nextInt(N_ELEMENTS);
                for(int i=0;i<N_GENES;i++){
                    int previous=i-1;
                    if(previous<0){previous=N_GENES-1;}
                    int next=i+1;
                    if(next==N_GENES){next=0;}
                    Lock lock=new ReentrantLock();
                    lock.lock();
                    try{
                        int oldValue=GRID[element][i];
                        int newValue=(oldValue+GRID[element][previous]+GRID[element][next])/3;
                        GRID[element][i]=newValue;
                        System.out.println(oldValue+" replaced by "+newValue);
                    }finally{
                        lock.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Press Entry to Exit!");
        ExecutorService exec=Executors.newCachedThreadPool();
        for(int i=0;i<N_ELEMENTS;i++){
            for(int j=0;j<N_GENES;j++){
                GRID[i][j]=rand.nextInt(1000);
            }
        }
        for(int i=0;i<N_EVOLVERS;i++){
            exec.execute(new Evoler());
        }
        try{
            System.in.read();
        }catch(IOException ie){
            System.out.println("Test interrupted!");
        }
        exec.shutdownNow();
        System.out.println("Test exit.");
    }
}
