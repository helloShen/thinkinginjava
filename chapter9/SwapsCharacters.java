/**
 *  Chapter 9 - Exercise 11
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class SwapsCharacters implements Processor{
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public String name(){
        return name;
    }

    //main algorithm
    public String process(Object input){
        //String to byte[]
        byte[] byteArray=((String)input).getBytes();
        int index=0;    //iteration flag
        int length=((String)input).length();
        String spaceStr=" ";
        byte[] spaceByte=spaceStr.getBytes();
        //seek 2 characters for each time
        while(index<=length-2){
            //swap the characters if is not space
            if(byteArray[index]!=spaceByte[0] && byteArray[index+1]!=spaceByte[0]){
                //manipulate directly on the byte[]
                byte temp=byteArray[index];
                byteArray[index]=byteArray[index+1];
                byteArray[index+1]=temp;
                index+=2;
            //skip the space
            } else {
                index+=1;
            }
        }
        return new String(byteArray);
    }

    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    private static String name="<Swaps Character processor>";
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        Apply.process(new SwapsCharacters(),"If she weighs the same as a duck, she is made of wood.");
    }

}