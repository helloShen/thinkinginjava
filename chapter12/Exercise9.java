/**
 * Exercise 9
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise9 {
    public static class Exercise9Exception1 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 1 of Exercise 9!";
        public Exercise9Exception1() {
            super();
        }
        public Exercise9Exception1(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static class Exercise9Exception2 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 2 of Exercise 9!";
        public Exercise9Exception2() {
            super();
        }
        public Exercise9Exception2(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static class Exercise9Exception3 extends Exception {
        private static final long serialVersionUID = 0;
        private String message = "I am Exception 3 of Exercise 9!";
        public Exercise9Exception3() {
            super();
        }
        public Exercise9Exception3(String msg) {
            message = msg;
        }
        public String getMessage() {
            return message;
        }
    }
    public static void throwThreeException(int inNum) throws Exception{
        switch (inNum) {
            case 1: throw new Exercise9.Exercise9Exception1();
            case 2: throw new Exercise9.Exercise9Exception2();
            case 3: throw new Exercise9.Exercise9Exception3();
            default: System.out.println("Congratulation! You win!");
        }
    }
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            try {
                throwThreeException(i);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                i++;
            }
        }
    }
}
