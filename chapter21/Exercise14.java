/**
 *  Exercise 14
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise14{
    public static void action(){
        for(int i=0;i<1000;i++){
            new Timer().schedule(new TimerTask(){
                public void run(){
                    for(int j=5;j>0;j--){
                        System.out.println("#"+Thread.currentThread().getName()+ " >>> " +j);
                        try{
                            Thread.sleep(1000);
                        }catch(InterruptedException ie){
                            System.out.println("Sleep Interrupted!");
                        }
                    }
                }
            },6000);
        }
    }
    
    public static void main(String[] args){
        Exercise14.action();
    }
}