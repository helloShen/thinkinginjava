/**
 *  Exercise5
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise5{
    public static void main(String[] args){
        int[][][] one;
        int[][][] two=new int[2][][];
        int[][][] three=new int[2][3][];
        int[][][] four=new int[2][3][4];
        
        //System.out.println(Arrays.deepToString(one)); //没有初始化
        System.out.println(Arrays.deepToString(two));
        System.out.println(Arrays.deepToString(three));
        System.out.println(Arrays.deepToString(four));
    }
}