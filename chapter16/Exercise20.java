/**
 * Exercise20
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise20 {
    public static void main(String[] args) {
        EleToCompare[][] d1=new EleToCompare[3][3];
        EleToCompare[][] d2=new EleToCompare[3][3];
        
        for(int i=0;i<3;i++){
            Arrays.fill(d1[i],new EleToCompare(10));
            Arrays.fill(d2[i],new EleToCompare(10));
        }
        
        System.out.println(Arrays.deepEquals(d1,d2));
    }
}