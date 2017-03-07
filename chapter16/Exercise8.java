/**
 *  Exercise8
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;


class ArrayOfGenericType<T> {
    T[] array;
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size){
        array=(T[])new Object[size];
    }
    
    public void insertFirst(T t){
        array[0]=t;
    }
    
    @SuppressWarnings("unchecked")
    public <U> U[] makeArray() { return (U[])new Object[10]; }
}

public class Exercise8{
    public static void main(String[] args){
        ArrayOfGenericType<String> agt=new ArrayOfGenericType<String>(10);
        agt.insertFirst("Hello");
        Object[] str=agt.makeArray();
    }
}