/**
 *  Test Radiation Counter
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise17{
    private static int macro=0;
    //count
    private volatile int count=0;
    private boolean canceled=false;
    private Random rand=new Random();
    private List<Detector> list=new ArrayList<Detector>();
    //increment
    public synchronized void increment(){count++;}
    //show count
    public synchronized int getCount(){return count;}
    //cancel
    public void cancel(){canceled=true;}
    //Runnable inner class: each sub counter
    public class Detector implements Runnable{
        private int id=++macro;
        private int number=0;
        public Detector(){list.add(this);}
        public void run(){
            int seed;
            while(!canceled){
                seed=rand.nextInt(10);
                switch(seed){
                    case 0: case 1: case 2:
                        increment(); number++; break;
                    default: break;
                }
            }
        }
        public int getNumber(){return number;}
        public int getId(){return id;}
    }
    public class Listener implements Runnable{
        public void run(){
            while(!canceled){
                for(Detector d:list){
                    System.out.println("Detector #"+d.getId()+": "+d.getNumber()+"      Total: "+getCount());
                }
            }
        }
    }
    
    //main
    public static void main(String[] args){
        ExecutorService es=Executors.newCachedThreadPool();
        Exercise17 rc=new Exercise17();
        for(int i=0;i<10;i++){
            es.execute(rc.new Detector());
        }
        es.execute(rc.new Listener());
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
            rc.cancel();
            es.shutdown();
            if(!es.awaitTermination(250,TimeUnit.MILLISECONDS)){
                System.out.println("Some thread not terminated!");
            }
        }catch(InterruptedException ie){
            System.out.println("Termination Interrupted!");
        }finally{
            rc.cancel();
            es.shutdown();
        }
    }
}