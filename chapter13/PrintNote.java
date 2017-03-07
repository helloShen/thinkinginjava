/**
 *  Exercise 17-19 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;
import com.ciaoshen.thinkinjava.myUtil.*;

//simulate the jgrep in unix
public class PrintNote {
    
    public static void getBigNote(String inAdress){
        int index=0;
        String s=MyBufferedReader.readFile(inAdress);
        Matcher m=Pattern.compile("/\\*(.*)\\*/",Pattern.DOTALL).matcher(s);
        while(m.find()){
            System.out.println(index++ + ": " +
                               m.group()+"  At position: "+m.start());
        }
    }
    
    public static void getSmallNote(String inAdress){
        int index = 0;
        MyBufferedReader mbr=new MyBufferedReader(inAdress);
        MyBufferedReader.Iterator it=mbr.iterator();
        Matcher m=Pattern.compile("//.*").matcher("");
        while(it.hasNext()){
            index++;
            m.reset(it.next());
            while(m.find()){
                System.out.println("Line "+index + ": " +
                                   m.group());
            }
        }
        
    }
    
    // filter the note like this /* ... */
    // return an array of String
    public static String[] filterBigNote(String inAdress){
        int index=0;
        String s=MyBufferedReader.readFile(inAdress);
        Matcher m=Pattern.compile("/\\*(.*)\\*/",Pattern.DOTALL).matcher(s);
        String r=m.replaceAll("");
        return r.split("\\n");
    }
    
    // get the string array from filterBigNote
    // filter the note like this //...
    // return another string array
    public static String[] filterSmallNote(String[] strList){
        String[] r=new String[strList.length];
        //get matcher
        Matcher m=Pattern.compile("//.*").matcher("");
        //match each line
        for(int i=0;i<strList.length;i++){
            m.reset(strList[i]);
            r[i]=m.replaceAll("");
        }
        return r;
    }
    
    // get the string array from filterBigNote or filterSmallNote
    // find all class name(word begin with the Upper case character)
    // return the set of the class name
    public static Set<String> getClassName(String[] strList){
        Set<String> classSet=new HashSet<String>();
        //get matcher
        Matcher upper=Pattern.compile("\\p{Upper}\\w*").matcher("");
        Matcher notAllUpper=Pattern.compile("[\\p{Upper}_]+").matcher("");
        //match each line
        for(int i=0;i<strList.length;i++){
            upper.reset(strList[i]);
            while(upper.find()){
                notAllUpper.reset(upper.group());
                if(!notAllUpper.matches()){
                    classSet.add(upper.group());
                }
            }
        }
        return classSet;
    }
    
    public static void exercise17(String inAdress){
        getBigNote(inAdress);
        getSmallNote(inAdress);
    }
    
    public static void exercise18(String inAdress){
        String[] rltList=filterSmallNote(filterBigNote(inAdress));
        for(int i=0;i<rltList.length;i++){
            System.out.println(rltList[i]);
        }
    }
    
    public static void exercise19(String inAdress){
        Set<String> cn=getClassName(filterSmallNote(filterBigNote(inAdress)));
        System.out.println(cn);
    }
    
    public static void main(String[] args) throws Exception {
        //PrintNote.exercise17("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/JGrep.java");
        //PrintNote.exercise18("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/JGrep.java");
        PrintNote.exercise19("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/JGrep.java");
    }
}