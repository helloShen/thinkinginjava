/**
 *  纯测试
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;
import java.lang.reflect.*;

public class TestArray<T>{
    
    //运行时是Object[]
    private Object[] array;
    
    @SuppressWarnings("unchecked")
    public TestArray(Generator<T> gen,Class<T> c,int size){
        array=(T[])Array.newInstance(c,size);
        for(int i=0;i<size;i++){
            array[i]=gen.next();
        }
    }
    
    @SuppressWarnings("unchecked")
    public T[] get(){
        return (T[])array;
    }
    
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            sb.append(array[i]+"\n");
        }
        return sb.toString();
    }
    
    @SuppressWarnings("unchecked")
    public T[] stupidThing(int size){
        return (T[])new Object[size];
    }
    
    public static void main(String[] args){
        TestArray<String> tas=new TestArray<String>(new CountingGenerator.String(),String.class,10);
        System.out.println(tas);
        String[] ss=tas.get();
        
        String[] stupidStr=tas.stupidThing(10);
        //stupidStr[0]="123";
        //stupidStr[0]=123;
        
        List<?> ls=new ArrayList<String>();
        ls.add("abc");
    }
}