/**
 *  Chapter 9 - Interface - Strategy Pattern
 *  USA has many illegal immigrants, president need to implement a policy.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import java.lang.Math;

class Usa {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    //no need to get the singleton object
    
    /**
     *  PUBLIC METHODS
     */
    //state pattern: select a new president, toggle a series of policy.
    //state pattern: method dealWithImmigrant() is independent with president. cause each president implement the party interface, which always have the same immigrant policy.
    public static void presidentElection(PartyMember newPresident){
        unitedStates.president=newPresident;
        System.out.println("Hello World! I am new President "+unitedStates.president.getName());
    }
    
    //handle the immigrant with our ideology
    public static void dealWithImmigrant(){
        //the president's preference affect the immigrant
        unitedStates.illegalImmigrant=unitedStates.president.immigrantPolicy(unitedStates.illegalImmigrant);
        System.out.println("Total Illegal Immigrants:   "+unitedStates.illegalImmigrant);
    }
    
    //when ideology involved in
    public static void dealWithImmigrant(Ideology currentIdeology){
        //globle race policy affect the immigrant
        unitedStates.illegalImmigrant=currentIdeology.offset(unitedStates.illegalImmigrant);
        System.out.println("Total Illegal Immigrants:   "+unitedStates.illegalImmigrant);
    }
    
    //
    public static void education(){
        unitedStates.educationScore=unitedStates.president.educationPolicy(unitedStates.educationScore);
        System.out.println("Education score:   "+unitedStates.educationScore);
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Usa(){
        //founding father: Washington
        PartyMember georgeWashington=new Federalist("George Washington");
        this.president=georgeWashington;
        this.illegalImmigrant=1000000;
        this.educationScore=80;
    }
    
    /**
     *  PRIVATE FIELDS
     */
    
    private int illegalImmigrant;
    private int educationScore;
    private PartyMember president;
    //singleton
    private static Usa unitedStates=new Usa();
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        //Clinton government
        Usa.presidentElection(new Democratic("Bill Clinton"));
        Usa.dealWithImmigrant();
        Usa.education();
        //Bush government
        Usa.presidentElection(new Republican("George Bush"));
        Usa.dealWithImmigrant();
        Usa.education();
        //Donald Trump ???
        Usa.presidentElection(new Racism("Donald Trump"));
        Usa.dealWithImmigrant();
        Usa.education();
        //Donald Trump with Ratial Segregation ???
        Usa.dealWithImmigrant(new RacialSegregation());
    }
    
}