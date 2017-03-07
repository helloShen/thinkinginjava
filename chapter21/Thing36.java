/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;

public class Thing36{
    public static int count=0;
    public int id=++count;
    public String name="NOTHING";
    public String toString(){return name+" # "+id;}
}