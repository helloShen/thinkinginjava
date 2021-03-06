/**
 *  Exercise 21
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise21{
    private Random rand=new Random();
    private char[] word=new char[rand.nextInt(15)+1];
    private boolean prepared=false;
    private boolean formatted=false;
    
    public void reset(){
        word=new char[rand.nextInt(15)+1];
        prepared=false;
        formatted=false;
    }
    
    public void preTest(){
        try{
            new PrepareWord().randomWord();
            new FormatWord().format();
        }catch(InterruptedException ie){
            System.out.println("Task interrupted!");
        }
    }
    
    public void start(){
        ExecutorService es=Executors.newCachedThreadPool();
        es.execute(new PrepareWord());
        es.execute(new FormatWord());
        try{
            TimeUnit.SECONDS.sleep(20);
        }catch(InterruptedException ie){
            System.out.println("Test interrupted incorrectly!");
        }finally{
            es.shutdownNow();
        }
    }
    
    public class PrepareWord implements Runnable {
        public void randomWord() throws InterruptedException{   //这里不处理interrupt信号很重要，抛出去让Runnable处理
            for(int i=0;i<word.length;i++){
                char c=(char)(((int)'a')+rand.nextInt(26));
                word[i]=c;
                System.out.print(c);
                TimeUnit.MILLISECONDS.sleep(200);
            }
            System.out.println("");
            prepared=true;
        }
        public void run(){
            synchronized(Exercise21.this){
                try{
                    while(!Thread.interrupted()){
                        randomWord();
                        Exercise21.this.notifyAll();
                        while(!formatted){
                            Exercise21.this.wait();
                        }
                        System.out.println(">>> String 《"+new String(word)+"》constructed!");
                        reset();
                    }
                }catch(InterruptedException ie){
                    System.out.println("Word generation interrupted!");
                }
                System.out.println("Word Generator exit correctly!");
            }
        }
    }
    public class FormatWord implements Runnable{
        public void format() throws InterruptedException{   //这里不处理interrupt信号很重要，抛出去让Runnable处理
            for(int i=0;i<word.length;i++){
                if(i%2==0){
                    word[i]=Character.toUpperCase(word[i]);
                }
                System.out.print(word[i]);
                TimeUnit.MILLISECONDS.sleep(200);
            }
            System.out.println("");
            formatted=true;
        }
        public void run(){
            synchronized(Exercise21.this){
                try{
                    while(!Thread.interrupted()){
                        while(!prepared || formatted){
                            Exercise21.this.wait();
                        }
                        format();
                        Exercise21.this.notifyAll();
                    }
                }catch(InterruptedException ie){
                    System.out.println("Word format interrupted!");
                }
                System.out.println("Word Decorator exit correctly!");
            }
        }
    }
    
    public static void main(String[] args){
        Exercise21 ex=new Exercise21();
        //ex.preTest();
        ex.start();
    }
}