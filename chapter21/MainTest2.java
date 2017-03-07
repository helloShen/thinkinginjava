/**
 *  3个Assembler竞争10个Robot。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class MainTest2{
    public static void main(String[] args){
        System.out.println("Press entry to stop!");
        ExecutorService ex=Executors.newCachedThreadPool();
        Set<TestRobot2> pool=new LinkedHashSet<TestRobot2>();
        //robots: 创建，入池，启动，计数，放锁
        for(int i=0;i<10;i++){
            ex.execute(new TestRobot2("Red",pool));
        }
        //assembler: 等计数，等锁，遍历唤醒机器人
        for(int i=0;i<3;i++){
            ex.execute(new TestAssembler2(pool));
        }
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println("Test error!");
        }
        ex.shutdownNow();
    }
}