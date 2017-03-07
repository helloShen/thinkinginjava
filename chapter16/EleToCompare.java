/**
 * Exercise19
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class EleToCompare{
    private int item;
    public EleToCompare(int n){
        item=n;
    }
    public int getItem(){return item;}
    @Override
    public boolean equals(Object o){
        if(o instanceof EleToCompare){
            return this.item==((EleToCompare)o).item;
        }else{
            return false;
        }
        
    }
    @Override
    public int hashCode(){
        return item;
    }
}