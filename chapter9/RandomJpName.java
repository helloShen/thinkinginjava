/**
 *  Chapter 9 - Exercise 16
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import java.nio.*;

/**
 *  Only package access
 */
public class RandomJpName implements Readable {
    
    /**
     *  PUBLIC PROXY OF CONSTUCTOR
     */
    public static RandomJpName createJpNameGenerator(int nameNum){
        return new RandomJpName(nameNum);
    }
    
    /**
     *  METHODS
     */
    //read() method required by Readable interface
    public int read(CharBuffer inBuffer){
        if(count--==0){
            return -1;
        }
        Random charRander=new Random();
        //Japanese name has 4 syllable
        for(int i=0;i<4;i++){
            inBuffer.append(CONSONANT[charRander.nextInt(CONSONANT.length)]);
            inBuffer.append(VOWEL[charRander.nextInt(VOWEL.length)]);
        }
        inBuffer.append(" ");
        return 9;
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private RandomJpName(int nameNum){
        this.count=nameNum; //initialize the number of name to generate.
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private static final char[] CONSONANT="kstnhmyrw".toCharArray();
    private static final char[] VOWEL="aiueo".toCharArray();
    int count;
    
    /**
     *  MAIN void
     */
    public static void main(String[] args){
        Scanner s = new Scanner(RandomJpName.createJpNameGenerator(10));
        while(s.hasNext()){
            System.out.println(s.next());
        }
    }
    
}