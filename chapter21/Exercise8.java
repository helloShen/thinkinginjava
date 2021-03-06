/**
 *  Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise8 extends Thread {
    private int countDown = 50;
    private static int threadCount = 0;
    public Exercise8() {
        // Store the thread name:
        super(Integer.toString(++threadCount));
        setDaemon(true);
        start();
    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    public void run() {
        while(true) {
            System.out.print(this);
            if(--countDown == 0){
                return;
            }
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            Thread th=new Exercise8();
        }
        /**
         *  Additional time
         *
        try{
            TimeUnit.NANOSECONDS.sleep(1);
        }catch(InterruptedException ie){
            System.out.println(ie);
        }
         */
    }
}