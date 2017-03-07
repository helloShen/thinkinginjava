/**
 *  Test wait(), notify() pragmatic
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class MainTest{
    public static void main(String[] args){
        System.out.println("Press entry to stop!");
        ExecutorService ex=Executors.newCachedThreadPool();
        int SIZE=10;
        CountDownLatch latch=new CountDownLatch(SIZE);
        Set<TestRobot> pool=new LinkedHashSet<TestRobot>();
        //robots: 创建，入池，启动，计数，放锁
        for(int i=0;i<SIZE;i++){
            new TestRobot("Red",latch,pool);
        }
        //assembler: 等计数，等锁，遍历唤醒机器人
        ex.execute(new TestAssembler(pool,latch));
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println("Test error!");
        }
        ex.shutdownNow();
    }
}
