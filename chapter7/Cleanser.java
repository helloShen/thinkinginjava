/**
 *  The base class of Detergent class in the book
 */
package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;

//package accessable
public class Cleanser {
    
    //public methods
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    
    //private fields
    private String s = "Cleanser";
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.println(x);
    }
}