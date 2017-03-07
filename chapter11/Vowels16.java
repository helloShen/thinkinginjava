// holding/Vowels16.java
// TIJ4 Chapter Holding, Exercise 16, page 419
/* Create a Set of the vowels. Working from UniqueWords.java, count and
 * display the number of vowels in each input word, and also display the total
 * number of vowels in the input file.
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
//import net.mindview.util.*;

public class Vowels16 {
    static void vowelCounter(Set<String> st) {
        Set<Character> vowels = new TreeSet<Character>();
        Collections.addAll(vowels,
                           'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int allVowels = 0;
        for(String s : st) {
            int count = 0;
            for(Character v : s.toCharArray()) {
                if(vowels.contains(v)) {
                    count++;
                    allVowels++;
                }
            }
            //System.out.print(s + ": " + count + ", ");
            //System.out.print(count + ", ");
        }
        System.out.println();
        System.out.println("Total vowels: " + allVowels);
    }
    public static void main(String[] args) {
        //calculate the time
        long start_time = System.nanoTime();
        
        //main action begin
        Set<String> words = new TreeSet<String>(UniqueWords.toWords(UniqueWords.getStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java")));
        //System.out.println(words);
        System.out.println();
        vowelCounter(words);
        
        //calculate the time
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }		
}