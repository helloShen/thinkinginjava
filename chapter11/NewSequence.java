/**
 *  Chapter 11 Container - Exercise 9
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class NewSequence {

    /**
     *  CONSTRUCTOR
     */
    public NewSequence(int inSize) {
        items = new Object[inSize];
        size=inSize;
        next=0;
    }
    
    /**
     *  METHODS
     */
    public void add(Object x) {
        if(next < items.length){
            items[next++] = x;
        }
    }
    
    public String toString(){
        if(size>0){
            String s=new String("");
            for(int i=0;i<size;i++){
                s=s+items[i]+" ";
            }
            return s;
        } else{
            return null;
        }
    }
    
    /** 关掉
    //return inner class reference
    public Selector selector() {
        return new SequenceSelector();
    }
    */
    public Iterator<Object> iterator() {
        return new Itr();
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private Object[] items;
    private int size;
    private int next;
    

    /**
     *  INNER CLASS
     */
    private class Itr implements Iterator<Object> {
        private int cursor=0;
        
        public boolean hasNext(){
            return cursor<size;
        }
        
        public Object next(){
            if(cursor<size){
                return items[cursor++];
            } else {
                return null;
            }
        }
    }
    
    /** 关掉
     /**
     *  INNER CLASS
     private class SequenceSelector implements Selector {
     private int i = 0;
     public boolean end() { return i == items.length; }
     public Object current() { return items[i]; }
     public void next() { if(i < items.length) i++; }
     }
     */
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        NewSequence ns = new NewSequence(10);
        for(int i = 0; i < 10; i++){
            ns.add(Integer.toString(i));
        }
        System.out.println(ns);
        Iterator<Object> it = ns.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");

        }
    }
}