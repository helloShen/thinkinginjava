/**
 * Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise29 {
    private static class NoMemberClass extends Object {}
    public static void main(String[] args) {
        PriorityQueue<NoMemberClass> pq = new PriorityQueue<NoMemberClass>();
        for (int i = 0; i < 10; i++) {
            pq.offer(new NoMemberClass());
        }
    }
}
