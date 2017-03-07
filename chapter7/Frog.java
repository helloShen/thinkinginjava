/**
 *
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;


public class Frog extends Amphibian{
    
    //public methods
    public void swim(){
        if(onLand){
            this.onLand=false;
            System.out.println("GuaGuaGua...");
        }
    }
    public void landings(){
        if(!onLand){
            this.onLand=true;
            System.out.println("PiaPia...");
        }
    }
    
    //private fields
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        Amphibian someAmphibian=new Frog();
        someAmphibian.landings();
        someAmphibian.swim();
    }
}
