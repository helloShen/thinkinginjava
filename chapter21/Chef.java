/**
 *  Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Chef implements Runnable {
    private Exercise25 restaurant;
    private int count = 0;
    public Chef(Exercise25 r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if(++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.print("Order up! ");
                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                //TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}