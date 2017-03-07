/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;

public class Exercise10 {
    public static void testPattern(String phrase, List<String> regex){
        Pattern p;
        Matcher m;
        Formatter f = new Formatter(System.out);
        for(String reg : regex) {
            p=Pattern.compile(reg);
            m=p.matcher(phrase);
            f.format("%1$50.50s %2$-4.4b\n", phrase, reg);
        }
    }
    public static void main(String[] args){
        String phrase = "Java now has regular expressions";
        List<String> regex = new ArrayList<String>();
        regex.add("^Java");
        regex.add("\\Breg.*");
        regex.add("n.w\\s+h(a|i)s");
        regex.add("s?");
        regex.add("s*");
        regex.add("s+");
        regex.add("s{4}");
        regex.add("S{1}.");
        regex.add("s{0,3}");
        Exercise10.testPattern(phrase,regex);
    }
}
