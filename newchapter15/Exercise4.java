/**
 * Exercise 4
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise4 {
    public interface Selector<T> {
        boolean end();
        T current();
        void next();
    }
    public static class Sequence<T> {
        private T[] items;
        private int next = 0;
        public Sequence(int size) {
            @SuppressWarnings("unchecked")
            T[] tArray = (T[]) new Object[size]; // don't add @SuppressWarnings on the whole method
            items = tArray;
        }
        public void add(T t) {
            if(next < items.length) {
                items[next++] = t;
            }
        }
        private class SequenceSelector implements Selector<T> {
            private int i = 0;
            public boolean end() { return i == items.length; }
            public T current() { return items[i]; }
            public void next() { if(i < items.length) i++; }
        }
        public Selector<T> selector() {
            return new SequenceSelector();
        }
    }
    public static void main(String[] args) {
        int size = 10;
        Sequence<String> sequence = new Sequence<>(size);
        for(int i = 0; i < size; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector<String> selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
