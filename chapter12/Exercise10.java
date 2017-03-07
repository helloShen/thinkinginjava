/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise10 {
    public static class ExceptionInG extends Exception {
        private static final long serialVersionUID = 0;
        public ExceptionInG() {
            super();
            System.out.println("Hello I am ExceptionInG!");
        }
    }
    public static class ExceptionInF extends Exception {
        private static final long serialVersionUID = 0;
        public ExceptionInF() {
            super();
            System.out.println("Hello I am ExceptionInF!");
        }
    }
    public static void f() throws ExceptionInF {
        try {
            g();
        } catch (ExceptionInG e) {
            ExceptionInF exF= new ExceptionInF();
            exF.initCause(e);
            throw exF;
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
        }
    }
}
