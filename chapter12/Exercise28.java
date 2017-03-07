/**
 * Exercise 28
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise28 {
    public static class Exercise28Exception extends RuntimeException {
        private static final long serialVersionUID = 0l;
        private String message = "NULL";
        public Exercise28Exception(){
            super();
        }
        public Exercise28Exception(String msg) {
            message = msg;
        }
        public void showMessage() {
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        String justAMessage = "I am the message of Exercise4Exception!";
        throw new Exercise28Exception(justAMessage);
    }
}
