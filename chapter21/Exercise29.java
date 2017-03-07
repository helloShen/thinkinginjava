/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise29{
    public static void main(String[] args){
        ToastQueue29 queuePB=new ToastQueue29();
        ToastQueue29 queueJM=new ToastQueue29();
        ToastQueue29 queuePBD=new ToastQueue29();
        ToastQueue29 queueJMD=new ToastQueue29();
        ToastQueue29 queueFINISH=new ToastQueue29();
        
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(new Toaster29(queuePB));
        es.execute(new Toaster29(queueJM));
        es.execute(new PeanutButterer29(queuePB,queuePBD));
        es.execute(new Jammer29(queueJM,queueJMD));
        es.execute(new PBChecker29(queuePBD,queueJM,queueFINISH));
        es.execute(new JMChecker29(queueJMD,queuePB,queueFINISH));
        es.execute(new Eater29(queueFINISH));
        
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException ie){
            System.out.println("Test Interrupted!");
        }finally{
            es.shutdownNow();
        }
        
    }
}