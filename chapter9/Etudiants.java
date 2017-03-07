/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Canada etudiants have to study in elementary school, high school, preUniversity and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class Etudiants implements Etudiant {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Etudiants createEtudiants(String inName){
        return new Etudiants(inName);
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void elementarySchoolGraduate(){
        this.elementarySchoolGraduate=true;
    }
    public void highSchoolGraduate(){
        this.highSchoolGraduate=true;
    }
    public void preUniversityGraduate(){
        this.preUniversityGraduate=true;
    }
    public void universityGraduate(){
        this.universityGraduate=true;
    }
    
    public String getName(){
        return this.name;
    }
    public boolean getElementSchoolGraduate(){
        return this.elementarySchoolGraduate;
    }
    public boolean getHighSchoolGraduate(){
        return this.highSchoolGraduate;
    }
    public boolean getPreUniversityGraduate(){
        return this.preUniversityGraduate;
    }
    public boolean getUniversityGraduate(){
        return this.universityGraduate;
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Etudiants(String inName){
        this.name=inName;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    private boolean elementarySchoolGraduate=false;
    private boolean highSchoolGraduate=false;
    private boolean preUniversityGraduate=false;
    private boolean universityGraduate=false;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}