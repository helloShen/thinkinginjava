/**
 *  People -> GrandFather -> Father -> Son
 *  People:         "名字"，基本字段。
 *                  "配偶"也是个People。
 *  GrandFather:    继承People的一切。
                    开始有家族的"姓"。
 *  Father:         继承爷爷的一切。
 *  Son:            继承父亲的一切。
 */
package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;


//only son is public
public class Son extends Father {
    
    //public methods
    public String toString(){return super.toString()+" I am the son.";}
    
    //friendly constructor
    Son(String inFamilyName, String inName){super(inFamilyName, inName);}
    
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String[] args){
        
        GrandFather myGrandFather=new GrandFather("SHEN","X.Y.");
        People myGrandMother=new People("R.H.");
        myGrandFather.marrage(myGrandMother);
        System.out.println("My grandfather is "+myGrandFather.toString());
        Father myFather=new Father("SHEN","Z.Q.");
        People myMother=new People("Z.P.");
        myFather.marrage(myMother);
        System.out.println("My father is "+myFather.toString());
        
        Son me=new Son("SHEN","W.");
        System.out.println("My name is "+me.toString());
        
    }
}

class Father extends GrandFather{
    
    //friendly constructor
    Father(String inFamilyName, String inName){super(inFamilyName, inName);}
    
}

class GrandFather extends People {

    //public method
    final public String toString(){return super.toString()+" (Family: "+this.familyName+")";}
    
    //friendly constructor
    GrandFather(String inFamilyName, String inName){
        super(inName);  //父类构造器super()，一定要放在第一行。
        this.familyName=inFamilyName;
        //System.out.println("    Family name inherit from GrandFather: "+this.familyName);
    }
    
    //friendly method
    String getFamilyName(){return this.familyName;}
    void setFamilyName(String inFamilyName){this.familyName=inFamilyName;}
    
    //private fields
    private String familyName;
}

class People {
    
    //public method
    public String toString(){   //Object基类的toString()方法是public。继承不能比父类更私有。
        String output;
        output=this.name;
        if(this.spouse!=null){
            output=output+" (Spouse: "+this.spouse.name+")";
        }
        return output;
    }
    
    //friendly constructor
    People(String inName){
        this.name=inName;
        //System.out.println("  Name inherit from People: "+this.name);
    }
    
    //friendly method
    //私有字段，只能通过这些接口方法访问。
    String getName(){return this.name;}
    void setName(String inName){this.name=inName;}
    void marrage(People aSpouse){this.spouse=aSpouse;}
    String spouseName(){return this.spouse.name;}
    
    //private fields：习惯上字段都设成私有
    private String name;
    private People spouse;
}