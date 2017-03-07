/**
 *  exercise 25 - chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
import java.io.*;

class LevOneException extends Exception{private static final long serialVersionUID=0;}
class LevTwoException extends LevOneException{private static final long serialVersionUID=0;}
class LevThreeException extends LevTwoException{private static final long serialVersionUID=0;}

class OneLevel{
    public void A() throws LevOneException{throw new LevOneException();}
}

class TwoLevel extends OneLevel{
    @Override
    public void A() throws LevOneException{throw new LevTwoException();}
}

public class ThreeLevel extends TwoLevel{
    @Override
    public void A() throws LevOneException{throw new LevThreeException();}
    
    public static void main(String[] args){
        OneLevel ol=new ThreeLevel();
        try{
            ol.A();
        }catch(LevOneException loe){
            System.out.println(loe);
        }
    }
}