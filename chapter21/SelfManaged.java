/**
 *  Thread的一些变体
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);
    public SelfManaged() { t.start(); countDown=10;}
    public String toString() {
        return Thread.currentThread().getName() +
        "(" + countDown + "), ";
    }
    public void run() {
        while(true) {
            System.out.print(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++)
            new SelfManaged();
    }
}