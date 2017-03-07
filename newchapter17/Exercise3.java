/**
 * Exercise 3
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise3 {
    public static void fillSetMultiTimes() {
        List<Map.Entry<String,String>> countriesList = Exercise2.getSortedCountries();
        Set<Map.Entry<String,String>> countriesSet = Exercise2.fillSetByList(countriesList);
        System.out.println("First time: ");
        System.out.println(countriesSet);
        System.out.println("Second time: ");
        countriesSet.addAll(countriesList);
        System.out.println(countriesSet);
    }
    public static void main(String[] args) {
        fillSetMultiTimes();
    }
}
