/**
 * Turn the DataOnly code fragments into a program that compiles and runs.
 * @author Wei SHEN
 * @author wei.shen@iro.umontreal.ca
 * @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;

/**
 * DataOnly class
 */
public class DataOnly {
    /**
     * declare three values
     */
    int i;
    double d;
    boolean b;
    
    /**
     * constructor without parameter
     * @param no parameter
     */
    public DataOnly(){
        this.i=0;
        this.d=0;
        this.b=false;
    }
    
    /**
     * constructor with parameter
     * @param i
     * @param d
     * @param b
     */
    public DataOnly(int argI, double argD, boolean argB){
        this.i=argI;
        this.d=argD;
        this.b=argB;
    }
    
    /**
     * main method
     * @param args useless
     */
    public static void main (String args[]){
        DataOnly myData = new DataOnly(1,1.1,true);
        
        System.out.println(myData.i);
        System.out.println(myData.d);
        System.out.println(myData.b);
    }
}