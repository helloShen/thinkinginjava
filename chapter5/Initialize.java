/**
 *  Class for the exercises in Chapter 5
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;


/**
 *  Our class
 */
public class Initialize {
    //fields
    //exercise 1,2
    public String nonInitialized = new String();
    public String initialized  = "I am auto-initialized!";
    public String constructorInitialized = new String();
    
    //exercise 14
    protected static int autoIni;
    protected static String staticBlockIni;
    static {
        staticBlockIni="I was born!";
    }
    protected static void howAreYou(){
        System.out.println("Hey autoIni!  "+"autoIni="+autoIni);
        System.out.println("Hello staticBlockIni!  staticBlockIni:"+staticBlockIni);
    }
    
    //exercise 15
    protected String exercise15;
    {
        exercise15="ini block gives me life";
        System.out.println(exercise15);
    }
    
    //exercise 16
    protected static String[] fiveStrArray = {"1","2","3","4","5"};

    
    //primitive type field
    public int i;

    //default constructor
    public Initialize (){
        this.constructorInitialized = "constructor gives me life";
        System.out.println(this.constructorInitialized);
    }
    
    //constructor with param String
    public Initialize (String name){
        this.constructorInitialized = "Hello "+name+"!";
        System.out.println(this.constructorInitialized);
    }
    
    //java函数传递参数的时候不是一定需要完全符合的类型。对基本型参数，我们传入的参数基本型在我们定义的另一个基本型里放得下，java会做基本型的“自动提升”。比如只有这一个构造函数setI(int inputInt)，如果我构造时传入的是short，系统会自动找到setI(int inputInt)。但如果我构造是传入long型，因为int里放不下long，我必须显式地把long先“窄化转型”成int，再调用构造函数setI(int inputInt)，不然系统会抛出异常。
    public void setI (int inputInt){
        this.i=inputInt;
    }

    /**
     *  Our main method
     *  @param args void
     */
    public static void main(String args[]){
        //Initialize myObject = new Initialize();

        //exercise 1,2
        //System.out.println(myObject.nonInitialized);
        //System.out.println(myObject.initialized);
        //System.out.println(myObject.constructorInitialized);
        
        //构造函数基本型参数的“自动提升”和”窄化转型“
        //int i = 10;
        //short s = 10;
        //long l = 10L;
        //myObject.setI(i);   //构造函数就是int，int当然没问题。
        //myObject.setI(s);   //传short，java会自动调用带int参数的构造函数，因为int放得下short。
        //myObject.setI((int)l);  //传long就不行了。必须显式地窄化转型成int。
        //System.out.println(myObject.i);
        
        
        //exercise 3
        //Initialize defaulObject = new Initialize();
        //Initialize shenObject = new Initialize("shen");
        
        //exercise 14
        //Initialize.howAreYou();
        
        //exercise 15
        //Initialize exercise15=new Initialize();
        
        //exercise 16
        for(String ele : Initialize.fiveStrArray){
            System.out.println(ele);
        }
        Initialize.fiveStrArray = {"one","two","three","four","five"};
        Initialize.fiveStrArray = new String[] {"one","two","three","four","five"};
        for(String ele : Initialize.fiveStrArray){
            System.out.println(ele);
        }
    }
}