/**
 * Exercise 2
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise2 {
    public void foo() {System.out.println("This is Exercise 2 of chapter 12");}
    public static void main(String[] args) {
        try {
            Exercise2 myExercise = null;
            myExercise.foo();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
