/**
 * Exercise 7
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;

public class Exercise7 {
    private List<String> list=new ArrayList<String>();
    public Exercise7(){}
    public Exercise7(List<String> l){list=l;}
    public void setList(List<String> l){list=l;}
    public void parse(String regex){
        Pattern p=Pattern.compile(regex);
        Matcher m;
        Formatter f=new Formatter(System.out);
        for(String str:list){
            m=p.matcher(str);
            f.format("%1$-15.15s %2$-8.8s\n", str, m.find());
        }
    }
    public static void main(String[] args){
        Exercise7 test=new Exercise7(Arrays.asList("hello world!","Hello world!","Hello World!","Hello world.","Hello World.","HELLO WORLD."));
        String regex="^[A-Z].*\\.";
        test.parse(regex);
    }
}
