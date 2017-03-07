/**
 *  Exercise6
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise6{
    public static Sphere[][] fill2DSphere(int x,int y){
        Sphere[][] s=new Sphere[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                s[i][j]=new Sphere();
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(Exercise6.fill2DSphere(3,4)));
        
        
    }
}