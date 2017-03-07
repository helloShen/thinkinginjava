/**
 *  Simple inner class
 */

package com.ciaoshen.thinkinjava.chapter10;
import java.util.*;

public class Outer {

    /**
     *  PRIVATE INNER CLASS
     */
    private class Inner {
        //methods
        private void privateInnerMethod(){
            privateOuterMethod();
            info="privatedInnerMethod visit info!";
        }
        //constructor of inner
        private Inner() {System.out.println("Hello I am Inner Class!");}
    }
    
    /**
     *  PUBLIC METHODS
     */
    public Inner getInner(){return new Inner();}
    public void callPrivateInner(){
        Inner theInner=getInner();
        theInner.privateInnerMethod();
        System.out.println(info);
    }
    private void privateOuterMethod(){System.out.println("Private Outer Method visited!");}
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    public Outer(String inStr){
        info=inStr;
        System.out.println("Hello I am Outer Class!");
        System.out.println(info);
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private String info;
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        Outer testOuter=new Outer("Inner class haven't visited info!");
        testOuter.callPrivateInner();
    }
}