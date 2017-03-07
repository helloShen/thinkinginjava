/**
 *  exercise 1 - chapter 13
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

public class Exercise1{
    private final String valve1="Monday";
    private final String valve2="Tusday";
    private final String valve3="Wendsday";
    private final String valve4="Thursday";
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    //use String
    //每进行一次“+”操作，就产生一个StringBuilder对象。
    public String toString() {
        long begin=System.nanoTime();
        String result=
        "valve1 = " + valve1 + " " +
        "valve2 = " + valve2 + " " +
        "valve3 = " + valve3 + " " +
        "valve4 = " + valve4 + "\n" +
        "i = " + i + " " + "f = " + f + " " +
        "source = " + source;
        long end=System.nanoTime();
        System.out.println((end-begin)/10e6);
        return result;

    }

    //use StringBuilder
    //只产生一个StringBuilder对象
    public String toStringBuilder() {
        long begin=System.nanoTime();
        StringBuilder result=new StringBuilder();
        result.append("valve1 = ").append(valve1).append(" ");
        result.append("valve2 = ").append(valve2).append(" ");
        result.append("valve3 = ").append(valve3).append(" ");
        result.append("valve4 = ").append(valve4).append("\n");
        result.append("i = ").append(i).append(" ").append("f = ").append(f).append(" ").append("source = ").append(source);
        long end=System.nanoTime();
        System.out.println((end-begin)/10e6);
        return result.toString();
    }
    public static void main(String[] args) {
        Exercise1 sprinklers = new Exercise1();
        System.out.println(sprinklers);
        System.out.println(sprinklers.toStringBuilder());
    }
}
