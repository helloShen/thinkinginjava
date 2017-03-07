/**
 *  Exercise 9 - Polymophism
 *  Granary implements the HaveFood interface
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter8;
import java.util.*;

class Granary implements HaveFood{
    
    /**
     *  PUBLIC METHODS
     */
    public String[] haveFood(){
        return this.foodList;
    }
    
    public String randomFood(){
        Random foodRander=new Random();
        int foodId=foodRander.nextInt(9);
        String food="";
        switch(foodId){
            case 0:
                food="corn"; break;
            case 1:
                food="wheat"; break;
            case 2:
                food="rice"; break;
            case 3:
                food="flour"; break;
            case 4:
                food="milk"; break;
            case 5:
                food="nut"; break;
            case 6:
                food="egg"; break;
            case 7:
                food="suger"; break;
            case 8:
                food="oil"; break;
        }
        return food;
    }
    
    public String checkFood(){
        String content="";
        for(int i=0;i<this.foodList.length;i++){
            content=content+"["+this.foodList[i]+"]";
            if(i!=this.foodList.length-1){
                content+=", ";
            }
        }
        return content;
    }
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    //randomly charge the food
    public void storeFood(){
        for(int i=0;i<this.foodList.length;i++){
            this.foodList[i]=randomFood();
        }
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    Granary(int size){
        this.foodList=new String[size];
    }
    
    /**
     *  PACKAGE ACCESS FIELDS
     */
    String[] foodList=null;
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        Granary testGranary=new Granary(10);
        testGranary.storeFood();
        System.out.println(testGranary.checkFood());
    }
    
}