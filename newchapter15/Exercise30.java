/**
 * Exercise 30
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise30 {
    private static class Holder<T> {
        private T item;
        public Holder(T t) {
            item = t;
        }
        public T get() {
            return item;
        }
        public T set(T t) {
            T old = item;
            item = t;
            return old;
        }
        public String toString() {
            return "H[" + item + "]";
        }
    }
    private static class IntegerHolder extends Holder<Integer> {
        public IntegerHolder(Integer i) {
            super(i);
        }
    }
    public static void main(String[] args) {
        int size = 10;
        List<Holder<?>> list = new ArrayList<Holder<?>>();
        for (int i = 0; i < size; i++) {
            list.add(new IntegerHolder(i));
        }
        System.out.println(list);
    }
}
