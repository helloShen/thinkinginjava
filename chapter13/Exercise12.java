/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;

public class Exercise12 {
    protected static final String POEM =
        "Twas brillig, and the slithy toves\n" +
        "Did gyre and gimble in the wabe.\n" +
        "All mimsy were the borogoves,\n" +
        "And the mome raths outgrabe.\n\n" +
        "Beware the Jabberwock, my son,\n" +
        "The jaws that bite, the claws that catch.\n" +
        "Beware the Jubjub bird, and shun\n" +
        "The frumious Bandersnatch.";
    public static Set<String> scan(String regex){
        Set<String> set = new HashSet<String>();
        Matcher m = Pattern.compile(regex).matcher(POEM);
        while(m.find()){
            set.add(m.group(2));
        }
        return set;
    }
    public static void display(Set<String> set){
        System.out.println("Word count: " + set.size());
        System.out.println(set);
    }
    public static void main(String[] args) {
        String regex = "(?m)(^|\\W)([a-z]\\w*)(\\W|$)";
        Exercise12.display(Exercise12.scan(regex));
    }
}
