/**
 *  Exercise 23: Create an interface U with three methods. Create a class A with a method that produces a reference to a U by building an anonymous inner class. Create a second class B that contains an array of U. B should have one method that accepts and stores a reference to a U in the array, a second method that sets a reference in the array (specified by the method argument) to null, and a third method that moves through the array and calls the methods in U. In main( ), create a group of A objects and a single B. Fill the B with U references produced by the A objects. Use the B to call back into all the A objects. Remove some of the U references from the B.
 */

package com.ciaoshen.thinkinjava.chapter10;
import java.util.*;

//facotry of the object of type U
class A {
    //maintain a counter to generate the ID for each A
    private static int aCount=0;
    public static A getA(){return new A(aCount++);}
    
    public U getU(int i){
        i=100;
        //Anonymous inner class
        return new U(){
            public void uMethod1(){System.out.println("{A-"+aId+"}.{U-"+uId+"}.method1");}
            public void uMethod2(){System.out.println("{A-"+aId+"}.{U-"+uId+"}.method2");}
            public void uMethod3(){System.out.println("{A-"+aId+"}.{U-"+uId+"}.method3");}
            private int uId=uCount++;
        };
    }
    
    private A(int inputAId){aId=inputAId;}
    
    
    private int aId;
    //maintain a counter to generate the ID for each U
    private int uCount=0;

}