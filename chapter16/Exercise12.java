/**
 *  Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise12{
    public static void main(String[] args){
        CountingGenerator.Double genD=new CountingGenerator.Double();
        double[] d=new double[10];
        for(int i=0;i<10;i++){
            d[i]=genD.next();
        }
        for(int i=0;i<10;i++){
            System.out.print(d[i]+" ");
        }
    }
}