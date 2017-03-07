/**
 *  Test wait(), notify() pragmatic
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class TestRobot implements Runnable{
    private static int count=0;
    private int id=++count;
    private String name;
    public String toString(){return "[Robot #"+id+" : "+name+"]";}

    private boolean ready=false;
    private CountDownLatch latch;
    public TestRobot(String n, CountDownLatch l, Set<TestRobot> p){
        name=n;
        latch=l;
        p.add(this);
        System.out.println(this+" created!");
    }
    //work
    public synchronized void perform(){
        if(ready!=true){System.out.println(this+" is not ready!");return;}
        System.out.println(name+" "+name+" "+name+" !");
        ready=false;
    }
    //ready to work (在锁里清点)
    public synchronized void ready() throws InterruptedException{
        ready=true;
        System.out.println(this+" is ready to work!");
        latch.countDown();
        TimeUnit.MILLISECONDS.sleep(1000);
        wait(); //release lock
    }

    //Thread
    public void run(){
        try{
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
