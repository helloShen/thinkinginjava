/**
 * Find the code fragments involving ATypeName and turn them into a program that compiles and runs.
 * @author Wei SHEN
 * @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;


/**
 * Define a new datatype to represent a circle.
 */
public class Circle {
    /**
     * The class is composed of two values.
     */

    //The center of the circle, represented by a pair of int(x,y).
    public int[] center = new int[2];

    //The radius of the cirle.
    public int radius = 0;

    /**
     * The constructor of circle without parameters.
     */
    public Circle(){
        this.center[0] = 0;
        this.center[1] = 0;
        this.radius = 0;
    }
    
    /**
     * The constructor of circle with parameters.
     * @param x x value of center
     * @param y y value of center
     * @param radius size of the circle
     */
    public Circle(int x, int y, int radius){
        this.center[0] = x;
        this.center[1] = y;
        this.radius = radius;
    }

    /**
     * the main class
     * @param args is not used here
     */
    public static void main(String args[]){
        //create my new circle
        Circle myCircle = new Circle(1,2,3);

        //print the parameter of the circle
        System.out.println(myCircle.center[0]);
        System.out.println(myCircle.center[1]);
        System.out.println(myCircle.radius);
        return;
    }


}