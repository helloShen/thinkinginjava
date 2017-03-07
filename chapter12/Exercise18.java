/**
 * Exercise 18
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise18 {
    private static class VeryImportantException extends Exception {
        private static final long serialVersionUID = 0;
    }
    private static class HoHumException extends Exception {
        private static final long serialVersionUID = 0;
    }
    private static class ThirdException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    public static void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void third() throws ThirdException {
        throw new ThirdException();
    }
    public static void main(String[] args) {
        try {
            try {
                Exercise18.f();
            } finally {
                Exercise18.third();
                Exercise18.dispose();
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
