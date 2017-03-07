/**
 * Exercise 1
 */
package com.ciaoshen.thinkinjava.chapter13;

public class WaterSource {
    private String s;
    public WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }
    public String toString() { return s; }
}
