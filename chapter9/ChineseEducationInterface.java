/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Chinese education has primary school, middle school, senior high school,and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

interface ChineseEducationInterface {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public void primarySchool(Student s);
    public void middleSchool(Student s);
    public void seniorHighSchool(Student s);
    public void university(Student s);
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}