/**
 * Exercise 15
 */
 package com.ciaoshen.thinkinjava.chapter13;
 import java.util.*;
 import java.util.regex.*;
 import java.io.*;

 public class Exercise15 {
     private static final String SPLITER = "\n";
     private static String readFile(String path){    //return the file content as a string, otherwise return null
         StringBuilder sb = new StringBuilder();
         File f = new File(path);
         try{
             BufferedReader br = new BufferedReader(new FileReader(new File(path)));
             try{
                 String line = null;
                 while(true){
                     line = br.readLine();
                     if(line == null){break;}
                     sb.append(line+SPLITER);
                 }
                 return sb.toString();
             }finally{
                 br.close();
             }
         }catch(IOException ioe){
             System.out.println("IOException when openning file " + path);
             return null;
         }
     }

     public static void grep(String regex, String path, int flag){
         String content = readFile(path);
         if(content == null){System.out.println("Check your file path: " + path);return;}
         Pattern p = Pattern.compile(regex, flag);
         Matcher m = p.matcher("");
         Formatter f = new Formatter(System.out);
         int index=0;
         f.format("%1$5.5s  %2$-15.15s %3$5.5s \n", "INDEX", "WORD", "POS");
         for(String line : content.split(SPLITER)){
             m.reset(line);
             while(m.find()){
                 f.format("%1$5d: %2$-15.15s %3$5d \n",++index, m.group(), m.start());
             }
         }
     }

     private static void unitTestReadFile(){  //test readFile()
         String rightPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise15.java";
         String wrongPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise.java";
         System.out.println(readFile(rightPath));
         System.out.println(readFile(wrongPath));
     }
     private static void unitTestGrep(String regex){    //test grep()
         String rightPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise15.java";
         String wrongPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise.java";
         int flag = Pattern.CASE_INSENSITIVE;
         grep(regex, rightPath, flag);
         grep(regex, wrongPath, flag);
     }
     public static void main(String[] args){
         //单元测试
         //Exercise15.unitTestReadFile();
         //Exercise15.unitTestGrep("s\\w*");
         Exercise15.unitTestGrep("(?)(^|\\W)(s\\w*)(\\W|$)");
     }
 }
