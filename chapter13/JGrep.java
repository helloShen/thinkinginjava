/**
 *  Exercise 15-16 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.regex.*;
import java.util.*;
import com.ciaoshen.thinkinjava.myUtil.*;

//simulate the jgrep in unix
public class JGrep {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p;
        String pt=args[0];
        int flag=-1;
        if(args.length==3){
            switch(args[2]){
                    case "-i": flag=Pattern.CASE_INSENSITIVE; break;
                    case "-m": flag=Pattern.MULTILINE; break;
                    case "-x": flag=Pattern.COMMENTS; break;
                    case "-s": flag=Pattern.DOTALL; break;
            }
            p=Pattern.compile(pt,flag);
        }else{
            p=Pattern.compile(pt);
        }
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(MyBufferedReader.readFile(args[1]));

        while(m.find()){
                System.out.println(index++ + ": " +
                                   m.group() + ": " + m.start());
        }
    }
}