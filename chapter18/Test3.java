/**
 *  知乎答题
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

class Test3{
    
    public String addStr(String s){
        s = s + "bbb";
        return s;
    }
    public StringBuilder addBui(StringBuilder s){
        s.append("bbb");
        return s ;
    }
    
    public static void main(String[] args){
        Test3 three = new Test3() ;
        //	String str = "a" ;
        String str = new String("aaa");
        System.out.println(three.addStr(str).toString());
        
        StringBuilder sb = new StringBuilder();
        sb.append("aaa") ;
        System.out.println(three.addBui(sb).toString());
    }
    }
}


