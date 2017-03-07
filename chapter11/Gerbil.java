/**
 *  ArrayList test
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class Gerbil {

    /**
     *  PUBLIC STATIC FIELDS
     */
    public static int count=0;
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Gerbil getGerbil(){
        return new Gerbil();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void hop(){
        System.out.println(gerbilNumber);
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Gerbil(){
        gerbilNumber=count++;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private int gerbilNumber;
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        ArrayList<Gerbil> gerbilLegion=new ArrayList<Gerbil>();
        for(int i=0;i<10;i++){
            gerbilLegion.add(Gerbil.getGerbil());
        }
        
        for(int i=0;i<10;i++){
            gerbilLegion.get(i).hop();
        }
    }
}