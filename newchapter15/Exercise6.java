/**
 * Exercise 6
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise6 {
    public static class RandomList<T> {
        private ArrayList<T> storage = new ArrayList<T>();
        private Random rand = new Random();
        public void add(T item) { storage.add(item); }
        public T select() {
            return storage.get(rand.nextInt(storage.size()));
        }
        public int size() {
            return storage.size();
        }
    }
    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();
        for(String s: ("The quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
            rs.add(s);
        }
        for(int i = 0; i < rs.size(); i++) {
            System.out.print(rs.select() + " ");
        }
        RandomList<Integer> ri = new RandomList<Integer>();
        for (int i = 0; i < rs.size(); i++) {
            ri.add(i);
        }
        for (int i = 0; i < ri.size(); i++) {
            System.out.print(ri.select() + " ");
        }
        RandomList<Boolean> rb = new RandomList<Boolean>();
        rb.add(true);
        rb.add(false);
        for (int i = 0; i < rs.size(); i++) {
            System.out.print(rb.select() + " ");    
        }
    }
}
