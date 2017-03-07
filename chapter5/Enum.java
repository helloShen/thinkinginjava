/**
 *  Enum type
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;



//enum class
enum Difficulty {EASY, NORMAL, HARD, VERYHARD}

/**
 *  our class
 */
public class Enum {
    
    //exercise 22
    public static void interpreter(Difficulty diff){
        switch(diff){
            case EASY:
                System.out.println("Easy is for the beginner！"); break;
            case NORMAL:
                System.out.println("Normal is for those who have some experience！"); break;
            case HARD:
                System.out.println("Hard is for good players！"); break;
            case VERYHARD:
                System.out.println("Very hard is for the super master！"); break;
        }
    }
    
    //exercise 21
    public static void printEnumValue(){
        for(Difficulty d : Difficulty.values()){
            System.out.println("Value: "+d+";   Order: "+d.ordinal());
        }
    }

    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        Enum.interpreter(Difficulty.EASY);
        Enum.interpreter(Difficulty.NORMAL);
        Enum.interpreter(Difficulty.HARD);
        Enum.interpreter(Difficulty.VERYHARD);
        
        Enum.printEnumValue();
    }
}