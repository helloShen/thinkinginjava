/**
 *  To test the different type of closure
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

interface AnnoInner{public int addXYZ(); /*public void changeY();*/}

public class Outer {
    
    {
        final int x=100;
        final int y=100;
        class BlockInner{
            int z=100;
            public int addXYZ(){return x+y+z;}
        }
        BlockInner bi=new BlockInner();
        num=bi.addXYZ();
    }
    
    private class Inner{
        private int x=100;
        public int innerAdd(){
            return x+num;
        }
    }
    
    //第一种：匿名内部类的闭包
    public AnnoInner getAnnoInner(final int x){
        final int y=100;
        return new AnnoInner(){
            int z=100;
            public int addXYZ(){return x+y+z;}
            //public void changeY(){y+=1;}
        };
    }

    public int num;
    /**
     *  MAIN
     */
    public static void main(String[] args){
        Outer o=new Outer();
        AnnoInner ai=o.getAnnoInner(o.num);
        System.out.println(ai.addXYZ());
    }
}