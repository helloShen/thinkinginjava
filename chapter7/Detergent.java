/**
 *  Detergent class in the book
 */
package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;


public class Detergent extends Cleanser {
    // Change a method:
    public void scrub() {
        append("Detergent.scrub()");
        super.scrub(); // Call base-class version
    }
    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        //System.out.println(x.s);  //父类的s字段是private，无法访问。
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }
}