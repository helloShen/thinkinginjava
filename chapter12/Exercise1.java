/**
 * Exercise 1
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise1 {
    public static void main(String[] args) {
        try {
            String msg = "This is Exercise 1 of chapter 12!";
            throw new Exception(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("In finally block of chapter 12 - exercise 1");
        }
    }
}
