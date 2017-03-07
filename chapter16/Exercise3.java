/**
 *  Exercise3
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise3{
    
    public static Double[][] makeDoubleArray(int x,int y,int min,int max){
        Random rand=new Random();
        Double[][] d=new Double[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                d[i][j]=(double)min+(max-min)*rand.nextDouble();
            }
        }
        return d;
    }
    
    public static void printArray(Double[][] d){
        System.out.println(Arrays.deepToString(d));
    }
    
    public static void main(String[] args){
        Exercise3.printArray(Exercise3.makeDoubleArray(2,3,0,100));
    }
}