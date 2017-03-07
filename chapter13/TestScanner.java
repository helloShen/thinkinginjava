/**
 *  Exercise 20 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;


class TestScanner{
    
    public TestScanner(String inPara){
        Scanner sn=new Scanner(inPara);
        sn.useDelimiter("\\s*;\\s*");
        if(sn.hasNextInt()){
            i=sn.nextInt();
        }
        if(sn.hasNextLong()){
            l=sn.nextLong();
        }
        if(sn.hasNextFloat()){
            f=sn.nextFloat();
        }
        if(sn.hasNextDouble()){
            d=sn.nextDouble();
        }
    }
    
    public String toString(){
        return "{"+i+"; "+l+"; "+f+"; "+d+"}";
        
    }
    
    int i=0;
    long l=0L;
    float f=0.0F;
    double d=0.0D;
    
    public static void main(String[] args){
        TestScanner ts=new TestScanner("17; 56789 ;2,7 ;3,61412 ;hello");
        System.out.println(ts);
    }
}


