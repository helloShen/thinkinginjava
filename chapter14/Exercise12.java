/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

public class Exercise12 {
    public static void main(String[] args){
        CoffeeGenerator cg=new CoffeeGenerator(10);
        TypeCounter tc=new TypeCounter(Coffee.class);
        for(Coffee coffee:cg){
            tc.count(coffee);
        }
        System.out.println(tc);
    }
}
