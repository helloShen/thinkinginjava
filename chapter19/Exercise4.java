/**
 *  Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise4 {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(Meal2 meal : Meal2.values()) {
                Meal2.Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}