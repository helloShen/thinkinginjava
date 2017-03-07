/**
 *  Exercise 9 - Polymophism
 *  HaveFood is an interface for the place where we can find food.
 *  Ex: Granary, Kichen, TrashCan
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

interface HaveFood {
    
    /**
     *  PUBLIC METHODS
     */
    public String[] haveFood(); //return the food list
    public String randomFood(); //randomly get a type of food
    public String checkFood();
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public void storeFood(); //charge the food
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */

    /**
     *  PACKAGE ACCESS FIELDS
     */
    String[] foodList=null;
    
    /**
     *  MAIN
     *  @param args void
     */
    
}