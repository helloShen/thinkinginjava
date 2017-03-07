/**
 * Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise8 {
    public static void callExercise4() throws Exercise4.Exercise4Exception{
        throw new Exercise4.Exercise4Exception("I call Exercise4Exception in Exercise 8!");
    }
    public static void main(String[] args) {
        try {
            Exercise8.callExercise4();
        } catch (Exercise4.Exercise4Exception e) {
            e.showMessage();
        }
    }
}
