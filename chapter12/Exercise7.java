/**
 * Exercise 7
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.util.logging.*;
import java.io.*;
public class Exercise7 {
    public static void main(String[] args) {
        try {
            int arrayLength = 5;
            int[] arrayToOverflow = new int[arrayLength];
            int loopTimes = 10;
            for (int i=0; i<loopTimes; i++) {
                arrayToOverflow[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger log = Logger.getLogger("ArrayIndexOutOfBoundsException");
            StringWriter trace = new StringWriter();
            e.printStackTrace(new PrintWriter(trace));
            log.severe(trace.toString());
            System.err.println(e);
        }
    }
}
