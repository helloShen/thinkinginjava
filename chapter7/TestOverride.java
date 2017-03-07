/**
 *  证明子类可以重载父类方法。
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;


public class TestOverride extends TestOverload{

    //another overload
    public void overloadedMethod(char c){
        System.out.println("overloadedMethod(): char");
    }
    
    //now I want to override
    //use @Override to ensure the method to be overrided. Otherwise the system will throw errors.
    //@Override
    public void overloadedMethod(String s, int a){
        System.out.println("overloadedMethod(): String is overrided");
    }
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        TestOverride myOverride=new TestOverride();
        
        myOverride.overloadedMethod();
        myOverride.overloadedMethod(1);
        myOverride.overloadedMethod("Hello");
        myOverride.overloadedMethod((char)1);
    }
}



