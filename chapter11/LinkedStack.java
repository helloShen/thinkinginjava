/**
 *  A simple stack with only push() and pop() method, and an iterator
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class LinkedStack {

    /**
     *  INNER CLASS
     */
    private class Itr implements Iterator<String> {
        private int cursor;
        
        public boolean hasNext(){
            return cursor<ls.size();
        }
        public String next(){
            if(cursor>=ls.size()){
                return null;
            } else {
                return ls.get(cursor++);
            }
        }
        private Itr(){cursor=0;}
    }
    
    /**
     *  METHODS
     */
    public void push(String str){
        ls.addFirst(str);
    }
    public String pop(){
        if(ls.size()>0){
            String s=ls.getFirst();
            ls.removeFirst();
            return s;
        } else {
            return null;
        }
    }
    public void read(String command){
        if(command.length()>0){
            char[] s=command.toCharArray();
            int i=0;
            int max=s.length;
            while(i<max){
                if(Character.compare(s[i],'+')==0){
                    if(i+1<max){
                        push(String.valueOf(s[++i]));
                    }
                } else if(Character.compare(s[i],'-')==0){
                    System.out.print(pop());
                }
                i++;
            }
        }
    }
    public Itr iterator(){
        return new Itr();
    }
    public String toString(){
        if(ls.size()>0){
            String result="";
            for(String s : ls){
                result=result+s+" ";
            }
            return result;
        } else {
            return null;
        }
    }
    
    /**
     *  CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    private LinkedList<String> ls =new LinkedList<String>();
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        //just for test
        //LinkedStack ls=new LinkedStack();
        //ls.push("A");
        //ls.push("B");
        //ls.push("C");
        //System.out.println(ls);
        //System.out.println(ls.pop());
        
        //excise 15
        //String command="+U+n+c---+e+r+t---+a+i+n+t+y---+ -+r+u--+l+e+s---";
        //LinkedStack ls=new LinkedStack();
        //ls.read(command);
        
        
    }

}