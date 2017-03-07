/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.chapter14;

public class Exercise13 {
    public static void main(String[] args){
        TypeCounter tc=new TypeCounter(Part.class);
        for(int i=0;i<10;i++){
            tc.count(Part.createRandom());
        }
        System.out.println(tc);
    }
}
