/**
 *  Exercise 5
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public enum Exercise5 {

    VOWEL("aeiou".split("")),
    SOMETIMES_A_VOWEL("y","w"),
    CONSONANT("bcdfghjklmnpqrstvxz".split(""));

    private String[] members;
    private Exercise5(String... letters){
        members=letters;
    }
    public String[] getMembers(){return members;}

    public static void main(String[] args) {
        Random rand = new Random();
        List<String> vo=Arrays.asList(VOWEL.getMembers());
        List<String> some=Arrays.asList(SOMETIMES_A_VOWEL.getMembers());
        List<String> con=Arrays.asList(CONSONANT.getMembers());
        for(int i = 0; i < 100; i++) {
            int ic=rand.nextInt(26) + 'a';
            String sc = new String(new char[]{(char)ic});
            System.out.println(sc + ", " + ic + ": "+(vo.contains(sc)? "Vowel":"")+(some.contains(sc)? "Sometime a Vowel":"")+(con.contains(sc)? "Consonants":""));
        }
    }
}