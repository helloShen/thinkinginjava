/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.util.regex.*;

public class Exercise21 {
    private static Map<String, Integer> uniqueWords(String path) {
        MyReader reader = new MyReader();
        String content = reader.readFile(path);
        if (content == null || content.isEmpty()) {
            throw new RuntimeException(path + " is null or empty!");
        }
        Matcher wordM = Pattern.compile("\\w+").matcher(content);
        Map<String,Integer> wordsMap = new HashMap<String,Integer>();
        String word = "";
        while (wordM.find()) {
            word = wordM.group();
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word,wordsMap.get(word) + 1);
                continue;
            }
            wordsMap.put(word,1);
        }
        return wordsMap;
    }
    public static Map<String, Integer> sortedUniqueWords(String path) {
        Map<String,Integer> wordsMap = uniqueWords(path);
        if (wordsMap == null || wordsMap.isEmpty()) {
            throw new RuntimeException("The words map for the file " + path + " is null or empty!");
        }
        List<String> list = new ArrayList<String>();
        list.addAll(wordsMap.keySet());
        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for (String word : list) {
            Integer feq = wordsMap.get(word);
            if (feq == null) {
                continue;
            }
            linkedHashMap.put(word, feq);
        }
        return linkedHashMap;
    }
    public static void display(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            throw new RuntimeException("The args Map for display() method is null or empty!");
        }
        Formatter f = new Formatter(System.out);
        f.format("%1$20.20s %2$-5.5s \n", "WORD", "FQ");
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> entry : set) {
            f.format("%1$20.20s %2$-5d \n", entry.getKey(), entry.getValue());
        }
    }
    public static void main(String[] args) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/Exercise21.java";
        //System.out.println(uniqueWords(path));
        //System.out.println(sortedUniqueWords(path));
        display(sortedUniqueWords(path));
    }
}
