/**
 * Exercise 16
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Exercise16 {
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

     private static List<File> extracDir(String path){
         File f = new File(path);
         if(!f.exists()){System.out.println(path + " doesn't exist!");}
         if(f.isFile()){return Arrays.asList(f);}
         if(f.isDirectory()){
             List<File> list = new ArrayList<File>();
             File[] files = f.listFiles();
             for(File file : files){
                list.addAll(extracDir(file.getAbsolutePath()));
             }
             return list;
         }
         return new ArrayList<File>();
     }

     public static void grep(String regex, String path, int flag){
         int index=0;
         List<File> list = extracDir(path);
         for(File file : list){
             System.out.println("\n" + ">>> " + file.getAbsolutePath());
             String content = readFile(file.getAbsolutePath());
             if(content == null){System.out.println("Check your file path: " + path);return;}
             Pattern p = Pattern.compile(regex, flag);
             Matcher m = p.matcher("");
             Formatter f = new Formatter(System.out);
             f.format("%1$5.5s  %2$-15.15s %3$5.5s \n", "INDEX", "WORD", "POS");
             for(String line : content.split(SPLITER)){
                 m.reset(line);
                 while(m.find()){
                     f.format("%1$5d: %2$-15.15s %3$5d \n",++index, m.group(2), m.start());
                 }
             }
         }
     }

     private static void unitTestExtracDir(){
         String wrongPath = "/Users/Wei/java/helloKitty.java";
         String filePath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise16.java";
         String dirPath= "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13";
         System.out.println(extracDir(dirPath));
         System.out.println("=================================");
         System.out.println(extracDir(filePath));
         System.out.println("=================================");
         System.out.println(extracDir(wrongPath));
     }
     private static void unitTestReadFile(){  //test readFile()
         String rightPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise15.java";
         String wrongPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise.java";
         System.out.println(readFile(rightPath));
         System.out.println(readFile(wrongPath));
     }
     private static void unitTestGrep(String regex){    //test grep()
         String dirPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13";
         String filePath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise15.java";
         String wrongPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise.java";
         int flag = Pattern.CASE_INSENSITIVE;
         grep(regex, dirPath, flag);
         System.out.println("=================================");
         grep(regex, filePath, flag);
         System.out.println("=================================");
         grep(regex, wrongPath, flag);
     }
     public static void main(String[] args){
         //单元测试
         //Exercise16.unitTestReadFile();
         //Exercise16.unitTestExtracDir();
         //Exercise16.unitTestGrep("s\\w*");
         Exercise16.unitTestGrep("(?)(^|\\W)(s\\w*)(\\W|$)");
     }
}
