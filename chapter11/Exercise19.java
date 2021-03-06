/**
 * Exercise 19
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise19 {
    public static void main(String[] args) {
        // fill HashSet
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");
        // print HashSet
        System.out.println(hashSet);
        // transit to list
        List<String> list = new ArrayList<String>();
        list.addAll(hashSet);
        // sort list
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        // insert into LinkedHashSet
        Set<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.addAll(list);
        // print LinkedHashSet
        System.out.println(linkedHashSet);
    }
}
