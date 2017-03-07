/**
 * FastSimulation.java
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class FastSimulation{
    private static final int N_ELEMENTS=100000;
    private static final int N_GENES=30;
    private static final int N_EVOLVERS=50;
    private static final AtomicInteger[][] GRID=new AtomicInteger[N_ELEMENTS][N_GENES];
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

                    int oldValue=GRID[element][i].get();
                    int newValue=(oldValue+GRID[element][previous].get()+GRID[element][next].get())/3;

                    if(!GRID[element][i].compareAndSet(oldValue,newValue)){
                        System.out.println("Change failed!");
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
                GRID[i][j]=new AtomicInteger(rand.nextInt(1000));
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
