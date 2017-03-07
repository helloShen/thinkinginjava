/**
 *  Create a class called Dog containing two Strings: name and says. In main( ), create two dog objects with names “spot” (who says, “Ruff!”) and “scruffy” (who says, “Wurf!”). Then display their names and what they say.
 *  Following Exercise 5, create a new Dog reference and assign it to spot’s object. Test for comparison using == and equals( ) for all references.
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */
package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;


/**
 *  Class Dog
 */
public class Dog {
    //two fields name and says.
    //invisible to users.
    protected String name = new String();
    protected String says = new String();
    
    //default constructor
    public Dog(){
        
    }
    
    //constructor
    public Dog(String inName, String inSays){
        this.name = inName;
        this.says = inSays;
    }
    
    //interface for user.
    //to get the name of the dog.
    public String getName(){
        return this.name;
    }
    
    //interface for user.
    //to let them yelp.
    public String yelp(){
        return this.says;
    }
    
    /**
     *  main class: create two dogs, get their names and let them yelp.
     *  @param args not used here.
     */
    public static void main(String args[]){
        //give me three dogs
        Dog littleBlack = new Dog("spots","Ruff!");
        Dog littleGray = new Dog("cruffy","Wurf!");
        Dog copyBlack = new Dog();
        
        //get their name and let them yelp.
        System.out.println(littleBlack.getName());
        System.out.println(littleBlack.yelp());
        System.out.println(littleGray.getName());
        System.out.println(littleGray.yelp());
        
        //compare littleBlack and copyBlack
        copyBlack = littleBlack;
        System.out.println(copyBlack == littleBlack); //TRUE
        System.out.println(copyBlack.name == littleBlack.name); //TRUE
        System.out.println(copyBlack.equals(littleBlack)); //TRUE
        System.out.println(copyBlack.says.equals(littleBlack.says)); //TRUE
    }
}