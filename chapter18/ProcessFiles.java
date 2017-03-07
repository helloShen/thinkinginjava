/**
 *  递归获取指定节点所有子文件
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }
    public void start(String[] args){
        try{
            if(args.length==0){
                processDirectoryTree(new File("."));
            }else{
                for(String arg:args){
                    processDirectoryTree(new File(arg));
                }
            }
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void processDirectoryTree(File root) throws IOException {
        for(File file : new Directory(root.getAbsolutePath(), ".*\\." + ext).getFile()){
            strategy.process(file.getCanonicalFile());
        }
    }
    // Demonstration of how to use it:
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}