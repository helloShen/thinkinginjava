/**
 *  Exercise 1
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise1 implements Runnable{
    private static int count=0;
    private int id=++count;
    private int max=10;
    public Exercise1(){System.out.println("Operation NO."+id+" initialized ... ");}
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("#"+id+"("+(max--)+")");
            Thread.yield();
        }
        System.out.println("Operation NO."+id+" is finished!");
        return;
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new Thread(new Exercise1()).start();
        }
    }
}