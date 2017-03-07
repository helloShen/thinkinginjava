/**
 *  Sphere
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Sphere{
    private static int count=0;
    private int id=++count;
    public String toString(){return "Sphere "+id;}
    public void setId(int inNum){id=inNum;}
    public int getId(){return id;}
}