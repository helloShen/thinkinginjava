/**
 *  Exercise 3
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise3 {
    
    public static class SortedDirList{
        private File path;
        private String[] list;
        
        public SortedDirList(String absPath){
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
        public File getPath(){return path;}
    }
    
    public static int countLine(File dir, String[] list){
        if(list.length==0){return 0;}
        int result=0;
        for(String name:list){
            try{
                BufferedReader br=new BufferedReader(new FileReader(new File(dir+"/"+name)));
                while(br.readLine()!=null){result++;}
            }catch(Exception e){
                System.out.println("Can not open the file:  "+dir+"/"+name);
            }
        }
        return result;
    }

    public static void main(final String[] args) {
        Exercise3.SortedDirList dl=new Exercise3.SortedDirList("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter17/testframework/gen/");
        String[] fullList=dl.list();
        String[] filteredList=dl.list(".*Ran.*");
        
        System.out.println(">>>FULL LIST<<<\n"+Arrays.toString(fullList)+"\n");
        System.out.println(">>>GEN LIST<<<\n"+Arrays.toString(filteredList)+"\n");

        System.out.println("Total Line: "+Exercise3.countLine(dl.getPath(),filteredList));
    }
}
