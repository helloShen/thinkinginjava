/**
 *  Exercise 32
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

/**
 *  主测试线程会创建所有旋转门线程和一个总的控制线程。
 */
public class Exercise32 implements Runnable{
    /**
     *  静态成员
     */
    //探测器容器
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    //静态计算总次数系统，因为和非静态成员CountDownLatch无关
    private static volatile int count=0;
    public static synchronized void sumEntrances() {
        for(Entrance entrance : entrances){
            count += entrance.getValue();
        }
    }
    public static int getTotalCount() {
        return count;
    }
    
    

    /**
     *  非静态成员。关键就是初始化本次实验的探测器的总数。
     */
    private final CountDownLatch latch;
    private final int entranceNum;
    private Runnable sumCounter;
    public Exercise32(int num){
        latch=new CountDownLatch(num);
        entranceNum=num;
        
        new Thread(this).start();   //构造器运行实验
    }
    public void run(){
        System.out.println("Press Entry key to stop!");
        ExecutorService execSum=Executors.newCachedThreadPool();
        ExecutorService execEntrance = Executors.newCachedThreadPool();
        execSum.execute(new SumCounter()); //总数统计线程
        execSum.shutdown();
        for(int i = 0; i < entranceNum; i++){   //每个旋转门的计数线程
            execEntrance.execute(new Entrance(i));
        }
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        execEntrance.shutdownNow();
    }

    /**
     *  不能是静态套嵌类，因为还是依赖于外部总控制器实例的latch。
     */
    public class Entrance implements Runnable {
        private int number = 0;
        private final int id;
        public Entrance(int id) {
            this.id = id;
            entrances.add(this);
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    synchronized(this) {
                        ++number;
                    }
                    System.out.println(this);
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }catch(InterruptedException e) {
                System.out.println(this+"Sleep interrupted");
            }finally{
                System.out.println("Stopping " + this);
                latch.countDown();
            }
        }
        public synchronized int getValue() { return number; }
        public String toString() {
            return "Entrance " + id + ": " + getValue();
        }
    }

    public class SumCounter implements Runnable{
        public void run(){
            try{
                latch.await();
                sumEntrances();
                System.out.println("------------------------");
                System.out.println("TOTAL:  "+count);
            }catch(InterruptedException ie){
                System.out.println("Summer interrupted!");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Exercise32 ex=new Exercise32(5);
    }
}