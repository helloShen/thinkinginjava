/**
 *  exercise 4 - chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

class TestFormat {
    /**
     *  use Formatter
     */
    public void formatterTitle(){
        f.format("%1$-20.15s %2$3.3s %3$10.10s\n","Item","Qty","Price");
        f.format("%1$-20.15s %2$3.3s %3$10.10s\n","----","---","-----");
    }
    
    public void formatterElement(String name, int qty, double price){
        f.format("%1$-20.15s %2$3d %3$10.2f\n",name,qty,price);
        total+=price;
    }
    
    public void formatterTotal(){
        f.format("%1$-20.15s %2$3s %3$10.2f\n","Tax", "", total*0.15);
        f.format("%1$-20.15s %2$3s %3$10.10s\n","", "","-----");
        f.format("%1$-20.15s %2$3s %3$10.2f\n","Total", "",total*1.15);
    }
    
    /**
     *  use System.out
     */
    public void systemTitle(){
        System.out.format("%1$-20.15s %2$3.3s %3$10.10s\n","Item","Qty","Price");
        System.out.format("%1$-20.15s %2$3.3s %3$10.10s\n","----","---","-----");
    }
    
    public void systemElement(String name, int qty, double price){
        System.out.format("%1$-20.15s %2$3d %3$10.2f\n",name,qty,price);
        total+=price;
    }
    
    public void systemTotal(){
        System.out.format("%1$-20.15s %2$3s %3$10.2f\n","Tax", "", total*0.15);
        System.out.format("%1$-20.15s %2$3s %3$10.10s\n","", "","-----");
        System.out.format("%1$-20.15s %2$3s %3$10.2f\n","Total", "",total*1.15);
    }
    
    /**
     *  use String
     */
    public void stringTitle(){
        System.out.print(String.format("%1$-20.15s %2$3.3s %3$10.10s\n","Item","Qty","Price"));
        System.out.print(String.format("%1$-20.15s %2$3.3s %3$10.10s\n","----","---","-----"));
    }
    
    public void stringElement(String name, int qty, double price){
        System.out.print(String.format("%1$-20.15s %2$3d %3$10.2f\n",name,qty,price));
        total+=price;
    }
    
    public void stringTotal(){
        System.out.print(String.format("%1$-20.15s %2$3s %3$10.2f\n","Tax", "", total*0.15));
        System.out.print(String.format("%1$-20.15s %2$3s %3$10.10s\n","", "","-----"));
        System.out.print(String.format("%1$-20.15s %2$3s %3$10.2f\n","Total", "",total*1.15));
    }
    
    public void testArray(){
        final int[] value={1,2,3};
        value[2]=100;
        System.out.println(value[2]);
        int[] another={4,5,6};
        value=another;
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
        TestFormat tf=new TestFormat();
        tf.formatterTitle();
        tf.formatterElement("Jack’s Magic Beans", 4, 4.25);
        tf.formatterElement("Princess Peas", 3, 5.1);
        tf.formatterElement("Three Bears Porridge", 1, 14.29);
        tf.formatterTotal();
        
        
        tf.systemTitle();
        tf.systemElement("Jack’s Magic Beans", 4, 4.25);
        tf.systemElement("Princess Peas", 3, 5.1);
        tf.systemElement("Three Bears Porridge", 1, 14.29);
        tf.systemTotal();
        
        tf.stringTitle();
        tf.stringElement("Jack’s Magic Beans", 4, 4.25);
        tf.stringElement("Princess Peas", 3, 5.1);
        tf.stringElement("Three Bears Porridge", 1, 14.29);
        tf.stringTotal();
        
        tf.testArray();
    }
}
