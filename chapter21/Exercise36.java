/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class Exercise36{
    public static void main(String[] args){
        System.out.println("Press enter to stop!");
        //executor
        ExecutorService exec=Executors.newCachedThreadPool();
        //restaurant
        Restaurant36 restaurant=new Restaurant36(5,10);
        exec.execute(restaurant);
        //client
        try{
            //Wait Person
            for(int i=0;i<10;i++){
                exec.execute(new WaitPerson36(restaurant));
            }
            for(int i=0;i<5;i++){
                exec.execute(new Chef36(restaurant));
            }
            for(int i=0;i<100;i++){
                exec.execute(new Client36(restaurant));
                TimeUnit.MILLISECONDS.sleep(1);
            }
            System.in.read();
        }catch(IOException ioe){
            System.out.println("Error in Standard input!");
        }catch(InterruptedException ie){
            System.out.println("Client creation interrupted!");
        }
        exec.shutdownNow();
    }
}