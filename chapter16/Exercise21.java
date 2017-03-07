/**
 * Exercise21
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise21 {
    public static void main(String[] args) {
        Sphere[] sa1=Generated.array(Sphere.class,new SphereGenerator(),5);
        Sphere[] sa2=Generated.array(Sphere.class,new SphereGenerator(),10);

        System.arraycopy(sa1,2,sa2,5,3);
        sa1[3].setId(100);
        
        //未排序前
        System.out.println("Before Sort:    "+Arrays.toString(sa2));
        
        Arrays.sort(sa2, new SphereComparator());
        
        //排序后
        System.out.println("After Sort:    "+Arrays.toString(sa2));
    }
}