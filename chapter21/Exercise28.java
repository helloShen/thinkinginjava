/**
 *  Exercise 28
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.io.*;

public class Exercise28 {
    private static BlockingQueue<LiftOff28> rockets;
    
    public static class LiftOffRunner implements Runnable {
        public LiftOffRunner(BlockingQueue<LiftOff28> queue) {
            rockets = queue;
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    LiftOff28 rocket = rockets.take();
                    rocket.run(); // Use this thread
                }
            } catch(InterruptedException e) {
                System.out.println("Waking from take()");
            }
            System.out.println(Thread.currentThread()+"Exiting LiftOffRunner");
        }
    }
    
    public static class LiftOffFiller implements Runnable{
        private int times=0;
        public LiftOffFiller(int num){times=num;}
        public void add(LiftOff28 lo) {
            try {
                rockets.put(lo);
            } catch(InterruptedException e) {
                System.out.println("Interrupted during put()");
                Thread.currentThread().interrupt();
            }
        }
        public void run(){
            for(int i=0;i<times;i++){
                if(Thread.interrupted()){
                    break;  //保证当interrupt时，跳出循环。否则下一次BlockingQueue的put()会继续阻塞，线程无法退出。
                }
                add(new LiftOff28(5));
            }
            System.out.println(Thread.currentThread()+"Exiting LiftOffFiller!");
        }
    }
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch(java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }
    static void test(String msg, BlockingQueue<LiftOff28> queue) throws InterruptedException{
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        Thread f=new Thread(new LiftOffFiller(5));
        f.start();
        getkey("Press ‘Enter’ (" + msg + ")");
        t.interrupt();
        f.interrupt();
        System.out.println("Finished " + msg + " test");
    }
    public static void main(String[] args) throws InterruptedException{
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff28>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff28>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff28>());
    }
}