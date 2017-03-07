/**
 *  Bitwise operators exercises.
 *  @author shenwei
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;


/**
 *  class
 */
public class Bitwise {
    public int max = 0x7fffffff; //最大int数。31个1。
    public int x =0x7abcdefa; // 二进制：1111010101111001101111011111010. int最高位标正负，31位有效位，这个数最高有效位为1，符合要求。
    public char c = 'x';
    
    //default constructor
    public Bitwise(){ };
    
    //Start with a number that has a binary one in the most significant position (hint: Use a hexadecimal constant). Using the signed right-shift operator, right shift it all the way through all of its binary positions, each time displaying the result using Integer.toBinaryString( ).
    public void exercise11 (){
        //there are 31 bits in the int number
        int i =31;
        
        while (true) {
            System.out.println(Integer.toBinaryString(this.x));
            if (i>0){
                this.x >>= 1;
                i--;
            } else {
                break;
            }
        }
    }
    
    public void exercise12 (){
        //there are 31 bits in the int max
        int i =31;
        
        System.out.println(Integer.toBinaryString(this.max)+"   //十进制："+this.max);
        //left-shift
        this.max <<= 1;
        //right shift unsigned through all of its binary positions.
        while (true) {
            System.out.println(Integer.toBinaryString(this.max)+"   //十进制："+this.max);
            if (i>0){
                this.max >>>= 1;
                i--;
            } else {
                break;
            }
        }
    }
    
    //print char c in different form
    public void exercise13 (){
        System.out.println(Character.toString(this.c)+" //text");
        System.out.println(Integer.toString(this.c)+" //十进制，Integer.toString()默认10进制");
        System.out.println(Integer.toBinaryString(this.c)+"    //二进制");
        System.out.println(Integer.toString(this.c,8)+"    //八进制");
        System.out.println(Integer.toString(this.c,16)+"    //十六进制");
    }
    
    //自己加的练习，基本型类型转换
    public void exercise14 (){
        int i = 0x7fffffff; //最大int，char和short里放不下
        System.out.println(i);
        System.out.println((float)i);
        System.out.println((long)i);
        System.out.println((short)i);
        System.out.println((char)i);
    }
    
    /**
     *  main class
     *  @param args void
     */
    public static void main(String args[]){
        Bitwise testInt = new Bitwise();
        
        testInt.exercise11();
        testInt.exercise12();
        testInt.exercise13();
        testInt.exercise14();
    }
}