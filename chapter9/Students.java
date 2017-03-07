/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Chinese students have to study in primary school, middle school, senior high school,and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class Students implements Student {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Students createStudents(String name){
        return new Students(name);
    }
    /**
     *  PUBLIC METHODS
     */
    public void primarySchoolGraduate(){
        this.primarySchoolGraduate=true;
    }
    public void middleSchoolGraduate(){
        this.middleSchoolGraduate=true;
    }
    public void seniorHighSchoolGraduate(){
        this.seniorHighSchoolGraduate=true;
    }
    public void universityGraduate(){
        this.universityGraduate=true;
    }
    
    public String getName(){
        return this.name;
    }
    public boolean getPrimarySchoolGraduate(){
        return this.primarySchoolGraduate;
    }
    public boolean getMiddleSchoolGraduate(){
        return this.middleSchoolGraduate;
    }
    public boolean getSeniorHighSchoolGraduate(){
        return this.seniorHighSchoolGraduate;
    }
    public boolean getUniversityGraduate(){
        return this.universityGraduate;
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Students(String inName){
        this.name=inName;
    }
    /**
     *  PRIVATE FIELDS
     */
    private String name;
    private boolean primarySchoolGraduate=false;
    private boolean middleSchoolGraduate=false;
    private boolean seniorHighSchoolGraduate=false;
    private boolean universityGraduate=false;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){

    }
    
}