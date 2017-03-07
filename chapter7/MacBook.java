/**
 *  证明会自动调动构造器
 *  @author wei.shen
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;


//MacBook is a kind of Laptop
public class MacBook extends Laptop {
    
    //default constructor: exercise 8
    MacBook(){
        super(0);
        this.owner="???";
        System.out.println(" of Apple Inc. ");
        System.out.println(this.owner+" bought me. ");
        this.macScreen=new RetinaScreen(0);
    }
    
    //constructor: exercise 7
    MacBook(int macId, int screenPixels, String theOwner){
        super(macId);
        this.owner=theOwner;
        System.out.println(" of Apple Inc. ");
        System.out.println(theOwner+" bought me. ");
        this.macScreen=new RetinaScreen(screenPixels);
    }
    
    private String owner;
    private RetinaScreen macScreen;
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        //execise 7
        MacBook macDeQui=new MacBook(12345, 8000000, "Wei");
        //exercise 8
        MacBook macDeWei=new MacBook();
        
    }
}

//base class
class Laptop{
    //constructor
    Laptop(int id){
        System.out.print("I am the Laptop No."+id);
    }
}

//one of the MacBook component
class RetinaScreen{
    RetinaScreen(int pixels){
        System.out.println("I have a Retina screen with "+pixels+" pixels!");
    }
}