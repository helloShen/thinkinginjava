/**
 *  Exercise2
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

class Sphere{
    private static int count=0;
    private int id=++count;
    public String toString(){return "Sphere "+id;}
}

public class Exercise2{
    public static Sphere[] collectSphere(int i){
        Sphere[] s=new Sphere[i];
        for(int j=0;j<i;j++){
            s[j]=new Sphere();
        }
        return s;
    }
    
    public static void printSpheres(Sphere[] ss){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append("{").append(ss[i]).append("}");
            if(i<ss.length-1){
                sb.append("--");
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args){
        Exercise2.printSpheres(Exercise2.collectSphere(7));
    }
}