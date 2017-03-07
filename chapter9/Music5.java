/**
 *  Chapter 9 - Exercise 9
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;


public class Music5 {
    // Doesn’t care about type, so new types
    // added to the system still work right:
    static void tune(Playable p) {
        // ...
        p.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] ps) {
        for(Playable p : ps){
            tune(p);
        }
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Playable[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed()
        };
        tuneAll(orchestra);
    }
}