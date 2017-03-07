/**
 * Exercise 9
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise9 {
    public static class Sequence implements Iterable<Object> {
        private Object[] items;
        private int next = 0;
        public Sequence(int size) { items = new Object[size]; }
        public void add(Object x) {
            if (next < items.length) {
                items[next++] = x;
            }
        }
        public Iterator<Object> iterator() {
            return new SequenceIterator();
        }
        private class SequenceIterator implements Iterator<Object> {
            private int cursor = 0;
            public boolean hasNext() {
                return cursor < items.length;
            }
            public Object next() {
                if (hasNext()) {
                    return items[cursor++];
                }
                return null;
            }
        }
    }
    public static void main(String[] args) {
        int seqLength = 10;
        Sequence sequence = new Sequence(seqLength);
        for(int i = 0; i < seqLength; i++) {
            sequence.add(Integer.toString(i));
        }
        //for (Object obj : sequence) {
        //    System.out.println(obj);
        //}
        Iterator<Object> ite = sequence.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
}
