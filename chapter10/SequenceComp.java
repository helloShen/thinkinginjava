/**
 *  Implement Iterator with compositon but not inner class.
 */

package com.ciaoshen.thinkinjava.chapter10;
import java.util.*;

class SequenceComp {
    
    /**
     *  PUBLIC METHODS
     */
    public boolean hasNext(){return index!=charSeq.length;}
    public char next(){
        if(index<charSeq.length){index++;}
        return charSeq[index-1];
        
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private SequenceComp(String inStr){
        charSeq=inStr.toCharArray();
        index=0;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private char[] charSeq;
    //iterator as component
    private int index;
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        SequenceComp testSeq=new SequenceComp("So an inner class has automatic access to the members of the enclosing class.");
        while(testSeq.hasNext()){
            System.out.print(testSeq.next()+"-");
        }
    }
}