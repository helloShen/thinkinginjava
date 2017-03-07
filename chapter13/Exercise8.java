/**
 * Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

public class Exercise8 {
    private static final String knight =
        "Then, when you have found the shrubbery, you must cut " +
        "down the mightiest tree in the forest... " +
        "with... a herring!";

    public static void split(String regex) {
        Formatter f = new Formatter(System.out);
        List<String> list = Arrays.asList(knight.split(regex));
        for(String str : list){
            f.format("%50.50s\n", str);
        }
    }
    public static void main(String[] args){
        Exercise8.split("the | you");
    }
}
