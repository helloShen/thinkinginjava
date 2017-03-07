/**
 *  Exercise 16: (5) Create a Set of the vowels. Working from UniqueWords.Java, count and display the number of vowels in each input word, and also display the total number of vowels in the input file.
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class Vowels {
    
    //sorted alphabetically
    public final static Set<String> VOWEL=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    
    static{
        VOWEL.addAll(Arrays.asList("auieoAUIEO".split("")));
    }
    
    public static void main(String[] args){
        for (String s : Vowels.VOWEL){
            System.out.println(s);
        }
    }

}