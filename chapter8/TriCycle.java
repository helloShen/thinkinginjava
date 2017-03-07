/**
 *  polymorphism exercise
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

/**
 *  base class of unicycle,bicycle and tricycle
 */
class TriCycle extends Cycle{
    
    /**
     *  PUBLIC INTERFACE
     */
    public void ride(int distance){
        System.out.print("Tricycle ");
        for(int i=0;i<distance;i++){
            System.out.print(i+1+"! ");
        }
        System.out.println("");
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    
}