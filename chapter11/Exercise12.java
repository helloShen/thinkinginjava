/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise12 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        int listSize = 10;
        int max = 1000;
        for (int i = 0; i < listSize; i++) {
            list1.add(new Integer(rand.nextInt(max)));
            list2.add(new Integer(rand.nextInt(max)));
        }
        ListIterator<Integer> ite = list1.listIterator(list1.size());
        while (ite.hasPrevious()) {
            list2.add(ite.previous());
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}
