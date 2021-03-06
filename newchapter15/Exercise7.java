/**
 * Exercise 7
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise7 implements Iterable<Integer> {
    private static interface Generator<T> {
        public T next();
    }
    private class Fibonacci implements Generator<Integer> {
        private int last = 0;
        private int current = 1;
        private int next = 1;
        public Integer next() {
            last = current;
            current = next;
            next = last + current;
            return last;
        }
    }
    private int size;
    public Exercise7(int num) {
        size = num;
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int cursor = 0;
            Generator<Integer> fiboGen = new Fibonacci();
            public boolean hasNext() {
                return cursor < size;
            }
            public Integer next() {
                if (cursor++ > size) {
                    throw new NoSuchElementException("Reach the end of the Fibonacci list!");
                }
                return fiboGen.next();
            }
            public void remove() {
                throw new UnsupportedOperationException("Remove in Fibonacci Iterator is not supported!");
            }
        };
    }
    public static void main(String[] args) {
        int size = 10;
        Iterator<Integer> fiboIte = new Exercise7(size).iterator();
        while (fiboIte.hasNext()) {
            System.out.println(fiboIte.next());
        }
    }
}
