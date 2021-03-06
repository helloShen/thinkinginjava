/**
 *  Exercise 18
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

@SuppressWarnings("serial")
public class Exercise18 extends ArrayList<String> {
    // 读文件，返回String
    public static String read(String fileName) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader in= new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
        String s;
        try{
            while((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        }finally{
            in.close();
        }
        return sb.toString();
    }
    
    // 直接写String进文件
    public static void write(String fileName, String text) throws IOException{
        PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
        try{
            out.print(text);
        }finally{
            out.close();
        }
    }
    
    // 构造器。 切割成String的ArrayList。
    public Exercise18(String fileName, String splitter) throws IOException{
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")){remove(0);}
    }
    
    // 构造器。按行切割。
    public Exercise18(String fileName) throws IOException{
        this(fileName, "\n");
    }
    
    public void write(String fileName) throws IOException{
        PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
        try{
            for(String item : this){
                out.println(item);
            }
        }finally{
            out.close();
        }
    }
    
    public static void main(String[] args) throws IOException{
        String file = read("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.java");
        write("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.txt", file);
        Exercise18 text = new Exercise18("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.txt");
        text.write("test2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}