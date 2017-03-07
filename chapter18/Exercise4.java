/**
 *  Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise4{
    public static void main(String[] args){
        Directory d=new Directory("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter17/testframework/",".*Gen.*");
        d.showStatistic();
        List<File> files=d.getFile();
        List<File> dirs=d.getDir();
        if(files!=null  && !(files.size()==0)){
            System.out.println(files);
        }
        if(dirs!=null  && !(dirs.size()==0)){
            System.out.println(dirs);
        }
    }
}