/**
 *  递归获取指定节点所有子文件
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Directory{
    private List<File> files=new ArrayList<File>();
    private List<File> dirs=new ArrayList<File>();
    private int size=0;
    private int lines=0;
        
    public Directory(){this(".");}
    public Directory(String dir){this(new File(dir));}
    public Directory(File dir){this(dir,".*");}
    public Directory(String dir, String regex){this(new File(dir),regex);}
    public Directory(File dir,String regex){
        recurseDirs(dir,new FilenameFilter(){
            private Pattern p=Pattern.compile(regex);
            public boolean accept(File dir,String name){
                return p.matcher(name).matches();
            }
        });
        statistic();
    }
    public Directory(File dir,FilenameFilter filter){
        recurseDirs(dir,filter);
        statistic();
    }
    
    //递归收集文件
    public void recurseDirs(File dir, FilenameFilter filter){
        File[] children=dir.listFiles();
        if(children==null || children.length==0){return;}
        for(File f:children){
            if(f.isDirectory()){
                dirs.add(f);
                recurseDirs(f,filter);
            }else{
                if(filter.accept(dir,f.getName())){
                    files.add(f);
                }
            }
        }
    }
    
    public void statistic(){
        if(files!=null && files.size()>0){
            size=files.size();
            int num=0;
            for(File file:files){
                try{
                    BufferedReader bf=new BufferedReader(new FileReader(file));
                    while(bf.readLine()!=null){
                        num++;
                    }
                }catch(Exception e){
                    System.out.println(file.getName()+" can not open!");
                }
            }
            lines=num;
        }
    }
    
    public List<File> getFile(){return files;}
    public List<File> getDir(){return dirs;}
    public void showStatistic(){System.out.println("File number:    "+size+"\n"+"Total Lines:   "+lines+"\n");}

    public static void main(String[] args){
        Directory dir=new Directory("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter17/testframework/",".*Gen.*");
        List<File> files=dir.getFile();
        List<File> dirs=dir.getDir();
        if(files!=null  && !(files.size()==0)){
            System.out.println(files);
        }
        if(dirs!=null  && !(dirs.size()==0)){
            System.out.println(dirs);
        }
    }
}