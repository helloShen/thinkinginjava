/**
 * Exercise 14
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;

public class Exercise14 {
    private static final String phrase = "This!!unusual use!!of exclamation!!points";
    public static void split(String regex){
        System.out.println(Arrays.toString(phrase.split(regex)));
    }
    public static void splitThreePieces(String regex){
        System.out.println(Arrays.toString(phrase.split(regex,3)));
    }
    public static void main(String[] args) {
        String regex = "!!";
        Exercise14.split(regex);
        Exercise14.splitThreePieces(regex);
    }
}
