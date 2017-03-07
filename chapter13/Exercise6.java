/**
 * Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

public class Exercise6 {
    private static final int i=100;
    private static final long l=10000l;
    private static final float f=10000.00f;
    private static final double d=100000.00;
    public String toString(){
        return String.format("Int: %1$-15d Long: %2$-15d Float: %3$-15.1f Double: %4$-15.7e", i, l, f, d);
    }
    public static void main(String[] args){
        Exercise6 ex=new Exercise6();
        System.out.println(ex);
    }
}
