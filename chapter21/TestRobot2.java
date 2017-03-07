/**
 *  Robot是共享资源。每人头顶互斥锁。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class TestRobot2 implements Runnable{
    private static int count=0;
    private int id=++count;
    private String name;
    private TestAssembler2 assembler=null;
    private boolean ready=false;
    public String toString(){return "[Robot #"+id+" : "+name+"]";}
    public boolean isReady(){return ready;}
    
    public TestRobot2(String n, Set<TestRobot2> p){  //不需要反向注入持有它的pool
        name=n;
        p.add(this);
        System.out.println(this+" created!");
    }
    //work
    public synchronized void perform(){
        System.out.println(name+" "+name+" "+name+" on "+assembler+"!");
        desBanding();
        ready=false;
    }
    //ready to work
    public synchronized void ready() throws InterruptedException{
        ready=true;
        System.out.println(this+" is ready to work!");
        TimeUnit.MILLISECONDS.sleep(100);   //因为加了锁，sleep不影响线程安全
        notifyAll();    //万一已经有Assembler等着了
        wait(); //release lock
    }
    public synchronized void banding(TestAssembler2 a){assembler=a;}
    public synchronized void desBanding(){assembler=null;}
    
    //Thread
    public void run(){
        try{
            TimeUnit.MILLISECONDS.sleep(100);
            while(!Thread.interrupted()){
                ready();    //ready and wait
                perform();  //work
            }
            System.out.println("Robot exit!");
        }catch(InterruptedException ie){
            System.out.println("Robot interrupted in waiting!");
        }
    }
}