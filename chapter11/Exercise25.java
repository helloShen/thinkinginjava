/**
 * Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.util.regex.*;

// statistics the word and their positions in the file
public class Exercise25 {
    public static Map<String,ArrayList<Integer>> statistic(String path, String regex) {
        if (path == null || regex == null) {
            throw new RuntimeException("Argument content or regex is null!");
        }
        String content = new MyReader().readFile(path);
        if (content == null) {
            throw new RuntimeException("The content in " + path + " is null!");
        }
        Matcher matcher = Pattern.compile(regex).matcher(content);
        Map<String,ArrayList<Integer>> result = new HashMap<String,ArrayList<Integer>>();
        ArrayList<Integer> value = new ArrayList<Integer>();
        String key = "";
        while (matcher.find()) {
            key = matcher.group();
            if (result.containsKey(key)) {
                value = result.get(key);
                value.add(matcher.start());
                result.put(key,value);
                continue;
            }
            result.put(matcher.group(), new ArrayList<Integer>(Arrays.asList(matcher.start())));
        }
        return result;
    }
    public static void main(String[] args) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/Exercise25.java";
        String regex = "\\w+";
        System.out.println(statistic(path,regex));
    }
}
