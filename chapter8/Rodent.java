/**
 *  Exercise 9 - Polymophism
 *  Rodent is base-class of Mouse, Gerbil and Hamster.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

class Rodent {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Rodent newRodent(){
        return new Rodent();
    }
    
    /**
    *  PUBLIC METHODS
    */
    //each rodent will eat one food and flee
    public void invade(HaveFood granary) {
        String[] foodList=granary.haveFood();
        if(foodList!=null){
            for(int i=0;i<foodList.length;i++){
                if(foodList[i]==this.food){
                    foodList[i]=eat(foodList[i]);
                    break;
                }
            }
        }
    }
    
    //chew some part of the food
    public String eat(String food){
        return food+" eaten by "+this.name;
    }
    //Although Java pass the arguments by their references, this method can not change the value of "food"
    //Because 《food=food+"x"》 will create a new copy of string food, thus will not change the original argument
    public void eat2(String food){
        food=food+" eaten by "+this.name;
    }
    
    public String toString(){
        return "[Name: "+this.name+"], [Food: "+this.food+"]";
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    Rodent(){
        System.out.println("Rodent constructor{}");
        this.name="";
        this.food="";
        System.out.println(">>> A Rodent model is prepared!");
    }
    
    {
        System.out.println("Object Constructor{}");
        System.out.println("Before Rodent constructor{}: Initialize fields and methods.");
    }
    
    /**
     *  PACKAGE ACCESS FIELDS
     */
    String food;
    String name;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        System.out.println(Rodent.newRodent().toString());
    }

}