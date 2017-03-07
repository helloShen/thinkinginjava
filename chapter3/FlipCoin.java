
/**
 *  flipping a coin
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;

/**
 *  Our class: can be seen as a "coin" which can call flipping method to stimulate "flipping a coin".
 */
public class FlipCoin {
    private Random rander = new Random(99);
    
    
    //constructor
    public FlipCoin(){
        
    }
    
    //constructor with new random seed
    public FlipCoin(int seed){
        this.rander = new Random(seed);
    }
    
    //flipping a coin
    public String flipping (){
        int result = this.rander.nextInt(2);
        if (result == 0){
            return "head";
        } else {
            return "back";
        }
    }
    
    /**
     *  main method
     *  @param args no used.
     */
    public static void main(String args[]){
        FlipCoin myCoin = new FlipCoin(47);
        for (int i=0; i<20; i++){
            System.out.println(myCoin.flipping());
        }
    }
    

}
