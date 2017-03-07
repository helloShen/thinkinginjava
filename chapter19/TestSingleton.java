/**
 *  测试单例模式
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class TestSingleton{
    private static final TestSingleton ONE=new TestSingleton(1);
    
    private TestSingleton(int id){this.id=id;}
    private int id;
    public void show(){System.out.println(id);}
    
    public static void main(String[] args){
        ONE.show();
    }
}