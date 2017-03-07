/**
 *  数组的初始化
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

class AAA{}


public class ArrayInit{
    public static void main(String[] args){
        /**
         *  对象数组
         */
        //未初始化
        AAA[] a;
        //常见的创建特定类型和长度的空数组。
        AAA[] b=new AAA[5];
        //创建新数组的时候，直接用大括号{}赋值。
        AAA[] c={new AAA(), new AAA(), new AAA()};
        AAA[] d=new AAA[]{new AAA(), new AAA(), new AAA()};

        
        /**
         *  基本型数组
         */
        //未初始化
        int[] e;
        //常见[]下标创建空数组。每个槽位都默认被初始化为0。
        int[] f = new int[5];
        // 直接用大括号{}赋值
        int[] g = { 11, 47, 93 };
        int[] h= new int[]{ 1, 2 };
    }
}