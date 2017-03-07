/**
 * Exercise 25
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise25 {
    private static interface InterfaceA {
        public void a();
    }
    private static interface InterfaceB {
        public void b();
    }
    private static class A implements InterfaceA {
        public void a() {
            System.out.println("I am method a()!");
        }
    }
    private static class B implements InterfaceB {
        public void b() {
            System.out.println("I am method b()!");
        }
    }
    private static <T extends InterfaceA> void callA(T t) {
        t.a();
    }
    private static <T extends InterfaceB> void callB(T t) {
        t.b();
    }
    public static void main(String[] args) {
        callA(new A());
        callB(new B());
    }
}
