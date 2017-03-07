/**
 *  use float to demonstrate aliasing.
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;

/**
 *  Our class
 */
class AssignmentOperator {
    public float f = 0.0f;
    
    /**
     *  constructor
     *  @param f
     */
    public AssignmentOperator(float f){
        this.f = f;
    }
    
    /**
     *  This method change the float field in toto to 5.5, cause the parameter pass the reference of the object.
     *  @param toto
     */
    public void forceToChangeTo5(AssignmentOperator toto){
        toto.f = 5.5f;
    }
    
    /**
     *  main method
     *  @param args.
     */
    public static void main(String args[]){
        AssignmentOperator objA = new AssignmentOperator(1.1f);
        AssignmentOperator objB = new AssignmentOperator(2.2f);
        
        //objA and objB refer to the same object
        objA = objB;
        System.out.println(Float.toString(objA.f)+",  "+Float.toString(objB.f)); // output: 2.2f,  2.2f
        
        //objA and objB still refer to the same object
        objA.f = 3.3f;
        System.out.println(Float.toString(objA.f)+",  "+Float.toString(objB.f)); // output: 3.3f,  3.3f
        
        //objA change the value of objB. They still refer to the same object.
        objA.forceToChangeTo5(objB);
        System.out.println(Float.toString(objA.f)+",  "+Float.toString(objB.f)); // output: 5.5f,  5.5f
    }
}
