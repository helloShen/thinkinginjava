/**
 *  Exercise 22
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise22{
    private Random rand=new Random();
    private volatile int earthFallen=0;
    public synchronized void save() throws InterruptedException {TimeUnit.MILLISECONDS.sleep(10);earthFallen--;}
    public synchronized void fallen() throws InterruptedException {TimeUnit.MILLISECONDS.sleep(10);earthFallen++;}
    public synchronized void show(){
        int result=Math.min(earthFallen,100)/5;
        for(int y=0;y<20-result;y++){
            System.out.print("+");
        }
        for(int x=0;x<result;x++){
            System.out.print("-");
        }
        System.out.println("");
    }
    public class PrimitiveAlien implements Runnable{
        public void attack(int times) throws InterruptedException{
            synchronized(Exercise22.this){
                for(int i=0;i < times;i++){
                    fallen();
                }
                show();
            }
        }
        public void run(){
            try{
                while(!Thread.interrupted()){
                    if(earthFallen<100){
                        attack(rand.nextInt(10));
                    }else{
                        attack(rand.nextInt(3));
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Alien interrupted!");
            }
            System.out.println("TimeOver! We Alien "+ (earthFallen>=100? "WIN!":"LOSE!"));
        }
    }
    public class Alien implements Runnable{
        public void attack(int times) throws InterruptedException{
            synchronized(Exercise22.this){
                for(int i=0;i<times;i++){
                    fallen();
                }
                show();
            }
        }
        public void run(){
            try{
                while(!Thread.interrupted()){
                    synchronized(Exercise22.this){
                        if(earthFallen<100){
                            attack(rand.nextInt(10));
                        }else{
                            attack(rand.nextInt(3));
                        }
                        Exercise22.this.notifyAll();
                        Exercise22.this.wait();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Alien interrupted!");
            }
            System.out.println("TimeOver! We Alien "+ (earthFallen>=100? "WIN!":"LOSE!"));
        }
    }
    public class Primitive implements Runnable{
        public void defense(int times) throws InterruptedException{
            synchronized(Exercise22.this){
                for(int i=0;i<times;i++){
                    save();
                }
                show();
            }
        }
        public void run(){
            try{
                while(!Thread.interrupted()){
                    if(earthFallen<80){
                        defense(rand.nextInt(3));
                    }else if(earthFallen<100){
                        defense(rand.nextInt(8));
                    }else{
                        defense(rand.nextInt(10));
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Primitive Interrupted!");
            }
            System.out.println("TimeOver! We Primitive "+ (earthFallen>=100? "LOSE!":"WIN!"));
        }
    }
    public class Human implements Runnable{
        public void defense(int times) throws InterruptedException{
            synchronized(Exercise22.this){
                for(int i=0;i<times;i++){
                    save();
                }
                show();
            }
        }
        public void run(){
            try{
                while(!Thread.interrupted()){
                    synchronized(Exercise22.this){
                        while(earthFallen<100){
                            Exercise22.this.notifyAll();
                            Exercise22.this.wait();
                        }
                        defense(rand.nextInt(100));
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Human Interrupted!");
            }
            System.out.println("TimeOver! We Human "+(earthFallen>100? "LOSE!":"WIN!"));
        }
    }
    
    public static void main(String[] args){
        Exercise22 ex=new Exercise22();
        ExecutorService es=Executors.newCachedThreadPool();
        //es.execute(ex.new PrimitiveAlien());
        //es.execute(ex.new Primitive());
        es.execute(ex.new Alien());
        es.execute(ex.new Human());
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(15)+1);
        }catch(InterruptedException ie){
            System.out.println("Test Interrupted!");
        }finally{
            es.shutdownNow();
        }
    }
}