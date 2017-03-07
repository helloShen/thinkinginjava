/**
 *  对象初始化顺序：
 *  1. 基类静态代码块，基类静态成员字段
 *  2. 派生类静态代码块，派生类静态成员字段
 *  3. 基类普通代码块，基类普通成员字段
 *  4. 基类构造函数
 *  5. 派生类普通代码块，派生类普通成员字段
 *  6. 派生类后遭函数
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;


class Log{
    
    static String baseFieldInit(){System.out.println("Base Normal Field");return "";}
    
    static String baseStaticFieldInit(){System.out.println("Base Static Field");return "";}
    
    static String fieldInit(){System.out.println("Normal Field");return "";}
    
    static String staticFieldInit(){System.out.println("Static Field");return "";}
    
}

class Base {
    /*1*/ static {System.out.println("Base Static Block 1");}
    
    /*1*/ private static String staticValue=Log.baseStaticFieldInit();
    
    /*1*/ static {System.out.println("Base Static Block 2");}
    
    /*3*/ {System.out.println("Base Normal Block 1");}
    
    /*3*/ private String value=Log.baseFieldInit();
    
    /*3*/ {System.out.println("Base Normal Block 2");}
    
    /*4*/ Base(){System.out.println("Base Constructor");}
}

public class TestInit extends Base{
    
    /*2*/ static {System.out.println("Static Block 1");}

    /*2*/ private static String staticValue=Log.staticFieldInit();
    
    /*2*/ static {System.out.println("Static Block 2");}
    
    /*5*/ {System.out.println("Normal Block 1");}
    
    /*5*/ private String value=Log.fieldInit();
    
    /*5*/ {System.out.println("Normal Block 2");}
    
    /*6*/ TestInit(){System.out.println("Constructor");}


    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        TestInit ti=new TestInit();
        TestInit ti2=new TestInit();
    }
}
