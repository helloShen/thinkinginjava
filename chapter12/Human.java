/**
 *  Exercise 30 -chapter 12
 *  RuntimeException don't need try{}catch{}block
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;


class Annoyance extends Exception {private static final long serialVersionUID=0;}
class Sneeze extends Annoyance {private static final long serialVersionUID=0;}

public class Human {
    
    public static void wrapRuntimeException(int type){
        try{
            switch(type){
                case 1:
                    throw new Annoyance();
                case 2:
                    throw new Sneeze();
                default:
                    throw new RuntimeException();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            try{
                Human.wrapRuntimeException(i);
            }catch(RuntimeException e){
                System.out.println(e.getCause());
            }
        }
        
    }
}