/**
 *  Chapter 9 - Exercise 4
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class Chapter9DerivedClass extends Chapter9BaseClass{
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public static void takeBaseRef(Chapter9BaseClass baseRef){
        Chapter9DerivedClass newDerived=(Chapter9DerivedClass)baseRef;
        newDerived.onlyInDerived();
    }
    public void onlyInDerived(){System.out.println("This method only in the derived class");}
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        Chapter9BaseClass newBaseClass=new Chapter9BaseClass();
        Chapter9DerivedClass.takeBaseRef(newBaseClass);
    }
    
}