/**
 *  Exercise1
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

class CallArray{
    public static void showArray(String[] ss){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ss.length;i++){
            sb.append("{").append(ss[i]).append("}");
            if(i<ss.length-1){
                sb.append("--");
            }
        }
        System.out.println(sb.toString());
    }
}

public class Exercise1{
    public static void main(String[] args){
        //CallArray.showArray({"AAA","BBB","CCC"});
        CallArray.showArray(new String[]{"AAA","BBB","CCC"});
    }
}