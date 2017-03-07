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
class UniCycle extends Cycle{
    
    /**
     *  PUBLIC FIELDS
     */
    public String info="I am a Unicycle!";

    
    /**
     *  PUBLIC INTERFACE
     */
    @Override
    public void ride(int distance){
        System.out.print(this.info+" ");
        for(int i=0;i<distance;i++){
            System.out.print(i+1+"! ");
        }
        System.out.println("");
    }
    
    @Override
    public void getInfo(){
        System.out.println(this.info);
    }
    
    public void superInfo(){
        System.out.println(super.info);
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    
}