/**
 *  Literal
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;


public class Literal {

    //many fields
    public int i8 = 012345; //0开头，八进制
    public int i16 = 0x3ab589; //0x开头，十六进制
    
    public long l8 = 012345L; //0开头，八进制，大写L比小写l好，看的清楚。
    public long l16 = 0x4cd424L; //0x开头，十六进制
    
    public float f8 = 012345F; //0开头，八进制
    public float f16 = 0x5ef6F; //0x开头，十六进制，等等，战斗机？
    public double d16 = 0x5ef6D; //0x开头，十六进制，等等，战斗机？
    
    public byte byteMax = 0x7f; //byte允许的最大十六进制。7位二进制，最高位被占用。
    public char charMax = 0xffff; //char允许的最大十六进制。16位二进制。
    public short shortMax = 0x7fff; //short允许的最大十六进制。15位二进制，最高位被占用。
    //float 最高位符号位，8位指数位，23位尾数位，共32位。
    public float floatMin = Float.MIN_VALUE; //float允许最大值。
    public float floatMax = Float.MAX_VALUE; //float允许最小正值。
    //double 最高位符号位，11位指数位，52位尾数位，共64位。
    public double doubleMin = Double.MIN_VALUE; //double允许最大值。
    public double doubleMax = Double.MAX_VALUE; //double允许最小正值。
    //public short sToInt = 0x7fffff; //超出最大值，会自动改成int，并提示我们越界了。
    
    //default constructor
    public Literal(){ };
    
    /**
     *  main method: to print these fields
     *  @param args void
     */
    public static void main(String args[]){
        
        Literal test = new Literal();
        
        //print all fields in the class
        System.out.println(Integer.toBinaryString(test.i8));
        System.out.println(Integer.toBinaryString(test.i16));
        
        System.out.println(Long.toBinaryString(test.l8));
        System.out.println(Long.toBinaryString(test.l16));
        
        System.out.println(Float.toString(test.f8));
        System.out.println(Float.toString(test.f16));
        System.out.println(Double.toString(test.d16));
        
        System.out.println("byte允许最大值："+Integer.toBinaryString(test.byteMax));
        System.out.println("char允许最大值："+Integer.toBinaryString(test.charMax));
        System.out.println("short允许最值："+Integer.toBinaryString(test.shortMax));
        
        System.out.println("float允许最小正值："+Float.toString(test.floatMin));
        System.out.println("float允许最大值："+Float.toString(test.floatMax));
        System.out.println("double允许最小正值："+Double.toString(test.doubleMin));
        System.out.println("double允许最大值："+Double.toString(test.doubleMax));
    }
}