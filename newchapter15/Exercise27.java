/**
 * Exercise 27
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise27 {
    public static void main(String[] args) {
        // ERROR: error: incompatible types: ArrayList<Integer> cannot be converted to List<Number>
        //List<Number> numberList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        List<? extends Number> wildcardsNumberList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        System.out.println(wildcardsNumberList);
    }
}
