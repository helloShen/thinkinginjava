/**
 * Exercise 34
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise34 {
    private static abstract class SelfBoundsGeneric<T extends SelfBoundsGeneric<T>> {
        public abstract T foo(T t);
        public T callFoo(T t) {
            System.out.println(t);
            return foo(t);
        }
    }
    private static class A extends SelfBoundsGeneric<A> {
        private static int count = 0;
        private final int ID = ++count;
        public String toString() {
            return "I am A#" + ID;
        }
        public A foo(A a) {
            return a;
        }
    }
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.callFoo(a2);
    }
}
