/**
 *  Exercise Chapter 10 Hold yr objects
 *  New data type to hold a word and it's occurence in the file
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import com.ciaoshen.thinkinjava.chapter9.RandomJpName;

class StrEntry {
    
    /**
     *  PUBLIC METHODS
     */
    public String getWord(){return word;}
    public int getOccurence(){return occurence;}
    public void set(String inWord, int inOccurence){
        word=inWord;
        occurence=inOccurence;
    }
    
    @Override
    public String toString(){
        return ("[Word: "+word+";   Frequence: "+occurence+"]   ");
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        } else {
            StrEntry se=(StrEntry)obj;
            if(word.equals(se.getWord())){
                return true;
            } else {
                return false;
            }
        }
    }
    
    @Override
    public int hashCode(){
        return word.hashCode();
    }
    
    /**
     *  INNER FACTORY CLASS
     *  fil a list container with random japanese name
     */
    static class StrEntries {
        public void generate(int inNum, Collection<StrEntry> container){
            Scanner s = new Scanner(RandomJpName.createJpNameGenerator(inNum));
            while(s.hasNext()){
                container.add(new StrEntry(s.next(),1));
            }
        }
    }
    
    public static StrEntries getGenerator(){
        return new StrEntry.StrEntries();
    }
    
    /**
     *  CONSTRUCTOR
     */
    public StrEntry(String inWord,int inFreq){
        word=inWord;
        occurence=inFreq;
    }
    public StrEntry(String inWord){
        word=inWord;
        occurence=0;
    }
    /**
     *  PRIVATE FIELDS
     */
    private String word=null;
    private int occurence=0;

}