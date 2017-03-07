/**
 *  Exercise 12 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;


class Group {
    static public final String POEM =
    "Twas brillig, and the slithy toves\n" +
    "Did gyre and gimble in the wabe.\n" +
    "All mimsy were the borogoves,\n" +
    "And the mome raths outgrabe.\n\n" +
    "Beware the Jabberwock, my son,\n" +
    "The jaws that bite, the claws that catch.\n" +
    "Beware the Jubjub bird, and shun\n" +
    "The frumious Bandersnatch.";
    
    public static void exercise12(){
        HashSet<String> hs=new HashSet<String>();
        Matcher m=Pattern.compile("(?m)\\p{Lower}\\w*").matcher(POEM);
        while(m.find()) {
            hs.add(m.group());
        }
        System.out.println(hs.size());
        for(Iterator<String> it=hs.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
    
    public static void main(String[] args) {
        Group.exercise12();
    }
}