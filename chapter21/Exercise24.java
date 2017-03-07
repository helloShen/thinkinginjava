/**
 *  Exercise 24
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise24{
    private volatile Queue<String> table=new LinkedList<String>();
    private Random rand=new Random();

    private volatile Fourniseur fourniseur=new Fourniseur();
    private volatile Consumer consumer=new Consumer();

    public String randomFood(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<rand.nextInt(15)+1;i++){
            sb.append((char)(((int)'a')+rand.nextInt(26)));
        }
        return sb.toString();
    }
    public void show() throws InterruptedException{
        synchronized(table){
            Iterator<String> ite=table.iterator();
            while(ite.hasNext()){
                System.out.print(ite.next().substring(0,1));
                TimeUnit.MILLISECONDS.sleep(10);
            }
            for(int j=0;j<10-table.size();j++){
                System.out.print("-");
                TimeUnit.MILLISECONDS.sleep(10);
            }
            System.out.println("");
        }
    }
    public class Fourniseur implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //让出生产锁，有7道菜就不上新菜
                    synchronized(this){
                        while(table.size()>7){
                            wait();
                        }
                    }
                    //占住消费锁，上一轮菜
                    System.out.println("Here come the new plate!");
                    synchronized(Exercise24.this.consumer){
                        for(int i=0;i<rand.nextInt(3)+1;i++){
                            synchronized(Exercise24.this.table){
                                table.add(randomFood());
                            }
                        }
                        show();
                        Exercise24.this.consumer.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Fourniseur interrupted!");
            }
            System.out.println("Fourniseur exit!");
        }
    }
    public class Consumer implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    //让出消费锁，少于2道菜就等上菜
                    synchronized(this){
                        while(table.size()<2){
                            wait();
                        }
                    }
                    //占住生产锁，吃一轮
                    synchronized(Exercise24.this.fourniseur){
                        System.out.println("I can eat now!");
                        for(int i=0;i<rand.nextInt(2)+1;i++){
                            synchronized(Exercise24.this.table){
                                table.poll();
                            }
                        }
                        show();
                        Exercise24.this.fourniseur.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Fourniseur interrupted!");
            }
            System.out.println("Fourniseur exit!");
        }
    }
    public static void main(String[] args){
        Exercise24 ex=new Exercise24();
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(ex.fourniseur);
        es.execute(ex.consumer);
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException ie){
            System.out.println("Test Interrupted!");
        }finally{
            es.shutdownNow();
        }
    }
}
