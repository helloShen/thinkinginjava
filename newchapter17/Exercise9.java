/**
 * Exercise 9
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise9 {
    public static void main(String[] args) {
        Generator<String> strGen = new RandomGenerator.String();
        TreeSet<String> strTreeSet = new TreeSet<String>(new Comparator<String>() {
            public int compare(String str1, String str2) {
                return String.CASE_INSENSITIVE_ORDER.compare(str1,str2);
            }
        });
        int size = 10;
        for (int i = 0; i < size; i++) {
            strTreeSet.add(strGen.next());
        }
        System.out.println(strTreeSet);
    }
}
