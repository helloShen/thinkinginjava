/**
 *  Tool to open each File
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise1 {
    public static void main(final String[] args) {
        File path = new File("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter17/testframework/gen/");
        String[] list;
        final String p;
        if(args.length == 0){
            p=".*gen.*";
        }else{
            p=args[0];
        }
        
        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(p);
            public boolean accept(File dir, String name) {
                boolean result=false;
                try{
                    BufferedReader br=new BufferedReader(new FileReader(new File(dir.getAbsolutePath()+"/"+name)));
                    while(true){
                        String line=br.readLine();
                        if(line==null){break;}
                        if(pattern.matcher(line).matches()){
                            result=true;
                        }
                    }
                }catch(Exception e){
                    System.out.println("Can not open file:  "+dir.getAbsolutePath()+name);
                }
                return result;
            }
        });
        
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem+":   contains "+p);
    }
}