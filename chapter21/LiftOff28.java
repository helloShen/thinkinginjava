/**
 *  Exercise 20
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.lang.Thread.*;

public class LiftOff28 implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    private long begin,end;
    public LiftOff28() {}
    public LiftOff28(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    public void run(){
        try{
            begin=System.currentTimeMillis();
            while(!Thread.interrupted() && countDown-- > 0) {
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }finally{
            System.out.println("Thread#"+Thread.currentThread().getName()+" --> Task#["+id+"] recieve the Interruption signal after "+((System.currentTimeMillis()-begin)/(float)1000)+" seconds!");
        }
    }
}