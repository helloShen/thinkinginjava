/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Toaster29 implements Runnable{
    private ToastQueue29 toastQueue;
    private Random rand=new Random();
    
    public Toaster29(ToastQueue29 tq){toastQueue=tq;}
    public void run(){
        try{
            while(!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(100));
                Toast29 t=new Toast29();
                System.out.println(t);
                toastQueue.put(t);
            }
        }catch(InterruptedException ie){
            System.out.println("Toaster29 interrupted!");
        }finally{
            System.out.println("Toaster29 exit!");
        }
    }
}