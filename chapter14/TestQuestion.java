/**
 *  Question
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class A{
    public void m1(){System.out.println("AM1");}
    public void m2(){System.out.println("AM2");}
    public void m3(){System.out.println("AM3");}
}

class B extends A{
    @Override
    public void m1(){System.out.println("BM1");}
}

class C extends B{
    @Override
    public void m3(){System.out.println("CM3");}
}

public class TestQuestion{
    public static void main(String[] args){
        A a=new A();
        B b=new B();
        C c=new C();
        
        System.out.println(">>>A");
        a.m1();
        a.m2();
        a.m3();
        System.out.println(">>>B");
        b.m1();
        b.m2();
        b.m3();
        System.out.println(">>>C");
        c.m1();
        c.m2();
        c.m3();
        
        A ac=new C();
        System.out.println(">>>AC");
        ac.m1();
        ac.m2();
        ac.m3();
    }
}