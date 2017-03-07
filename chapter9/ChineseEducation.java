/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Chinese education has primary school, middle school, senior high school,and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class ChineseEducation implements ChineseEducationInterface {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static ChineseEducation createChineseEducation(){
        return new ChineseEducation();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void primarySchool(Student s){
        if(!s.getPrimarySchoolGraduate()){
            s.primarySchoolGraduate();
            System.out.println("Congratulation "+s.getName()+"! You are graduated from Chinese primary school!");
        } else {
            System.out.println("Sorry, you are not admissible to primary school!");
        }
    }
    public void middleSchool(Student s){
        if(s.getPrimarySchoolGraduate() && !s.getMiddleSchoolGraduate()){
            s.middleSchoolGraduate();
            System.out.println("Congratulation "+s.getName()+"! You are graduated from Chinese middle school!");
        } else {
            System.out.println("Sorry, you are not admissible to middle school!");
        }
    }
    public void seniorHighSchool(Student s){
        if(s.getMiddleSchoolGraduate() && !s.getSeniorHighSchoolGraduate()){
            s.seniorHighSchoolGraduate();
            System.out.println("Congratulation "+s.getName()+"! You are graduated from Chinese senior high school!");
        } else {
            System.out.println("Sorry, you are not admissible to senior high school!");
        }
    }
    public void university(Student s){
        if(s.getSeniorHighSchoolGraduate() && !s.getUniversityGraduate()){
            s.universityGraduate();
            System.out.println("Congratulation "+s.getName()+"! You are graduated from Chinese university!");
        } else {
            System.out.println("Sorry, you are not admissible to university!");
        }
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private ChineseEducation(){}
    
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