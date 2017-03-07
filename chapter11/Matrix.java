package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;


public class Matrix {
    
    @Override
    public int hashCode(){
        int[] hash=new int[2];
        for(int i=0;i<2;i++){
            hash[i]=Arrays.hashCode(matrix[i]);
        }
        return Arrays.hashCode(hash);
    }
    
    @Override
    public boolean equals(Object o){
        Matrix inM=(Matrix)o;
        for(int i=0;i<2;i++){
            if(!Arrays.equals(inM.matrix[i],this.matrix[i])){
                return false;
            }
        }
        return true;
    }
    
    //constructor
    public Matrix(int a,int b,int c,int d){
        matrix=new int[2][2];
        matrix[0][0]=a;
        matrix[0][1]=b;
        matrix[1][0]=c;
        matrix[1][1]=d;
    };
    
    //fields
    private int[][] matrix;
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        HashSet<Matrix> hs = new HashSet<Matrix>();
        Matrix m1 = new Matrix(1,2,3,4);
        Matrix m2 = new Matrix(5,6,7,8);
        
        hs.add(m1);
        System.out.println(hs.contains(m1));
        System.out.println(hs.contains(m2));
    }

}