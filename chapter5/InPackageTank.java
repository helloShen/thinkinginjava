/**
 *  测试包可见类的公开方法，在包外的可见度
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter5;

import java.util.*;


/**
 *  my class
 */
public class InPackageTank {
    
    //default constructor
    public InPackageTank(String name){
        this.name=name;
    }

    
    //shot one bullet
    protected void shot(){
        if (this.bullet>0){
            this.bullet --;
        } else {
            System.out.println("Out of bullet! Please recharge!");
        }
    }
    
    //recharge the bullet
    protected void charge(int inNum){
        this.bullet+=inNum;
        System.out.println("Charge successfully!");
    }
    
    //reture the number of reste bullet
    protected int howManyBullet(){return this.bullet;}
    
    //reture the name of the tank
    protected String getName(){return this.name;}
    
    //private field
    private int bullet = 100;
    private String name = new String();

}