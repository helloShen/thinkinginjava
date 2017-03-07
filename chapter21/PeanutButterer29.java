/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class PeanutButterer29 implements Runnable{
    private ToastQueue29 toastQueue;
    private ToastQueue29 peanutButterQueue;
    public PeanutButterer29(ToastQueue29 tq, ToastQueue29 pbq){
        toastQueue=tq;
        peanutButterQueue=pbq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast29 t=toastQueue.take();
                t.peanutButter();
                System.out.println(t);
                peanutButterQueue.put(t);
            }
        }catch(InterruptedException ie){
            System.out.println("Toaster29 interrupted!");
        }finally{
            System.out.println("Toaster29 exit!");
        }
    }
}