/**
 *  Test wait(), notify() pragmatic
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class TestAssembler implements Runnable{
    private Set<TestRobot> robotPool;
    private CountDownLatch latch;
    public TestAssembler(Set<TestRobot> pool,CountDownLatch latch){
        robotPool=pool;
        this.latch=latch;
    }
    //awake robot
    public void engage(TestRobot r){
        synchronized(r){
            System.out.println("Wake up! "+r);
            r.notifyAll();
        }
    }
    //thread
    public void run(){
        try{
            latch.await();  //wait for robots creation
        }catch(InterruptedException ie){
            System.out.println("Assembler is interrupted!");
        }
        for(TestRobot r:robotPool){
            if(Thread.interrupted()){System.out.println(this+"is interrupted!");}
            engage(r);
        }
    }
}