/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise13 {
    public static class Exercise13Exception1 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 1 of Exercise 13!";
        public Exercise13Exception1() {
            super();
        }
        public Exercise13Exception1(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static class Exercise13Exception2 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 2 of Exercise 13!";
        public Exercise13Exception2() {
            super();
        }
        public Exercise13Exception2(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static class Exercise13Exception3 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 3 of Exercise 13!";
        public Exercise13Exception3() {
            super();
        }
        public Exercise13Exception3(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static void main(String[] args) {
        Exception[] exceptionArray = new Exception[3];
        exceptionArray[0] = new Exercise13.Exercise13Exception1();
        exceptionArray[1] = new Exercise13.Exercise13Exception2();
        exceptionArray[2] = new Exercise13.Exercise13Exception3();

        for (int i = 0; i < 5; i++) {
            try {
                throw exceptionArray[i];
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("This will be executed!");
            }
        }
    }
}
