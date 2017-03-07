/**
 *  测试call的时序是不是不确定的。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;
import java.util.concurrent.*;

public class TestCall implements Callable<Integer>{
    private static int count=0;
    private int id=++count;
    private Fibonacci f;
    public TestCall(int num){
        f=new Fibonacci(num);
    }
    public Integer call(){
        int sum=0;
        while(f.hasNext()){
            sum+=f.next();
            System.out.println("#"+id+"("+sum+")");
        }
        return sum;
    }
    public int getId(){return id;}
    
    public static void newCalledToFuture(){
        ExecutorService ex=Executors.newCachedThreadPool();
        try{
            List<Future<Integer>> list=new ArrayList<Future<Integer>>();
            for(int i=0;i<10;i++){
                TestCall called=new TestCall(i+1);
                Future<Integer> result=ex.submit(called);
                list.add(result);
                System.out.println("SUM >>> #"+called.getId()+"("+result.get()+")");
            }
        }catch(InterruptedException ie){
            System.out.println(ie);
        }catch(ExecutionException ee){
            System.out.println(ee);
        }finally{
            ex.shutdown();
        }
    }
    
    public static void newCalled(){
        ExecutorService ex=Executors.newCachedThreadPool();
        List<Future<Integer>> list=new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            TestCall called=new TestCall(i+1);
            list.add(ex.submit(called));
            System.out.println("SUM >>> #"+called.getId()+" finished!");
        }
        ex.shutdown();
    }
    
    public static void toFuture(){
        ExecutorService ex=Executors.newCachedThreadPool();
        List<Future<Integer>> list=new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            Future<Integer> result=ex.submit(new TestCall(i+1));
            list.add(result);
        }
        ex.shutdown();
    }
    
    public static void direct(){
        ExecutorService ex=Executors.newCachedThreadPool();
        List<Future<Integer>> list=new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            list.add(ex.submit(new TestCall(i+1)));
        }
        ex.shutdown();
    }
    public static void main(String[] args) {
        newCalledToFuture();
        //newCalled();
        //toFuture();
        //direct();
    }
}