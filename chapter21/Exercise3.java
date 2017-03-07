/**
 *  Exercise 3
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise3 implements Runnable, Generator<String>{
    private static int count;
    private int id=++count;
    private int num;    //remains how many
    public Exercise3(int num){this.num=num;}
    public boolean hasNext(){return num>0;}
    public String next(){return num>0? "#"+id+"["+(num--)+"] ":"NULL";}
    public void run(){
        while(hasNext()){
            System.out.print(next());
        }
    }
    
    public static void testDifferentThreadPool(ExecutorService ex){
        for(int i=0;i<10;i++){
            ex.execute(new Exercise3(i+5));
        }
        ex.shutdown();
    }

    public static void main(String[] args){
        Exercise3.testDifferentThreadPool(Executors.newCachedThreadPool());
        Exercise3.testDifferentThreadPool(Executors.newFixedThreadPool(5));
        Exercise3.testDifferentThreadPool(Executors.newScheduledThreadPool(5));
        Exercise3.testDifferentThreadPool(Executors.newSingleThreadExecutor());
    }
}