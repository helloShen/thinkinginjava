/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class JMChecker29 implements Runnable{
    private ToastQueue29 jammedQueue;
    private ToastQueue29 peanutButterQueue;
    private ToastQueue29 finishQueue;
    public JMChecker29(ToastQueue29 jmdq, ToastQueue29 pbq, ToastQueue29 fq){
        jammedQueue=jmdq;
        peanutButterQueue=pbq;
        finishQueue=fq;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast29 t=jammedQueue.take();
                switch(t.getStatus()){
                    case DRY:
                        System.out.println("ERROR: "+t+" still DRY, cannot Jamme!!!");break;
                    case PBD:
                        System.out.println("ERROR: "+t+" need to be Jammed!!!");break;
                    case JMD:
                        peanutButterQueue.put(t);break;
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