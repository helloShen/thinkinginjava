/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise10{
    public static <T,U> void f(T t, U u, String s) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
        System.out.println(s.getClass().getName());
    }
    public static void main(String[] args) {
        f(1,1.0,"2.0");
    }
}
