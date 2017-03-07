/**
 *  Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise12{
    
    public static void copyFile(File inFile, File outFile){
        BufferedReader in=null;
        PrintWriter out=null;
        try{
            //input
            in=new BufferedReader(new FileReader(inFile));
            //output
            if(!outFile.exists()){
                outFile.createNewFile();
            }
            out=new PrintWriter(new BufferedWriter(new FileWriter(outFile)));

            int count=0;
            String line;
            while((line=in.readLine())!=null){
                out.println("Line "+ ++count +":\t"+line);
            }
        }catch(IOException ioe){
            System.out.println("Check your inFile and outFile!");
        }finally{
            try{
                in.close();
                out.close();
            }catch(IOException e){
                System.out.println("Files cannot be closed correctly!");
            }
        }
    }
    
    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("Check your arguments!");
        }else{
            copyFile(new File(args[0]), new File(args[1]));
        }
    }
}