/**
 *  This class is used to test different way of initializing fields in a class.
 *
 *  We attempt to assign values in three different ways:
 *      1. constructor
 *      2. block
 *      3. inicialize method
 *
 *  @author Wei SHEN
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter3;

import java.util.*;

/**
 *  Our class used to implement this test.
 */
public class TestInicializeField {

    //Three queues: invisible to users
    private LinkedList<String> blockVisitor = new LinkedList<String>();
    private static LinkedList<String> staticBlockVisitor = new LinkedList<String>();
    private LinkedList<String> methodVisitor = createVisitor();

    //static initialize block
    static{
        staticBlockVisitor.add("静态代码块,到此一游！");
    }
    
    //free initialize block
    {
        staticBlockVisitor.add("自由代码块,到此一游！");
        this.blockVisitor.add("自由代码块,到此一游！");
    }
    
    //constructor of the class
    public TestInicializeField(){
        //constuctorHashMap is inicialized by constructor.
        staticBlockVisitor.add("构造函数,到此一游！");
        this.blockVisitor.add("构造函数,到此一游！");
    }

    //initialize method
    private LinkedList<String> createVisitor(){
        LinkedList<String> newQueue = new LinkedList<String>();
        newQueue.add("初始化函数,到此一游！");
        return newQueue;
    }
    
   
    /**
     *  Responsable for printing the content in no metter which HashMap.
     *  invisible to users
     *  @param aHashMap Just give me a HashMap please.
     */
    private void printQueue(LinkedList<String> aQueue){
        while (aQueue.peekFirst()!=null){
            System.out.println("  "+aQueue.pollFirst());
        }
    }
    
    /**
     *  Print two HashMap fields in this class one by one.
     *  The only interface in this class for user.
     *  @param Need no parameter.
     */
    public void printThreeVisitor(){
        System.out.println("普通字段： ");
        this.printQueue(this.blockVisitor);
        System.out.println("静态字段： ");
        this.printQueue(staticBlockVisitor);
        System.out.println("调用函数字段：");
        this.printQueue(this.methodVisitor);
    }
    
    /**
     *  Main method. Just create a new object of this class, and see what happend.
     *  @param args Need no parameter.
     */
    public static void main (String args[]){
        TestInicializeField myTest = new TestInicializeField();
        myTest.printThreeVisitor();
    }
    
    
}