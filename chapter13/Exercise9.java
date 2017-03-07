/**
 * Exercise 9
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

public class Exercise9{
    private static final String knight =
        "Then, when you have found the shrubbery, you must cut " +
        "down the mightiest tree in the forest... " +
        "with... a herring!";

    public static void replace(String regex, String replacement){
        System.out.println(knight.replaceAll(regex,replacement));
    }
    public static void main(String[] args){
        Exercise9.replace("[aeiouAEIOU]","_");
    }
}
