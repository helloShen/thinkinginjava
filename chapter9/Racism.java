/**
 *  Chapter 9 - Interface - Strategy Pattern
 *  Implements the interface Party
 *  Donald Trump is a special one!
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class Racism extends PartyMember {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public int immigrantPolicy(int illegalImmigrant){
        return (illegalImmigrant/2);
    }
    
    public int educationPolicy(int educationScore){
        return (Math.max(0,(educationScore-10)));
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    Racism(String inputName){
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