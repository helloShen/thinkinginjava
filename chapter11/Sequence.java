/**
 *  Implement Iterator Pattern
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class SeqArrayList {
    
    /**
     *  PRIVATE INNER CLASS
     */
    private class Pointer {
        //methods
        public boolean hasNext(){return index!=charSeq.length;}
        public char next(){
            if(index<charSeq.length){index++;}
            return charSeq[index-1];
            
        }
        //constructor of inner
        private Pointer() {index=0;}
        //fields
        private int index;
    }
    
    /**
     *  PUBLIC METHODS
     */
    public Pointer getPointer(){return new Pointer();}
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Sequence(String inStr){
        charSeq=inStr.toCharArray();
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private char[] charSeq;
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        Sequence testSeq=new Sequence("So an inner class has automatic access to the members of the enclosing class.");
        Pointer testPointer=testSeq.getPointer();
        while(testPointer.hasNext()){
            System.out.print(testPointer.next()+"-");
        }
    }
}