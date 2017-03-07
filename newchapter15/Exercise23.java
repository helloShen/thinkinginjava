/**
 * Exercise 23
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise23 {
    private static interface Factory<T> {
        public List<T> create(int size);
    }
    private static class IntegerFactory implements Factory<Integer> {
        private Random r = new Random();
        public List<Integer> create(int size) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                list.add(new Integer(r.nextInt()));
            }
            return list;
        }
    }
    public static void main(String[] args) {
        IntegerFactory fac = new IntegerFactory();
        System.out.println(fac.create(10));
    }
}
