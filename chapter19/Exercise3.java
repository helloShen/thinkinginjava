/**
 *  Exercise 3
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}