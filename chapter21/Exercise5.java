/**
 *  Exercise 5
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;
import java.util.concurrent.*;

public class Exercise5 implements Callable<Integer>{
    private Fibonacci f;
    public Exercise5(int num){
        f=new Fibonacci(num);
    }
    public Integer call(){
        int sum=0;
        while(f.hasNext()){
            sum+=f.next();
        }
        return sum;
    }
    public static void main(String[] args) {
        ExecutorService ex=Executors.newCachedThreadPool();
        try{
            List<Future<Integer>> list=new ArrayList<Future<Integer>>();
            for(int i=0;i<10;i++){
                list.add(ex.submit(new Exercise5(i+1)));
            }
            for(Future<Integer> f:list){
                System.out.println(f.get());
            }
        }catch(InterruptedException ie){
            System.out.println(ie);
        }catch(ExecutionException ee){
            System.out.println(ee);
        }finally{
            ex.shutdown();
        }
    }
}