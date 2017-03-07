/**
 * Exercise 11
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise11 {
    private static class IntegerUnit implements Comparable<IntegerUnit>{
        private static Random r = new Random();
        private Integer item;
        public IntegerUnit(int max) {
            item = r.nextInt(max);
        }
        public int getItem() {
            return item;
        }
        public int compareTo(IntegerUnit unit) {
            return item - unit.getItem();
        }
        public boolean equals(Object o) {
            if ( ! ( o instanceof IntegerUnit) ) {
                return false;
            }
            @SuppressWarnings("unchecked")
            IntegerUnit unit = (IntegerUnit)o;
            return item.equals(unit.getItem());
        }
        public int hashCode() {
            return item.hashCode();
        }
        public String toString() {
            return "[TestUnit:" + item + "]";
        }
    }
    public static void testWithPriorityQueue(int size, int max) {
        Queue<IntegerUnit> priQue = new PriorityQueue<>(size);
        for (int i = 0; i < size; i++) {
            if ( ! priQue.offer(new IntegerUnit(max)) ) {
                throw new IllegalStateException("Out of the queue capacity: " + size);
            }
        }
        System.out.println(priQue);
        for (int i = 0; i < size; i++) {
            System.out.println(priQue.poll());
        }
    }
    public static void main(String[] args) {
        testWithPriorityQueue(10,100);
    }
}
