/**
 * Exercise 5
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.math.*;
import java.util.*;

public class Exercise5{
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);
        char u = 'a';
        System.out.println("u = ‘a’");
        f.format("s: %1$-15.15s\n", u);
        // f.format("d: %d\n", u);
        f.format("c: %1$-15c\n", u);
        f.format("b: %1$-15.5b\n", u);
        // f.format("f: %f\n", u);
        // f.format("e: %e\n", u);
        // f.format("x: %x\n", u);
        f.format("h: %1$-15.5h\n", u);
    }
}
