/**
 * Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise4 {
    public static class Exercise4Exception extends Exception {
        private static final long serialVersionUID = 0l;
        private String message = "NULL";
        public Exercise4Exception(){
            super();
        }
        public Exercise4Exception(String msg) {
            message = msg;
        }
        public void showMessage() {
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        try {
            String justAMessage = "I am the message of Exercise4Exception!";
            throw new Exercise4.Exercise4Exception(justAMessage);
        } catch (Exercise4.Exercise4Exception e) {
            e.showMessage();
        }
    }
}
