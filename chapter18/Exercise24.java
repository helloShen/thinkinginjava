/**
 *  Exercise 24
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Exercise24{
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{ 11.1, 42.2, 47.3, 99.4, 143.5, 811.6, 1016.7 });
        System.out.println(db.get(3));
        db.put(new double[] {3.8, 1811.9});
        db.flip();
        while(db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
    }
}