/**
 *  exercise 4 - chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;


class StringFormat {
    /**
     *  PUBLIC METHODS
     */
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%1$-10.10s",i));
        sb.append(String.format("%1$-10.10s",l));
        sb.append(String.format("%1$-10.10s",f));
        sb.append(String.format("%1$-10.10s",d));
        return sb.toString();
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private int i=100;
    private long l=1000L;
    private float f=99.99F;
    private double d=999.999D;
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        StringFormat sf=new StringFormat();
        System.out.println(sf.toString());
    }
}
