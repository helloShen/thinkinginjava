/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Jammer29 implements Runnable{
    private ToastQueue29 toastQueue;
    private ToastQueue29 jammeQueue;
    public Jammer29(ToastQueue29 tq, ToastQueue29 jmq){
        toastQueue=tq;
        jammeQueue=jmq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast29 t=toastQueue.take();
                t.jamme();
                System.out.println(t);
                jammeQueue.put(t);
            }
        }catch(InterruptedException ie){
            System.out.println("Toaster29 interrupted!");
        }finally{
            System.out.println("Toaster29 exit!");
        }
    }
}