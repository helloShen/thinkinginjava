/**
 * Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter12;
import java.util.logging.*;
import java.io.*;

public class Exercise6 {
    public static class Exercise6Exception extends Exception {
        private static final long serialVersionUID = 0;
        private Logger log = Logger.getLogger("Exercise6Exception");
        public Exercise6Exception() {
            super();
            StringWriter traceStr = new StringWriter();
            printStackTrace(new PrintWriter(traceStr));
            this.log.severe(traceStr.toString());
        }
    }
    public static void main(String[] args) {
        try {
            throw new Exercise6.Exercise6Exception();
        } catch (Exercise6.Exercise6Exception e) {
            System.err.println(e);
        }
    }
}
