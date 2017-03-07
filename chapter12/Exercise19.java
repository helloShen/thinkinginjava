/**
 * Exercise 18
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise19 {
    private static class VeryImportantException extends Exception {
        private static final long serialVersionUID = 0;
    }
    private static class HoHumException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    public static void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            try {
                Exercise19.f();
            }
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            Exercise19.dispose();
        }
    }
}
