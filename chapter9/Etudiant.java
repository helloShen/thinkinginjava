/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Canada etudiants have to study in elementary school, high school, preUniversity and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

interface Etudiant {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    public void elementarySchoolGraduate();
    public void highSchoolGraduate();
    public void preUniversityGraduate();
    public void universityGraduate();
    
    public String getName();
    public boolean getElementarySchoolGraduate();
    public boolean getHighSchoolGraduate();
    public boolean getPreUniversityGraduate();
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