/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;

public class Plate36{
    private static int count=0;
    private final int id=++count;
    private final String name="Plate";
    public String toString(){return name+" #"+id+": "+chef+"->"+order;}
    private final Order36 order;
    private final Chef36 chef;
    private final Table36 table;
    public Plate36(Order36 o, Chef36 c, Table36 t){
        order=o;
        chef=c;
        table=t;
    }
    public Order36 getOrder(){return order;}
    public Chef36 getChef(){return chef;}
    public Table36 getTable(){return table;}
}