/**
 *  Turn the AllTheColorsOfTheRainbow example into a program that compiles and runs.
 *
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter2;

import java.util.*;

/**
 *  Class for Exercise 11.
 */
public class AllTheColorsOfTheRainbow {
    // 7 colors for the rainbow
    // invisible to other users
    // int will be converted to Integer by Java Autoboxing
    private HashMap<Integer,String> rainbowColorMap = new HashMap<Integer,String>();
    
    // the number represent the main color of the rainbow
    // invisible to other users
    private int anIntegerRepresentingColors=0;
    
    //constructor
    public AllTheColorsOfTheRainbow(){
        this.rainbowColorMap.put(1, "red");
        this.rainbowColorMap.put(2, "orange");
        this.rainbowColorMap.put(3, "yellow");
        this.rainbowColorMap.put(4, "green");
        this.rainbowColorMap.put(5, "cyan-blue");
        this.rainbowColorMap.put(6, "blue");
        this.rainbowColorMap.put(7, "purple");
    }
    /**
     *  visible to the user, to manipulate the main color
     *  return the current main color.
     *  @param newHue give me the number of the color according to the RAINBOWCOLORMAP.
     */
    public String changeTheHueOfTheColor(int newHue) {
        
        //set the anIntegerRepresentingColors
        this.anIntegerRepresentingColors=newHue;
        
        //check the color from the RAINBOWCOLORMAP. "Gray" means no color.
        String nowColor=null;
        nowColor=this.rainbowColorMap.get(this.anIntegerRepresentingColors);
        if (nowColor==null){
            System.out.println("Give me another number!!");
            return null;
        } else {
            return nowColor;
        }
    }
    
    /**
     *  main method, set the rainbow color by calling changeTheHueOfTheColor method
     *  @param args args[0] give us the color number.
     */
    public static void main (String args[]){
        //create rainbow object
        AllTheColorsOfTheRainbow myRainbow = new AllTheColorsOfTheRainbow();
        //get the args
        int numColor=-1;
        numColor=Integer.parseInt(args[0]);
        //call changeTheHueOfTheColor method if args exist
        if (numColor!=-1){
            String myRainbowColor=myRainbow.changeTheHueOfTheColor(Integer.parseInt(args[0]));
            if(myRainbowColor!=null){
                System.out.println("The current main color of the rainbow is: "+myRainbowColor);
            }
        } else {
            //if the args is exactly -1
            System.out.println("Give me another number!!");
        }
    }
}