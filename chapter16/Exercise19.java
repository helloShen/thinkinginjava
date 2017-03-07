/**
 * Exercise19
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise19 {
    public static void main(String[] args) {
        EleToCompare[] ea1=new EleToCompare[5];
        EleToCompare[] ea2=new EleToCompare[5];
        
        for(int i=0;i<5;i++){
            ea1[i]=new EleToCompare(10);
            ea2[i]=new EleToCompare(10);
        }
        
        System.out.println(ea1[1].equals(ea2[1]));
        System.out.println(Arrays.equals(ea1,ea2));
    }
}