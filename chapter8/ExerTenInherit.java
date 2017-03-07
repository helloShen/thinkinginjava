/**
 *  Exercise 10 - Polymophism
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;


class ExerTenInherit extends ExerTenBase{
    
    /**
     *  PUBLIC METHOD
     */
    public void beCalled(){System.out.println("From Derived!");}
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELD
     */
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        ExerTenBase testObject=new ExerTenInherit();
        testObject.call();
    }
}