/**
 *  Tool to open each File
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class DirList {
    private File path;
    private String[] list;
    
    public DirList(String absPath){
        path=new File(absPath);
        list = path.list();
    }
    public String[] list(){return list;}
    public String[] list(String regex){
        list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public static void main(final String[] args) {
        DirList dl=new DirList("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter17/testframework/gen/");
        String[] fullList=dl.list();
        String[] filteredList=dl.list(".*Ran.*");
        
        System.out.println(">>>FULL LIST<<<\n"+Arrays.toString(fullList));
        System.out.println(">>>GEN LIST<<<\n"+Arrays.toString(filteredList));
    }
}