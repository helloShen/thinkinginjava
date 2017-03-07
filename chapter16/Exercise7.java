/**
 *  Exercise7
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise7{
    public static Sphere[][][] fill3DSphere(int x,int y,int z){
        Sphere[][][] s=new Sphere[x][y][z];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                for(int k=0;k<z;k++){
                    s[i][j][k]=new Sphere();
                }
            }
        }
        return s;
    }
    
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(Exercise7.fill3DSphere(3,4,5)));
    }
}