/**
 * Exercise18
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise18 {
    public static void main(String[] args) {
        Sphere[] sa1=Generated.array(Sphere.class,new SphereGenerator(),5);
        Sphere[] sa2=Generated.array(Sphere.class,new SphereGenerator(),10);
        
        System.out.println("Array 1:    "+Arrays.toString(sa1));
        System.out.println("Array 2:    "+Arrays.toString(sa2));
        
        //从sa1数组的2号下标的元素开始的3个元素，复制到sa2数组的5号下标开始的3个槽位。
        System.arraycopy(sa1,2,sa2,5,3);
        System.out.println("Array 2:    "+Arrays.toString(sa2));
        
        //把sa1数组的3号下标的元素id改成100。
        sa1[3].setId(100);
        System.out.println("Array 2:    "+Arrays.toString(sa2));
    }
}