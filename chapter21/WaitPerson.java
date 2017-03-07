/**
 *  Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class WaitPerson implements Runnable {
    private Exercise25 restaurant;
    public WaitPerson(Exercise25 r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // Ready for another
                }
            }
        } catch(InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}