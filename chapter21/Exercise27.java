/**
 *  Exercise 27
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import java.util.*;

public class Exercise27 {
    private int count=10;
    private Meal27 meal=null;
    private WaitPerson27 waitPerson=new WaitPerson27();;
    private Chef27 chef=new Chef27();
    private ExecutorService es=Executors.newCachedThreadPool();
    public Exercise27(int count){
        this.count=count;
        es.execute(waitPerson);
        es.execute(chef);
    }
    
    public class Meal27{
        private final int orderNum;
        public Meal27(int num){orderNum=num;}
        public String toString(){return "Meal "+orderNum;}
    }
    
    public class WaitPerson27 implements Runnable{
        private Lock waitPersonLock=new ReentrantLock();
        private Condition mealNull=waitPersonLock.newCondition();
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //wait if meal is null
                    waitPersonLock.lock();
                    try{
                        while(Exercise27.this.meal==null){
                            mealNull.await();
                        }
                    }finally{
                        waitPersonLock.unlock();
                    }
                    //serve the meal
                    chef.chefLock.lock();
                    System.out.println("Meal served!");
                    meal=null;
                    chef.mealNotNull.signalAll();
                    chef.chefLock.unlock();
                }
            }catch(InterruptedException ie){
                System.out.println("WaitPerson Interrupted!");
            }
            System.out.println("WaitPerson exit!");
        }
    }
    
    public class Chef27 implements Runnable{
        private int num=0;
        private Lock chefLock=new ReentrantLock();
        private Condition mealNotNull=chefLock.newCondition();
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //wait for meal consuming
                    chefLock.lock();
                    try{
                        while(Exercise27.this.meal!=null){
                            mealNotNull.await();
                        }
                    }finally{
                        chefLock.unlock();
                    }
                    System.out.println("New order!");
                    if(++num>count){
                        System.out.println("Out of Meal!");
                        es.shutdownNow();
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                    //make a new meal
                    waitPerson.waitPersonLock.lock();
                    meal=new Meal27(num);
                    System.out.println(meal+" prepared!");
                    waitPerson.mealNull.signalAll();
                    waitPerson.waitPersonLock.unlock();
                }
            }catch(InterruptedException ie){
                System.out.println("Chef Interrupted!");
            }
            System.out.println("Chef exit!");
        }
    }
    
    public static void main(String[] args){
        Exercise27 ex=new Exercise27(10);
    }
}