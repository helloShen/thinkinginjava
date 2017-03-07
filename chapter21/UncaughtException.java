/**
 *   测试未捕获异常
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class UncaughtException{
    //Runnable
    public static class SuperException implements Runnable{
        public void run(){
            throw new RuntimeException();
        }
    }
    //Executor
    public static void letsGo(){
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(new SuperException());
        es.shutdown();
    }
    
    //main
    public static void main(String[] args){
        try{
            letsGo();
        }catch(Exception e){
            System.out.println("Bingo! Exception caught!");
        }
    }
}