/**
 * Exercise 14
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise14 {
    public static List<Integer> insertInMiddle(List<Integer> list, Integer num) { //insert a num 1-1000 in the middle of the list
        int halfLength = list.size()/2;
        ListIterator<Integer> ite = list.listIterator();
        List<Integer> resultList = new LinkedList<Integer>();
        for (int i = 0; i < halfLength; i++) {
            resultList.add(ite.next());
        }
        resultList.add(num);
        while (ite.hasNext()) {
            resultList.add(ite.next());
        }
        return resultList;
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        int times = 10;
        for (int i = 0; i < times; i++) {
            list = insertInMiddle(list,i);
        }
        System.out.println(list);
    }
}
