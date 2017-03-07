/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Canada education has elementary school, high school, preUniversity and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

interface CanadaEducationInterface {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */

    /**
     *  PUBLIC METHODS
     */
    public void elementarySchool(Etudiant e);
    public void highSchool(Etudiant e);
    public void preUniversity(Etudiant e);
    public void university(Etudiant e);
    
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