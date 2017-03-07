/**
 * Exercise23
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise23 {
    public static void main(String[] args) {
        Integer[] ia=new Integer[10];
        Random rand=new Random();
        for(int i=0;i<ia.length;i++){
            ia[i]=rand.nextInt(10000);
        }
        
        Arrays.sort(ia, Collections.reverseOrder());
        System.out.println(Arrays.toString(ia));
    }
}