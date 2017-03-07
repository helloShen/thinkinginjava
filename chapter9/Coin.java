/**
 *  Chapter 9 - Exercise 19
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

/**
 *  Only package access
 */
class Coin implements Rander {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */
    public static Coin createCoin(){return new Coin();}
    
    /**
     *  METHODS
     */
    public int tossing(){
        int num=this.coinRander.nextInt(2);
        System.out.println(num);
        return num;
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Coin(){
        this.coinRander=new Random();
    }
    
    /**
     *  PRIVATE FIELDS
     */
    Random coinRander;
    /**
     *  MAIN void
     */
    public static void main(String[] args){
        
    }
    
}