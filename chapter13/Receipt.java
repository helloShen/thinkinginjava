/**
 *  exercise 4 - chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;


class Receipt {
    /**
     *  PUBLIC METHODS
     */
    public void printTitle(){
        f.format("%1$-20.15s %2$3.3s %3$10.10s\n","Item","Qty","Price");
        f.format("%1$-20.15s %2$3.3s %3$10.10s\n","----","---","-----");
    }
    
    public void print(String name, int qty, double price){
        f.format("%1$-20.15s %2$3d %3$10.2f\n",name,qty,price);
        total+=price;
    }
    
    public void printTotal(){
        f.format("%1$-20.15s %2$3s %3$10.2f\n","Tax", "", total*0.15);
        f.format("%1$-20.15s %2$3s %3$10.10s\n","", "","-----");
        f.format("%1$-20.15s %2$3s %3$10.2f\n","Total", "",total*1.15);
    }
    
    
    /**
     *  PRIVATE FIELDS
     */
    private double total=0;
    private Formatter f=new Formatter(System.out);
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        Receipt r=new Receipt();
        r.printTitle();
        r.print("Jack’s Magic Beans", 4, 4.25);
        r.print("Princess Peas", 3, 5.1);
        r.print("Three Bears Porridge", 1, 14.29);
        r.printTotal();
    }
}
