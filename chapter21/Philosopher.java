/**
 *  Exercise 31
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Philosopher implements Runnable {
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random();
    private ChopstickBuck buck;
    private void pause() throws InterruptedException {
        if(ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }
    public Philosopher(ChopstickBuck buck, int ident, int ponder) {
        this.buck=buck;
        id = ident;
        ponderFactor = ponder;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                // Philosopher becomes hungry
                System.out.println(this + " " + "want to eat");
                buck.take();
                System.out.println(this + " " + "eating");
                pause();
                buck.drop();
            }
        } catch(InterruptedException e) {
            System.out.println(this + " " + "exiting via interrupt");
        }
    }
    public String toString() { return "Philosopher " + id; }
}