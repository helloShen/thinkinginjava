/**
 *  Dog bark
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;
import com.ciaoshen.thinkinjava.chapter3.*;


/**
 *  Inherit the Dog class in Chapter 3
 */
public class HowlingDog extends com.ciaoshen.thinkinjava.chapter3.Dog {

    //tag to notice if the dog howls
    public boolean itHowls = false;
    
    public HowlingDog(String inName, String inSays){
        super(inName,inSays);
    }
    
    public void bark(){
        System.out.println(this.name+" is barking");
    }
    
    public void bark(String who){
        System.out.println(this.name+" "+this.says+" to "+who);
        this.itHowls=true;
    }
    
    public void bark(String who, int times){
        for(int i=0;i<times;i++){
            System.out.println(this.name+" "+this.says+" to "+who);
        }
        this.itHowls=true;
    }
    
    public void bark(int times, String who){
        System.out.print(this.name+" ");
        for(int i=0;i<times;i++){
            System.out.print(this.says);
        }
        System.out.println(" to "+who);
        this.itHowls=true;
    }
    
    public void finalize(){
        if(! this.itHowls){
            System.out.println("Error, please do not kill "+this.name+", it doesn't howl!");
            //super.finalize();     //在基类finalize()中加入一些异常处理流程。在异常处理的一章专门练习。
        }
    }
    
    /**
     *  main
     *  @param args void.
     */
    public static void main(String args[]){
        HowlingDog puppy = new HowlingDog("spots","Ruff!");
        //puppy.bark();
        //puppy.bark("shen");
        //puppy.bark("shen",5);
        puppy.bark(5,"shen");
        puppy = new HowlingDog("titi","JOJOJO");
        System.gc();
        
        HowlingDog nicePuppy = new HowlingDog("cruffy","Wurf!");
        nicePuppy.bark();
        nicePuppy = new HowlingDog("tata","BiuBiu");
        System.gc();
        
    }
}