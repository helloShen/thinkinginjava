/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise11 {
    public static class ExceptionInG extends Exception {
        private static final long serialVersionUID = 0;
        public ExceptionInG() {
            super();
            System.out.println("Hello I am ExceptionInG!");
        }
    }
    public static void f() throws RuntimeException {
        try {
            g();
        } catch (ExceptionInG e) {
            throw new RuntimeException(e);
        }
    }
    public static void g() throws ExceptionInG {
        throw new ExceptionInG();
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            e.getCause().printStackTrace(System.out);
        }
    }
}
