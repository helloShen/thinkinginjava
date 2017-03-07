/**
 *  Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise26{
    private int count=10;
    private boolean tableClean=false;
    private Meal meal=null;
    private WaitPerson waitPerson;
    private Chef chef;
    private BusBoy busBoy;
    private ExecutorService es;
    public Exercise26(int count){
        this.count=count;
        es=Executors.newCachedThreadPool();
        waitPerson=new WaitPerson();
        chef=new Chef();
        busBoy=new BusBoy();
        es.execute(waitPerson);
        es.execute(chef);
        es.execute(busBoy);
    }
    
    //Meal
    public class Meal{
        private int id;
        public Meal(int num){id=num;}
        public String toString(){return "Meal "+id;}
    }
    
    //WaitPerson
    public class WaitPerson implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    TimeUnit.MILLISECONDS.sleep(500);
                    //wait on self lock
                    synchronized(this){
                        while(meal==null){
                            wait();
                        }
                    }
                    //deliver the food on Chef lock
                    synchronized(Exercise26.this.chef){
                        System.out.println("Here is the food!");
                        //call busboy
                        synchronized(Exercise26.this.busBoy){
                            System.out.println("BusBoy, clean the table! ");
                            busBoy.notifyAll();
                        }
                        synchronized(this){
                            while(!tableClean){
                                wait();
                            }
                        }
                        System.out.println("Food served! ");
                        meal=null;
                        tableClean=false;
                        chef.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("WaitPerson interrupted!");
            }
            
        }
    }
    
    //Chef
    public class Chef implements Runnable{
        private int count=0;
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //wait on self lock
                    synchronized(this){
                        while(meal!=null){
                            wait();
                        }
                    }
                    System.out.println("Order come!");
                    if(++count>Exercise26.this.count){
                        System.out.println("Out of meal!");
                        Exercise26.this.es.shutdownNow();
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                    //prepare food on WaitPerson lock
                    synchronized(Exercise26.this.waitPerson){
                        meal=new Meal(count);
                        System.out.println(meal+" prepared!");
                        waitPerson.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Chef interrupted!");
            }
        }
    }
    
    //BusBoy
    public class BusBoy implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //wait on self lock
                    synchronized(this){
                        wait();
                    }
                    //clean the table on the WaitPerson lock
                    synchronized(Exercise26.this.waitPerson){
                        tableClean=true;
                        System.out.println("Table cleaned!");
                        waitPerson.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("BusBoy interrupted!");
            }
        }
    }
    
    public static void main(String[] args){
        new Exercise26(10);
    }
}