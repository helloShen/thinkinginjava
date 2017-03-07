/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Canada education has elementary school, high school, preUniversity and university
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class CanadaEducation implements CanadaEducationInterface {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static CanadaEducation createCanadaEducation(){
        return new CanadaEducation();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void elementarySchool(Etudiant e){
        if(!e.getElementarySchoolGraduate()){
            e.elementarySchoolGraduate();
            System.out.println("Congratulation "+e.getName()+"! You are graduated from Canada's elementary school!");
        } else {
            System.out.println("Sorry, you are not admissible to elementary school!");
        }
    }
    public void highSchool(Etudiant e){
        if(e.getElementarySchoolGraduate() && !e.getHighSchoolGraduate()){
            e.highSchoolGraduate();
            System.out.println("Congratulation "+e.getName()+"! You are graduated from Canada's high school!");
        } else {
            System.out.println("Sorry, you are not admissible to high school!");
        }
    }
    public void preUniversity(Etudiant e){
        if(e.getHighSchoolGraduate() && !e.getPreUniversityGraduate()){
            e.preUniversityGraduate();
            System.out.println("Congratulation "+e.getName()+"! You are graduated from Canada's pre-university!");
        } else {
            System.out.println("Sorry, you are not admissible to pre-university!");
        }
    }
    public void university(Etudiant e){
        if(e.getPreUniversityGraduate() && !e.getUniversityGraduate()){
            e.universityGraduate();
            System.out.println("Congratulation "+e.getName()+"! You are graduated from Canada's university!");
        } else {
            System.out.println("Sorry, you are not admissible to university!");
        }
    }
    
    /**
     *  PIVATE ACCESS CONSTRUCTOR
     */
    private CanadaEducation(){}
    
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