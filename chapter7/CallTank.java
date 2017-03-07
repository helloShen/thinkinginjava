/**
 *  Call the Tank class in Chapter 5
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;
import com.ciaoshen.thinkinjava.chapter5.*;


public class CallTank extends InPackageTank{
    
    //inherit constructor
    public CallTank(String name){super(name);}
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String args[]){
        //没继承之前
        //InPackageTank myTank = new InPackageTank("Tank1");
        //继承以后可以调用Protected方法
        CallTank myTank=new CallTank("Panzerkampfwagen VI Tiger");    //二战德军最强坦克
        System.out.println(myTank.getName()+" has "+myTank.howManyBullet()+" bullets left.");
        myTank.shot();
        myTank.shot();
        System.out.println(myTank.getName()+" has "+myTank.howManyBullet()+" bullets left.");
        
        
        
    }
}