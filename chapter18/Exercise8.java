/**
 *  Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise8{
    public static void inversePrint(File file){
        LinkedList<String> list=new LinkedList<String>();
        BufferedReader bf=null;
        try{
            bf=new BufferedReader(new FileReader(file));
            while(true){
                String line=bf.readLine();
                if(line==null){break;}
                list.add(line);
            }
        }catch(FileNotFoundException e){
            System.out.println(file.getName()+" not found!");
        }catch(IOException ioe){
            System.out.println("have problem when reading lines... ...");
        }finally{
            if(bf!=null){
                try{
                    bf.close();
                }catch(IOException ioe){
                    System.out.println("File can not be close!");
                }
            }
        }
        int size=list.size();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(--size));
        }
    }
    
    public static void main(String[] args){
        if(args.length==0){
            Exercise8.inversePrint(new File("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Directory.java"));
        }else{
            for(String arg:args){
                Exercise8.inversePrint(new File(arg));
            }
        }
    }
}