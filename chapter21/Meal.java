/**
 *  Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter21;

public class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}