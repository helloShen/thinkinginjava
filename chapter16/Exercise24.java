/**
 * Exercise24
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise24 {
    public static void main(String[] args) {
        EleToCompare[] ea1=new EleToCompare[10];
        
        for(int i=0;i<ea1.length;i++){
            ea1[i]=new EleToCompare(i);
        }
        
        Arrays.sort(ea1,new EleToCompareComparator());
        System.out.println(Arrays.binarySearch(ea1,new EleToCompare(6),new EleToCompareComparator()));
    }
}