/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  a file have info and type fields
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class Files implements File {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Files createFiles(String inInfo, String inType){
        return new Files(inInfo, inType);
    }
    
    /**
     *  PUBLIC METHODS
     */
    public String getInfo(){
        return this.info;
    }
    public String getType(){
        return this.type;
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Files(String inInfo, String inType){
        this.info=inInfo;
        this.type=inType;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private String info;
    private String type;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){

    }
    
}