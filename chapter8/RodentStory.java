/**
 *  Exercise 9 - Polymophism
 *  A large of rodents invade a granary.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */
package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

public class RodentStory {
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */

    /**
     *  PUBLIC METHODS
     */
    public static void rodentInvadeGranary(){
        //create a granary
        Granary myGranary=new Granary(50);
        myGranary.storeFood();
        //check the granary
        System.out.println(myGranary.checkFood());
        //create a group of rodents
        Rodent[] rodentLegion=groupOfRodent(10);
        //rodents invade the granary
        for(Rodent r: rodentLegion){
            r.invade(myGranary);
        }
        //check the granary
        System.out.println("=================================");
        System.out.println(myGranary.checkFood());
    }
    
    public static Rodent[] groupOfRodent(int number){
        Rodent[] rodentLegion=new Rodent[number];
        Random rodentRander=new Random();
        for(int i=0;i<number;i++){
            int rodentType=rodentRander.nextInt(3);
            switch(rodentType){
                case 0:
                    rodentLegion[i]=Mouse.newRodent(); break;
                case 1:
                    rodentLegion[i]=Gerbil.newRodent(); break;
                case 2:
                    rodentLegion[i]=Hamster.newRodent(); break;
            }
        }
        return rodentLegion;
    }
    /**
     *  PRIVATE CONSTRUCTOR
     */

    /**
     *  PRIVATE FIELDS
     */

    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        //RodentStory.rodentInvadeGranary();
        Rodent[] rodentLegion=RodentStory.groupOfRodent(10);
    }

}