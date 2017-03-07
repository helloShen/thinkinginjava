/**
 * Exercise 9
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise9 {
    public static <T,U,V> void f(T t,U u,V v) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
        System.out.println(v.getClass().getName());
    }
    public static void main(String[] args) {
        f("hello world", 1, 1.0);
    }
}
