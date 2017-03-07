/**
 *  测试while(condition){wait()}会不会导致收不到interrupt
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.buff();
            }
        } catch(InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}