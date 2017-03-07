/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Eater29 implements Runnable{
    private ToastQueue29 finishQueue;
    public Eater29(ToastQueue29 fq){
        finishQueue=fq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast29 t=finishQueue.take();
                if(t.getStatus()!=Toast29.Status29.FINISH){
                    System.out.println("ERROR: "+t+" not Finished!");
                }else{
                    System.out.println(t+"  YAMMY! YAMMY!");
                }
            }
        }catch(InterruptedException ie){
            System.out.println("Toaster29 interrupted!");
        }finally{
            System.out.println("Toaster29 exit!");
        }
    }
}