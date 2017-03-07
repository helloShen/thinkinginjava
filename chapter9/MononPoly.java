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
class MononPoly {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */
    
    /**
     *  METHODS
     */
    public void mononRander(RanderFactory inFac){
        Rander theRander=inFac.getRander();
        theRander.tossing();
    }
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */

    /**
     *  MAIN void
     */
    public static void main(String[] args){
        MononPoly myGame=new MononPoly();
        RanderFactory diceFac=new DiceFactory();
        RanderFactory coinFac=new CoinFactory();
        myGame.mononRander(diceFac);
        myGame.mononRander(coinFac);
    }
    
}