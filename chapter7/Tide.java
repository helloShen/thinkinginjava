/**
 *  Tide is a famous brand of laundry detergent
 *  inherit from Detergent class in the book
 */
package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;


public class Tide extends Detergent {

    public void sterilize(){append(" sterilize() ");}
    public void scrub(){append(" Tide."); super.scrub();}

    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        Tide t = new Tide();
        t.dilute();
        t.apply();
        t.scrub();
        t.foam();
        t.sterilize();
        System.out.println(t);
    }
}