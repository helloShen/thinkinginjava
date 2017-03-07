/**
 *  Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise10{
    //Executor
    private ExecutorService es=Executors.newCachedThreadPool();
    private Fibonacci f=new Fibonacci();
    //inner Callable
    public Future<Integer> runTask(int num){
        return es.submit(new Callable<Integer>(){
            public Integer call(){
                Integer result=0;
                int index=0;
                while(++index<=num){
                    result+=f.fibo(index);
                }
                return result;
            }
        });
    }
    public void close(){es.shutdown();}

    public static void main(String[] args){
        Exercise10 ex=new Exercise10();
        Future<Integer> f=ex.runTask(10);
        ex.close();
        try{
            System.out.println(f.get());
        }catch(InterruptedException ie){
            System.out.println(ie);
        }catch(ExecutionException ee){
            System.out.println(ee);
        }
    }
}
