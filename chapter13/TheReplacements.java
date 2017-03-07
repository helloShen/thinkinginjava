/**
 *  Exercise 12 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;
import com.ciaoshen.thinkinjava.myUtil.*;


/*! Here’s a block of text to use as input to
 the regular expression matcher. Note that we’ll
 first extract the block of text by looking for
 the special delimiters, then process the
 extracted block. !*/
public class TheReplacements {
    
    /**
     *  PUBLIC METHODS
     */
    public static void useReplaceAll(){
        if(mInput.find()){
            s = mInput.group(1); // Captured by parentheses
        }
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}", " ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces. Must enable MULTILINE mode:
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
    }
    
    public static void useReplaceFirst(){
        if(mInput.find()){
            s = mInput.group(1); // Captured by parentheses
        }
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        System.out.println(s);
    }
    
    
    public static void useAppendRelacement(){
        if(mInput.find()){
            s = mInput.group(1); // Captured by parentheses
        }
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while(m.find()){
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }
        // Put in the remainder of the text:
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private static String s = MyBufferedReader.readFile("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/TheReplacements.java");
    //In dotall mode, the expression . matches any character, including a line terminator.
    private static Matcher mInput=Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
    
    
    public static void main(String[] args) throws Exception {
        //TheReplacements.useReplaceAll();
        //TheReplacements.useReplaceFirst();
        TheReplacements.useAppendRelacement();
    }
}