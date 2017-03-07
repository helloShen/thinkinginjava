/**
 *  Encapsulate the Detergent Class using Delegation
 */
package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;


public class DetergentDelegation {
    
    //全新接口
    //Encapsulate the public methods of Cleanser
    public void append(String a) { theCleanser.append(a); }
    public void dilute() { theCleanser.dilute(); }
    public void apply() { theCleanser.apply(); }
    public String toString() { return theCleanser.toString(); }
    public void scrub() {
        append(" Detergent.");
        theCleanser.scrub(); // Call base-class version
    }
    // Add a new method to the interface:
    public void foam() { theCleanser.append(" foam()"); }
    
    //private fields: 对用户完全隐藏Cleanser
    //compose of Cleanser class
    private Cleanser theCleanser=new Cleanser();
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        //System.out.println(x.theCleanser);    //内部theCleanser对用户不可见
    }
}
