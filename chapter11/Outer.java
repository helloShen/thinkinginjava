/**
 *  To test the final parameter problem of inner class
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

//外部类
class Outer {
    //获得匿名内部类实例的引用的方法
    public AnonymousInner getAnonymousInner(String paramInfo){
        //实例化匿名内部类
        return new AnonymousInner(){
            
            //匿名内部类的字段也想和外部类字段保持一致
            String innerInfo=info;
            
            @Override
            public void checkOuterFields(){
                System.out.println("    外部类字段: "+info);
                //paramInfo="不想和外部类字段一样";   //can not! must be final or effectively final
            }
            @Override
            public void checkAnonymousInnerParam(){
                System.out.println("    传递给匿名内部类的参数 : "+paramInfo);
                //paramInfo="不想和外部类字段一样";   //can not! must be final or effectively final

            }
            @Override
            public void checkAnonymousInnerFields(){
                System.out.println("    匿名内部类的字段: "+innerInfo);
                //paramInfo="不想和外部类字段一样";   //can not! must be final or effectively final

            }
        };
    }
    
    //修改外部类字段
    public void changeInfo(String newInfo){
        info=newInfo;
        System.out.println("");
    }
    
    //外部类唯一字段
    private String info="外部类字段默认值";
    
    public static void main(String[] args){
        //实例化外部类
        Outer testOuter=new Outer();
        //实例化内部类
        AnonymousInner testInner=testOuter.getAnonymousInner(testOuter.info);
        
        //匿名类查看
        testInner.checkOuterFields();
        testInner.checkAnonymousInnerParam();
        testInner.checkAnonymousInnerFields();
        //changeInfo修改外部类字段
        testOuter.changeInfo("外部类字段被改动过了");
        //匿名类再查看
        testInner.checkOuterFields();
        testInner.checkAnonymousInnerParam();
        testInner.checkAnonymousInnerFields();
    }
}