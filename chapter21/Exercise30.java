/**
 *  Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise30 {
    private static BlockingQueue<Character> bq=new LinkedBlockingQueue<Character>();
    private static Random rand=new Random();
    
    public static class Sender implements Runnable {
        public void run() {
            try {
                while(true){
                    for(char c = 'A'; c <= 'z'; c++) {
                        bq.put(c);
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                    }
                }
            } catch(InterruptedException e) {
                System.out.println(e + " Sender sleep interrupted");
            }
        }
    }
    public static class Receiver implements Runnable {
        public void run() {
            try {
                while(true) {
                    System.out.print("Read: " + (char)bq.take() + ", ");
                }
            } catch(InterruptedException e) {
                System.out.println(e + " Sender sleep interrupted");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender());
        exec.execute(new Receiver());
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}