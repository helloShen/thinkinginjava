/**
 *  测试while(condition){wait()}会不会导致收不到interrupt
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Car {
    private boolean waxOn = false;
    public synchronized void wax() throws InterruptedException {
        waitForBuffing();
        System.out.print("Wax On! ");
        TimeUnit.MILLISECONDS.sleep(200);
        waxOn = true; // Ready to buff
    }
    public synchronized void buff() throws InterruptedException {
        waitForWaxing();
        System.out.print("Wax Off! ");
        TimeUnit.MILLISECONDS.sleep(200);
        waxOn = false; // Ready to wax
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false){
            notify();
            wait();
        }
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true){
            notify();
            wait();
        }
    }
}