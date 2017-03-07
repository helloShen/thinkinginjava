/**
 *  Compose object
 */

package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;

/**
 *  Compose of simple objects
 */
public class IniObj {
    
    public String toString(){
        return this.obj1.s;
    }
    
    public SimpObj obj1;
    public final int finalValue;
    public static final int staticFinalValue;
    
    public static void main(String[] args){
        IniObj testIniObj = new IniObj();
        //惰性初始化
        testIniObj.obj1=new SimpObj();
        testIniObj.obj1.s="Now I need to use it!";
        System.out.println(testIniObj.toString());
    }
}


class SimpObj {
    //not initialized
    String s;
    
}
