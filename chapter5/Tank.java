/**
 *  Tank class
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;


/**
 *  my class
 */
public class Tank {
    //check field
    protected boolean isEmpty = false;
    protected int bullet = 100;
    protected String name = new String();
    
    //default constructor
    public Tank(String name){
        this.name=name;
    }
    
    //public static is avalable outside the package
    public static show(System.out.println("Show Time!"));
    
    //shot one bullet
    public void shot(){
        this.bullet --;
        if (this.bullet==0){
            this.isEmpty=true;
        }
    }
    
    //finish the bullet
    public void showHand(){
        this.bullet=0;
        this.isEmpty=true;
    }
    
    //check if the tank is empty
    public void finalize(){
        if(!this.isEmpty){
            System.out.println("Error! "+this.name+" still has bullet!!");
        }
        //super.finalize();
    }
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String args[]){
        Tank tank1 = new Tank("Tank1");
        Tank tank2 = new Tank("Tank2");
        
        tank1.shot();
        tank2.showHand();
        //free the reference
        tank1 = new Tank("Tank3");
        tank2 = new Tank("Tank4");
        //force to run garbage collection
        System.gc();
    }
}