/**
 * Exercise 33
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise33 {
    private static class FixedSizeStack<T> {
            private int index = 0;
            private int max;
            private ArrayList<T> storage = new ArrayList<T>();
            public FixedSizeStack(int size) {
                max = size;
            }
            public void push(T item) {
                if (index < max) {
                    storage.add(item);
                    index++;
                } else {
                    throw new IndexOutOfBoundsException("Max size of this FixedSizeStack is " + max);
                }
            }
            public T pop() {
                if (index > 0) {
                    return storage.get(--index);
                } else {
                    throw new IndexOutOfBoundsException("Max size of this FixedSizeStack is " + max);
                }
            }
        }
    public static void main(String[] args) {
        int SIZE = 10;
        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
        for(String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
