/**
 *  Node called by ArrayIni
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;

/**
 *  our class
 */
public class ArrayNode {
    
    //nothing in fields
    
    //constructor only print the parameter
    public ArrayNode(String inParam){
        System.out.println("I am "+inParam+"!");
    }
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String args[]){
        ArrayNode[] nodeArray = new ArrayNode[10];  //only 10 reference created in JVM Stack: {null,null,null,null,null,null,null,null,null,null}
        nodeArray[0]=new ArrayNode("toto");     //output->toto
        nodeArray[1]=new ArrayNode("titi");     //output->titi
        nodeArray[2]=new ArrayNode("tata");     //output->tata
    }
}