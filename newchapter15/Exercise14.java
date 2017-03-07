/**
 * Exercise 14
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise14 {
    private static interface Generator<T> {
        public T next();
    }
    private static class BasicGenerator<T> implements Generator<T> {
        private Class<T> type;
        public BasicGenerator(Class<T> type){ this.type = type; }
        public T next() {
            try {
                // Assumes type is a public class:
                return type.newInstance();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
        // Produce a Default generator given a type token:
        public static <T> Generator<T> create(Class<T> type) {
            return new BasicGenerator<T>(type);
        }
    }
    static class CountedObject {
        private static long counter = 0;
        private final long id = counter++;
        public long id() { return id; }
        public String toString() { return "CountedObject " + id;}
    }
    public static void main(String[] args) {
        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        int size = 10;
        for (int i = 0; i < size; i++) {
            System.out.println(gen.next());
        }
    }
}
