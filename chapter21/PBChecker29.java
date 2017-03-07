/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class PBChecker29 implements Runnable{
    private ToastQueue29 peanutButteredQueue;
    private ToastQueue29 jammeQueue;
    private ToastQueue29 finishQueue;
    public PBChecker29(ToastQueue29 pbdq, ToastQueue29 jmq, ToastQueue29 fq){
        peanutButteredQueue=pbdq;
        jammeQueue=jmq;
        finishQueue=fq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast29 t=peanutButteredQueue.take();
                switch(t.getStatus()){
                    case DRY:
                        System.out.println("ERROR: "+t+" still DRY, cannot PeanutButter!!!");break;
                    case PBD:
                        jammeQueue.put(t);break;
                    case JMD:
                        System.out.println("ERROR: "+t+" need to be PeanutButtered!!!");break;
                    case FINISH:
                        finishQueue.put(t);break;
                }
            }
        }catch(InterruptedException ie){
            System.out.println("Toaster29 interrupted!");
        }finally{
            System.out.println("Toaster29 exit!");
        }
    }
}