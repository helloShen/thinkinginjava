/**
 *  Exercise 13 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;


public class StartEnd {
    public static String input =
    "As long as there is injustice, whenever a\n" +
    "Targathian baby cries out, wherever a distress\n" +
    "signal sounds among the stars ... We’ll be there.\n" +
    "This fine ship, and this fine crew ...\n" +
    "Never give up! Never surrender!";
    
    
    
    //print regex and the message
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) { this.regex = regex; }
        void display(String message) {
            if(!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }
    
    //match regex and print matched position
    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while(m.find())
            d.display("find() ‘" + m.group() +
                      "‘ start = "+ m.start() + " end = " + m.end());
        if(m.lookingAt()) // No reset() necessary
            d.display("lookingAt() start = "
                      + m.start() + " end = " + m.end());
        if(m.matches()) // No reset() necessary
            d.display("matches() start = "
                      + m.start() + " end = " + m.end());
    }
    
    //the example from the book
    static void testFromBook(){
        for(String in : input.split("\n")) {
            System.out.println("input : " + in);
            for(String regex : new String[]{"\\w*ere\\w*",
                "\\w*ever", "T\\w+", "Never.*?!"})
                examine(in, regex);
        }
    }
    
    //exercise 13
    static void exercise13(){
        for(String in : Group.POEM.split("\n")) {
            System.out.println("POEM : " + in);
            for(String regex : new String[]{"\\W*th\\w*",
                "\\p{Upper}\\w+", "[\\w\\W]+\\."})
                examine(in, regex);
        }
    }
    
    //main
    public static void main(String[] args) {
        //StartEnd.testFromBook();
        StartEnd.exercise13();
    }
}