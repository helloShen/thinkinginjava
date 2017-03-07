/**
 *
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;


final public class Amphibian {
    
    //constructor
    public Amphibian(){this.onLand=false;}
    
    //public methods
    public void swim(){
        if(onLand){
            this.onLand=false;
            System.out.println("PuPu...");
        }
    }
    public void landings(){
        if(!onLand){
            this.onLand=true;
            System.out.println("DuangDuang...");
        }
    }
    
    //private fields
    boolean onLand;

    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
}
