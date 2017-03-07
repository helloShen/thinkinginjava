/**
 *  工具类
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

@SuppressWarnings("serial")
public class TextFile extends ArrayList<String> {
    // 读文件，返回String
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    
    // 直接写String进文件
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    // 构造器。 切割成String的ArrayList。
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")){remove(0);}
    }
    
    // 构造器。按行切割。
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                for(String item : this){
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        String file = read("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.java");
        write("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.txt", file);
        TextFile text = new TextFile("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.txt");
        text.write("test2.txt");
        // Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(new TextFile("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/TextFile.java", "\\W+"));
        // Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}