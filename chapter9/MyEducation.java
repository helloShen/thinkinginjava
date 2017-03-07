



/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Main runtime class
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class MyEducation {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    
    /**
     *  PUBLIC METHODS
     */
    
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
        InternationalStudents me = InternationalStudents.createInternationalStudents("SHEN");
        ChineseEducation chEdu = ChineseEducation.createChineseEducation();
        CanadaEducation caEdu = CanadaEducation.createCanadaEducation();
        chEdu.primarySchool(me);
        chEdu.middleSchool(me);
        //chEdu.seniorHighSchool(me);
        caEdu.highSchool(me);
        caEdu.preUniversity(me);
        caEdu.university(me);
    }
    
}