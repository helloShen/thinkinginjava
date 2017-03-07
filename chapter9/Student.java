/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Chinese students have to study in primary school, middle school, senior high school,and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

interface Student {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public void primarySchoolGraduate();
    public void middleSchoolGraduate();
    public void seniorHighSchoolGraduate();
    public void universityGraduate();
    
    public String getName();
    public boolean getPrimarySchoolGraduate();
    public boolean getMiddleSchoolGraduate();
    public boolean getSeniorHighSchoolGraduate();
    public boolean getUniversityGraduate();
    
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