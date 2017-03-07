/**
 *  Exercise 20
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise20 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        try{
            TimeUnit.MILLISECONDS.sleep((long)(new Random().nextInt(1000)));
        }catch(InterruptedException ie){
            System.out.println("Task dead???");
        }
        exec.shutdownNow();
    }
}