/**
 *  Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Exercise25{
    private static final int BSIZE = 1048576;
    
    private abstract static class Tester {
        private String name;
        public Tester(String name) { this.name = name; }
        public void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                long mid=test();
                long end=System.nanoTime();
                double firstHalf = mid-start;
                double secondHalf = end - mid;
                System.out.format("%.2f %.2f\n", firstHalf/1.0e6, secondHalf/1.0e6);
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        public abstract long test() throws IOException;
    }
    
    private static Tester[] tests={
        new Tester("Allocate") {
            public long test() throws IOException{
                ByteBuffer bb = ByteBuffer.allocate(BSIZE);
                long mid=System.nanoTime();
                DoubleBuffer db = bb.asDoubleBuffer();
                for(int i=0;i<BSIZE/8;i++){
                    db.put((double)i);
                }
                return mid;
            }
        },

        new Tester("AllocateDirect") {
            public long test() throws IOException{
                ByteBuffer bb = ByteBuffer.allocateDirect(BSIZE);
                long mid=System.nanoTime();
                DoubleBuffer db = bb.asDoubleBuffer();
                for(int i=0;i<BSIZE/8;i++){
                    db.put((double)i);
                }
                return mid;
            }
        }
    };

    public static void main(String[] args) {
        for(Tester test : tests){
            test.runTest();
        }
    }
}