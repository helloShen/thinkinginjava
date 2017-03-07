/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  International students inherit both the student and etudiant interface
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class InternationalStudents implements Student, Etudiant {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static InternationalStudents createInternationalStudents(String name){
        return new InternationalStudents(name);
    }
    
    /**
     *  PUBLIC METHODS
     *  From Student interface
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
    
    public void elementarySchoolGraduate(){
        this.elementarySchoolGraduate=true;
    }
    public void highSchoolGraduate(){
        this.highSchoolGraduate=true;
    }
    public void preUniversityGraduate(){
        this.preUniversityGraduate=true;
    }
    
    public String getName(){
        return this.name;
    }
    
    
    /**
     *  加拿大初等教育=中国小学+初中
     */
    @Override
    public boolean getPrimarySchoolGraduate(){
        if(this.primarySchoolGraduate || this.elementarySchoolGraduate){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean getElementarySchoolGraduate(){
        if(this.elementarySchoolGraduate || (this.primarySchoolGraduate && this.middleSchoolGraduate)){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean getMiddleSchoolGraduate(){
        if(this.middleSchoolGraduate || this.elementarySchoolGraduate){
           return true;
        } else {
            return false;
        }
    }
    
    /**
     *  加拿大中学+大学预科=中国高中
     */
    @Override
    public boolean getSeniorHighSchoolGraduate(){
        if(this.seniorHighSchoolGraduate || (this.highSchoolGraduate && this.preUniversityGraduate)){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean getHighSchoolGraduate(){
        if(this.highSchoolGraduate || this.seniorHighSchoolGraduate){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean getPreUniversityGraduate(){
        if(this.preUniversityGraduate || this.seniorHighSchoolGraduate){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     *  加拿大大学=中国大学
     */
    @Override
    public boolean getUniversityGraduate(){
        return this.universityGraduate;
    }

    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private InternationalStudents(String inName){
        this.name=inName;
    }
    /**
     *  PRIVATE FIELDS
     *  From Student interface
     */
    private String name;
    private boolean primarySchoolGraduate=false;
    private boolean middleSchoolGraduate=false;
    private boolean seniorHighSchoolGraduate=false;
    private boolean universityGraduate=false;
    
    /**
     *  PRIVATE FIELDS
     *  From Etudiant interface
     */
    private boolean elementarySchoolGraduate=false;
    private boolean highSchoolGraduate=false;
    private boolean preUniversityGraduate=false;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}