/**
 *  exercise 22-24 - chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

class TestException extends Exception {
    private static final long serialVersionUID=0;
    public TestException(){
        System.out.println("Test Exception!");
    }
}

class DisposableClass{
    
    public DisposableClass(int inNum) throws TestException{
        if(inNum==1){
            throw new TestException();
        }else{
            num=inNum;
        }
        
    }
    public int getNum(){return num;}
    
    public void dispose(){System.out.println("Dispose!");}
    
    private int num;
}

public class FailingConstructor {
    
    /**
     *  METHODS
     */
    public void dispose(){
        objectPair=null;
        System.gc();
        System.out.println("objectPair has been distoried!");
    }
    
    public void printObjectPair(){
        for(int i=0;i<objectPair.length;i++){
            System.out.println(objectPair[i].getNum());
        }
    }
    
    /**
     *  CONSTRUCTOR
     */
    //逻辑代码被异常处理弄得支离破碎
    public FailingConstructor(int max) {
        for(int i=0;i<max;i++){
            try{
                objectPair[i]=new DisposableClass(i);
            }catch(TestException te){
                System.out.println("Parameter can not be 1!");
                try{
                    objectPair[i]=new DisposableClass(i+1);
                }catch(TestException te2){
                    System.out.println("This can not happen.");
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Number "+i+">="+objectPair.length+". Too big!");
            }
        }
    }

    /**
     *  FIELDS
     */
    private DisposableClass[] objectPair=new DisposableClass[2];
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        FailingConstructor fc=new FailingConstructor(3);
        fc.printObjectPair();
        fc.dispose();
        fc.printObjectPair();
    }
}