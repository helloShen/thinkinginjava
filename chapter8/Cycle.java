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
class Cycle {
    
    /**
     *  PUBLIC FIELDS
     */
    public String info="I am a cycle!";
    
    /**
     *  PUBLIC CONSTRUCTOR
     */
    
    /**
     *  PUBLIC INTERFACE
     */
    public void ride(int distance){
        System.out.println("Which cycle?");
    }
    public void getInfo(){
        System.out.println(this.info);
    }
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    
    /**
     *  MAIN
     *  @params void
     */
    public static void main(String[] args){
        //create cycles
        Cycle cycle1=new UniCycle();
        //Cycle cycle2=new ByCycle();
        //Cycle cycle3=new TriCycle();
        //call ride()
        cycle1.ride(10);
        //cycle2.ride(20);
        //cycle3.ride(30);
        //call info
        cycle1.getInfo();
        //cycle2.getInfo();
        //cycle3.getInfo();
        //print public fields
        System.out.println(cycle1.info);
    }
    
}