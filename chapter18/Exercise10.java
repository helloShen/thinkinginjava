/**
 *  Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise10{
    public static void inversePrint(File file, String inWord){
        LinkedList<String> list=new LinkedList<String>();
        BufferedReader bf=null;
        try{
            bf=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=bf.readLine())!=null){
                String[] words=line.split("[\\W]+");
                if(words.length>0){
                    for(String word:words){
                        if(word.toLowerCase().equals(inWord)){
                            list.add(line);
                            break;
                        }
                    }
                }
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
        if(args.length!=2){
            System.out.println("Please check the args!");
        }else{
            Exercise10.inversePrint(new File(args[0]),args[1]);
        }
    }
}