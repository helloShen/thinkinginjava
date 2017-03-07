/**
 *  calculat speed with length and time.
 *  both the length and time are randomly generated.
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;

/**
 *  Generate randomly length and time
 *  Then calculate the speed.
 */
public class Speed {
    
    private Random rand = new Random(99);
    private int length = 0;
    private int time = 0;
    
    //default constructor use the default seed 99.
    public Speed(){
        this.length = this.rand.nextInt(1000)+1;
        this.time = this.rand.nextInt(100)+1;
    }
    
    //initialize the object by specifying the random seed.
    public Speed(int seed){
        Random newRand = new Random(seed);
        this.rand=newRand;
        this.length = this.rand.nextInt(1000)+1;
        this.time = this.rand.nextInt(100)+1;
    }
    
    //method that calculate the speed.
    public float getSpeed(){
        return (float)this.length/(float)this.time;
    }
    
    //public main method
    public static void main(String args[]){
        Speed test1 = new Speed(88);
        Speed test2 = new Speed(77);
        
        System.out.println(Float.toString(test1.getSpeed()));
        System.out.println(Float.toString(test2.getSpeed()));
    }

}