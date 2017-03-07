/**
 *  just test
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

class MyException extends Exception {private static final long serialVersionUID=0;}

public class Test{
    public static String halfString(String s) throws NullPointerException{
        return s.substring(0,s.length()/2);
    }
    
    public static void callHalfString(String line){
        String result="";
        try{
            result=Test.halfString(line);
        }catch(NullPointerException e){
            System.out.println("The parameter string is null! Ignore it!");
        }finally{
            System.out.println(result);
        }
    }
    
    public static void callHalfString2(String line) throws NullPointerException{
        String result=Test.halfString(line);
        System.out.println(result);
    }
    
    
    public static void callHalfString3(){
        String[] strList=new String[5];
        strList[0]="zero";
        strList[1]=null;	//空记录，导致异常
        strList[2]="two";
        strList[3]="three";
        strList[4]="four";
        for(int i=0;i<5;i++){
            String result="";
            try{	//隔离执行可能抛出异常的函数或代码
                result=Test.halfString(strList[i]);
                System.out.println(result);
            }catch(NullPointerException e){		//处理异常：直接跳转到下一条
                System.out.println("Index="+i+" is null!");
            }
        }
    }
    
    public static void callHalfString4(String line) throws MyException{
        String result="";
        try{
            result=Test.halfString(line);
        }catch(NullPointerException e){
            MyException me=new MyException();
            me.initCause(e);	//对捕获的NullPointerException进行包装
            throw me;	//再次抛出
        }finally{
            System.out.println(result);
        }
    }
    
    public static void callHalfString5(String line) throws MyException{
        String result="";
        try{
            result=Test.halfString(line);
        }catch(Exception e){
            MyException me=new MyException();
            me.initCause(e);	//对捕获的NullPointerException进行包装
            throw me;	//再次抛出
        }catch(NullPointerException npe){
            MyException me=new MyException();
            me.initCause(npe);	//对捕获的NullPointerException进行包装
            throw me;	//再次抛出
        }finally{
            System.out.println(result);
        }
    }
    
    public static void main(String[] args){
        //Test.callHalfString("Hello World!");
        try{
            Test.callHalfString5(null);
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}