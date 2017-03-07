/**
 *  Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public enum Letters {

    VOWEL(Letter.Vowel.class),
    SOMETIMES_A_VOWEL(Letter.SometimesAVowel.class),
    CONSONANT(Letter.Consonant.class);

    private Letter[] values;
    private Letters(Class<? extends Letter> c){
        values=c.getEnumConstants();
    }
    public Letter[] getValues(){
        return values;
    }

    public interface Letter{
        public enum Vowel implements Letter{
            A('a'),E('e'),I('i'),O('o'),U('u');
            private char name;
            private Vowel(char n){name=n;}
            public String toString(){return new String(new char[]{name});}
        }
        public enum SometimesAVowel implements Letter{
            Y('y'),W('w');
            private char name;
            private SometimesAVowel(char n){name=n;}
            public String toString(){return new String(new char[]{name});}
        }
        public enum Consonant implements Letter{
            B('b'),C('c'),D('d'),F('f'),G('g'),H('h'),J('j'),K('k'),L('l'),M('m'),N('n'),P('p'),Q('q'),R('r'),S('s'),T('t'),V('v'),X('x'),Z('z');
            private char name;
            private Consonant(char n){name=n;}
            public String toString(){return new String(new char[]{name});}
        }
    }

    public static void main(String[] args){
        Random rand=new Random();
        for(int j=0;j<10;j++){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<7;i++){
                Letters ls=Enums.random(Letters.class);
                Letter l=Enums.random(ls.getValues());
                sb.append(l.toString());
            }
            System.out.println(sb);
        }
    }
}