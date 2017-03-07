/**
 * Exercise25
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise25 {
    public static void main(String[] args) {
        int[] i={1,2,3,4,5};
        System.out.println(i.getClass());
        System.out.println(Arrays.toString(i));
        System.out.println(i[4]);
        int[] i2=new int[6];
        System.arraycopy(i,0,i2,0,i.length);
        i2[5]=6;
        int[] i3={7,8};
        int[] i4=new int[8];
        System.arraycopy(i2,0,i4,0,i2.length);
        System.arraycopy(i3,0,i4,6,i3.length);
        System.out.println(Arrays.toString(i4));
        int[] i5=new int[2];
        System.arraycopy(i4,2,i5,0,2);
        System.out.println(Arrays.toString(i5));
    }
}
