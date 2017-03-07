/**
 *  传统的使用竞态条件下的公共资源的方法：
 *      1. 公共资源在自己的互斥锁上等着使用者唤醒。
 *      2. 使用者跑到公共资源的锁上唤醒公共资源。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class TestAssembler2 implements Runnable{
    private static int count=0;
    private int id=++count;
    public String toString(){return "[Assembler #"+id+"]";}
    
    private Set<TestRobot2> robotPool;
    public TestAssembler2(Set<TestRobot2> pool){
        robotPool=pool;
    }
    //awake robot
    public void engage(TestRobot2 r){
        synchronized(r){
            try{
                while(true){    //如果Robot没准备好，等。
                    if(r.isReady()){
                        System.out.println("Wake up! "+r);
                        r.banding(this);
                        r.notifyAll();
                        return;
                    }
                    r.wait();
                }
            }catch(InterruptedException ie){
                System.out.println(this+" call "+r+" interrupted!");
            }
        }
    }
    //thread
    public void run(){
        for(TestRobot2 r:robotPool){
            if(Thread.interrupted()){System.out.println(this+"is interrupted!");}
            engage(r);
        }
    }
}