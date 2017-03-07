/**
 *  Exercise 23: Create an interface U with three methods. Create a class A with a method that produces a reference to a U by building an anonymous inner class. Create a second class B that contains an array of U. B should have one method that accepts and stores a reference to a U in the array, a second method that sets a reference in the array (specified by the method argument) to null, and a third method that moves through the array and calls the methods in U. In main( ), create a group of A objects and a single B. Fill the B with U references produced by the A objects. Use the B to call back into all the A objects. Remove some of the U references from the B.
 */

package com.ciaoshen.thinkinjava.chapter10;
import java.util.*;

//containor of created objects of type U
class B {
    
    public static B getB(){return new B();}
    //insert an U at the end of the uArray
    public void addU(U inputU){
        uArray.add(inputU);
    }
    //remove a U from uArray by their id
    public void removeU(int index){
        if(index<uArray.size() && uArray.get(index)!=null){
            uArray.remove(index);
        }
    }
    //pass through the U in uArray and call all three methods
    public void uIteration(){
        for(U u : uArray){
            u.uMethod1();
            u.uMethod2();
            u.uMethod3();
        }
    }
    //containor: List of U object
    private ArrayList<U> uArray=new ArrayList<U>();
    
    public static void main(String[] args){
        //list of A
        A[] aArray=new A[3];
        for(int i=0;i<aArray.length;i++){
            aArray[i]=A.getA();
        }
        
        //B is list of U
        B b=B.getB();
        int test=50;

        //A create U, insert into B
        for(int j=0;j<aArray.length;j++){
            for(int i=1;i<=j+1;i++){
                b.addU(aArray[j].getU(test));
            }
        }
        System.out.println(test);
        
        //show content in B
        b.uIteration();
        b.removeU(3);
        System.out.println("================================");
        b.uIteration();
    }

}