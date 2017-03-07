/**
 *  Exercise9
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

class ArrayOfGenericType<T> {
    List<T> array;
    public ArrayOfGenericType() {
        array = new ArrayList<T>();
    }
}

public class Exercise10{
    public static void main(String[] args){
        ArrayOfGenericType<String> agt=new ArrayOfGenericType<String>();
    }
}
