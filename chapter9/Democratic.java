/**
 *  Chapter 9 - Interface - Strategy Pattern
 *  Implements the interface Party
 *  Democratic is more friendly to the illegal immigrants
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import java.lang.Math;

class Democratic extends PartyMember {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public int immigrantPolicy(int illegalImmigrant){
        return (int)(illegalImmigrant*1.1);
    }
    
    public int educationPolicy(int educationScore){
        return (Math.max(0,(educationScore-5)));
    }
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    Democratic(String inputName){
        super(inputName);
    }
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}