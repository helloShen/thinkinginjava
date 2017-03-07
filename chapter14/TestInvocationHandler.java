/**
 *  Test the Invocation Handler Interface
 */

package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class Plus{public int plus(int a, int b){return a+b;}}

public class TestInvocationHandler implements InvocationHandler{
    public Object invoke(Object o, Method m, Object[] args) throws Throwable{
        return m.invoke(o,args);
    }
    public TestInvocationHandler(Object o,Method m,Object[] args){
        this.o=o;
        this.m=m;
        this.args=args;
    }
    public Object o;
    public Method m;
    public Object[] args;
    public static void main(String[] args){
        try{
            Object o=new Plus();
            Method m=Plus.class.getMethod("plus",int.class,int.class);
            TestInvocationHandler tih=new TestInvocationHandler(o,m,new Object[]{2,3});
            System.out.println(tih.invoke(tih.o,tih.m,tih.args));
        }catch(Exception e){
            System.out.println(e);
        }catch(Throwable t){
            System.out.println(t);
        }
    }
}