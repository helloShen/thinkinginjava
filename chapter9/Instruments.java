/**
 *  Chapter 9 - Exercise 9
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

abstract class Instruments implements Instrument,Playable {
    
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    public void adjust() { System.out.println(this + ".adjust()"); }

}