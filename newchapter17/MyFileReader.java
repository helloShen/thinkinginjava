/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyFileReader {
    public static String readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    sb = sb.append(line + "\n");
                }
                return sb.toString();
            } finally {
                br.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String,Integer> getWordsFrequence(String content, Map<String,Integer> freqDic) {
        String wordRegex = "\\w+";
        Matcher wordsMatcher = Pattern.compile(wordRegex).matcher(content);
        while (wordsMatcher.find()) {
            String word = wordsMatcher.group();
            if (freqDic.containsKey(word)) {
                freqDic.put(word,freqDic.get(word)+1);
            } else {
                freqDic.put(word,1);
            }
        }
        return freqDic;
    }
    private static class TestUnit {
        private static String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/MyFileReader.java";
        private static void testReadFile() {
            System.out.println(readFile(path));
        }
        private static void testGetWordFrequence() {
            System.out.println(getWordsFrequence(readFile(path), new HashMap<String,Integer>()));
        }
    }
    public static void main(String[] args) {
        //TestUnit.testReadFile();
        TestUnit.testGetWordFrequence();
    }
}
