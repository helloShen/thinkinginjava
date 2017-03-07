/**
 *  just test
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;


class TestException extends Exception {private static final long serialVersionUID=0;}

class BaseClass{
    public BaseClass() throws TestException{throw new TestException();}
}

public class TestClass extends BaseClass{
    public void f() throws AutoLogException{throw new AutoLogException();}  //AutoLogException必须声明
    
    public void g() throws AutoLogException{f();}   //AutoLogException必须声明

    public TestClass() throws TestException{}
    
    public static void main(String[] args){
        try{
            TestClass tc=new TestClass();
            try{
                tc.g();
            }catch(AutoLogException e){
                e.printLogging();
            }
        }catch(){
            
        }
    }
}