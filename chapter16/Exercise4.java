/**
 *  Exercise4
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise4{
    
    public static Double[][][] makeDoubleArray(int x,int y,int z,int min,int max){
        Random rand=new Random();
        Double[][][] d=new Double[x][y][z];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                for(int k=0;k<z;k++){
                    d[i][j][k]=(double)min+(max-min)*rand.nextDouble();
                }
            }
        }
        return d;
    }
    
    public static void printArray(Double[][][] d){
        System.out.println(Arrays.deepToString(d));
    }
    
    public static void main(String[] args){
        Exercise4.printArray(Exercise4.makeDoubleArray(2,3,2,0,100));
    }
}