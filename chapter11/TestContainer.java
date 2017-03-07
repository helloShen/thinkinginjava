/**
 *  ArrayList test
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class TestContainer {
    
    /**
     *  PUBLIC STATIC FIELDS
     */
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public void useCollection(){
        Collection<Integer> c = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            c.add(i);
        }
        for(int i : c){
            System.out.println(i+" ");
        }
    }
    
    public void useSet(){
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0;i<10;i++){
            s.add(i);
        }
        for(int i : s){
            System.out.println(i+" ");
        }
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        TestContainer test=new TestContainer();
        test.useCollection();
        test.useSet();
    }
}