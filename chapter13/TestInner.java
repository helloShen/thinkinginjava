/**
 *  test closure
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

interface AnnoInner {public void printAnnoInnerPara();public void changePara();public void printOuterStr();}

public class TestInner{
    
    //normal inner class
    public class Inner {
        public Inner(){
            innerPara=TestInner.this.str;
        }
        private String innerPara;
        public void printInnerPara(){System.out.println("Inner: "+innerPara);}
        public void changeInnerPara(){str="dddd";}
    }
    
    //inner class in method
    public void innerClassMethod(String inStr){
        class MethodInnerClass{
            private String methodInnerPara=inStr;
            public void printMethodInnerPara(){System.out.println("MethodInner: "+methodInnerPara);}
        }
        MethodInnerClass mic=new MethodInnerClass();
        mic.printMethodInnerPara();
    }
    
    //annonymous inner class
    public AnnoInner getAnnoInner(String inStr){
        //inStr="changed";
        return new AnnoInner(){
            private String annoInnerPara=inStr;
            public void printAnnoInnerPara(){System.out.println("AnnoInner: "+annoInnerPara);}
            public void changePara(){str="cccc";}
            public void printOuterStr(){System.out.println("Print outer.str from AnnoInner: "+str);};
        };
    }
    
    public void changeStr(String inStr){
        str=inStr;
    }
    
    public String getStr(){
        return str;
    }
    //member fields
    public String str="aaaa";
    
    /**
     *  main
     */
    public static void main(String[] args){
        System.out.println(">>> Origianl outer class!");
        //creat outer
        TestInner ti=new TestInner();
        ti.innerClassMethod(ti.getStr());
        
        //creat annonymous inner
        AnnoInner ai=ti.getAnnoInner(ti.str);
        ai.printAnnoInnerPara();
        ai.changePara();
        ai.printAnnoInnerPara();
        
        //creat inner
        Inner i=ti.new Inner();
        i.printInnerPara();
        i.changeInnerPara();
        System.out.println(ti.getStr());
        
        //change outer str field
        ti.changeStr("bbbb");
        System.out.println(">>> Outer class has been changed!");
        
        //still use inner and annonymous inner and method inner
        ai.printAnnoInnerPara();
        i.printInnerPara();
        try{
            ti.innerClassMethod(ti.getStr());
        }catch(NullPointerException e){
            System.out.println("The outer class has been deleted!");
        }
        
        //kill outer
        ti=null;
        System.gc();
        System.out.println(">>> Outer class has been killed!");
        
        //still use inner and annonymous inner and method inner
        ai.printAnnoInnerPara();
        ai.printOuterStr();
        i.printInnerPara();
        try{
            ti.innerClassMethod(ti.getStr());
        }catch(NullPointerException e){
            System.out.println("I don't find outer class!");
        }
        
    }
    
}