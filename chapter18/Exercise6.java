/**
 *  Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.text.*;

public class Exercise6{
    
    public static void filterByModifyDate(String[] args, String date){
        new ProcessFiles(new ProcessFiles.Strategy() {
            private long time=getNanoTime(date);
            public void process(File file) {
                if(file.lastModified()>time){
                    System.out.println(file+"   >>>Last Modified: "+getFormatDate(file.lastModified()));
                }
            }
        }, "java").start(args);
    }
    
    public static long getNanoTime(String date){
        try{
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = dateFormat1.parse(date);
            return myDate.getTime();
        }catch(ParseException pe){
            System.out.println("Error when parsing Date!");
        }
        return 0l;
    }
    
    public static String getFormatDate(long millitime){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(millitime).toString();
    }
    
    public static void main(String[] args){
        filterByModifyDate(args,"2016-09-29");
    }
}