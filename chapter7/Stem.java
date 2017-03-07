/**
 *  Stem（树干）代表一棵树，继承自父类Root（根茎）
 *  Stem（树干）开始有自己的“name（名字）”
 *  父类Root（根茎）有三个组成部分：树皮，木质部，和木髓
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 *  这个类写完，编译一次过，拥吻自己，撒花
 */


package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;

//树干
//the only visible class
public class Stem extends Root{
    
    //default constructor
    Stem(){}
    //constructor with params
    Stem(String phloemColor,int xylemLayer,int pithDiameter,String treeName){
        super(phloemColor,xylemLayer,pithDiameter);
        this.name=treeName;
        System.out.println("It is called "+this.name+".");
    }
    
    //private fields
    private String name="Tree"; //default name

    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        //Exercise 9
        Stem newTree=new Stem();
        //Exercise 10
        Stem generalSherman=new Stem("red",2500,500,"General Sherman"); //雪曼将军树是目前世界上最大的树
    }
}

//根茎
//base class of Stem
class Root {
    
    //default constructor
    Root(){
        this.treePhloem=new Phloem();
        this.treeXylem=new Xylem();
        this.treePith=new Pith();
    }
    
    //constructor with params
    Root(String phloemColor,int xylemLayer,int pithDiameter){
        this.treePhloem=new Phloem(phloemColor);
        this.treeXylem=new Xylem(xylemLayer);
        this.treePith=new Pith(pithDiameter);
    }
    
    //private fields
    private Phloem treePhloem;
    private Xylem treeXylem;
    private Pith treePith;
}

//树皮(韧皮部)
//one of the three components of Root
class Phloem {
    //friendly default constructor
    Phloem(){System.out.println("The outer of a tree is the Phloem.");}
    //constructor with param
    Phloem(String color){System.out.println("This tree has "+color+" Phloem.");}
}

//木质部(木导管纤维)
//one of the three components of Root
class Xylem {
    //friendly default constructor
    Xylem(){System.out.println("The inner of a tree is the Xylem.");}
    //constructor with param
    Xylem(int numLayer){System.out.println("We can estimate the age of this tree by its Annual Growth Rings. This tree is "+numLayer+" years old.");}
}

//木髓(最里层)
//one of the three components of Root
class Pith {
    //friendly default constructor
    Pith(){System.out.println("The core of a tree is the Pith.");}
    //constructor with param
    Pith(int diameter){System.out.println("The diameter of its Pith is "+diameter+"CM.");}
}








