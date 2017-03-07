/**
 *  Exercise 9: Write a program that demonstrates that autoboxing works for all the primitive types and their wrappers.
 *
 *  Exercise 10: Write a program that prints three arguments taken from the command line. To do this, you’ll need to index into the command-line array of Strings.
 *
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;

/**
 *  Test autoboxing works for all the primitive types.
 */
public class AutoBoxing {

    /**
     *  7 of 8 primitive types.
     *  initialized by their default value.
     */
    Integer i = new Integer(0);
    Long l = new Long(0L);
    Short s = new Short((short)0);
    Byte bt = new Byte((byte)0);
    Character c = new Character((char)0);
    Float f = new Float(0.0f);
    Double d = new Double(0.0d);
    Boolean b = new Boolean(false);
    
    /**
    *  print three of them. convert them to String
    *  @param no parameter.
    */
    public void printThree(){
        System.out.println(this.i);
        System.out.println(Long.valueOf(this.l));
        System.out.println(Character.toString(this.c));
    }
    
    /**
     *  main class: Exercise 9 and Exercise 10.
     *  @param args : give me 3 paras here.
     *  args[0]: int
     *  args[1]: long   ex: 2000L
     *  args[2]: char or String
     */
    public static void main (String args[]){
        //create the new AutoBoxing object
        AutoBoxing letsGo = new AutoBoxing();
        
        //print 3 of them
        letsGo.printThree();
        
        
        //exercise 9: autoboxing
        //assign a value for each
        letsGo.i=100;
        letsGo.l=1000L;
        letsGo.s=10;
        letsGo.bt=100;
        letsGo.c='x';
        letsGo.f=1.1f;
        letsGo.d=2.2d;
        letsGo.b=true;
        
        //print 3 of them
        letsGo.printThree();
        
        
        //exercise 10: get the arguments from command line
        //parse the argument into Integer, Long, and Char
        letsGo.i=Integer.parseInt(args[0]);
        letsGo.l=Long.parseLong(args[1]);
        letsGo.c=args[2].charAt(0);
        
        //print 3 of them
        letsGo.printThree();
    }

}