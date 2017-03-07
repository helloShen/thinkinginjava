/**
 *  exercise 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

class SequenceException {
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
    public SequenceException(String inStr){
        char[] charArray=inStr.toCharArray();
        for(int i=0;i<charArray.length;i++){
            charSeq[i]=charArray[i];
        }
    }

    /**
     *  PRIVATE FIELDS
     */
    private char[] charSeq=new char[20];
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        SequenceException testSeq=null;
        String paraStr="So an inner class has automatic access to the members of the enclosing class.";
        boolean pass=false;
        while(!pass){
            try{
                testSeq=new SequenceException(paraStr);
                pass=true;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("String size="+paraStr.length()+". Too long!!");
                paraStr=paraStr.substring(0,paraStr.length()-1);
            }
        }
        Pointer testPointer=testSeq.getPointer();
        while(testPointer.hasNext()){
            System.out.print(testPointer.next()+"-");
        }
        System.out.println("");
    }
}