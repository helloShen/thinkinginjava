/**
 * ReaderWriterListTest
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class ReaderWriterListTest {
        private final ExecutorService exec = Executors.newCachedThreadPool();
        private final static int SIZE = 10;
        private static Random rand = new Random();
        private ReaderWriterList<Integer> list = new ReaderWriterList<Integer>(SIZE, 0);

        private class Writer implements Runnable {
            public void run() {
                try {
                    for(int i = 0; i < SIZE/2; i++) {   //change the first half of the list
                        list.set(i, rand.nextInt(1000));
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch(InterruptedException e) {
                    System.out.println("Writer interrupted!");
                }
                System.out.println("Writer finished, shutting down");
            }
        }

        private class Reader implements Runnable {
            public void run() {
                try {
                    for(int j=0; j<20; j++){    //read 20 times the whole list
                        for(int i = 0; i < SIZE; i++) {
                            list.get(i);
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    }
                } catch(InterruptedException e) {
                    System.out.println("Reader is interrupted!");
                }
                System.out.println("Reader finished!");
            }
        }
        public ReaderWriterListTest(int readers, int writers) {
            for(int i = 0; i < readers; i++){
                exec.execute(new Reader());
            }
            for(int i = 0; i < writers; i++){
                exec.execute(new Writer());
            }
        }
        public void stop(){exec.shutdownNow();}

        public static void main(String[] args){
            System.out.println("Press Entry to exit!");
            ReaderWriterListTest test=new ReaderWriterListTest(10,33);
            try{
                System.in.read();
            }catch(IOException ioe){
                System.out.println("Test meets the IO problems!");
            }
            test.stop();
        }
}
