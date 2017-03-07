/**
 * Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise26 {
    public static LinkedHashMap<String,ArrayList<Integer>> sortedStatistic(String path, String regex) {
        Map<String,ArrayList<Integer>> shuffleWordMap = Exercise25.statistic(path,regex);
        Map<Integer,String> indexMap = getIndexMap(shuffleWordMap);
        List<Map.Entry<Integer,String>> indexList = new ArrayList<Map.Entry<Integer,String>>();
        indexList.addAll(indexMap.entrySet());
        Collections.sort(indexList, new Comparator<Map.Entry<Integer,String>>() {
            public int compare(Map.Entry<Integer,String> entry1, Map.Entry<Integer,String> entry2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        LinkedHashMap<String,ArrayList<Integer>> sortedWordMap = new LinkedHashMap<String,ArrayList<Integer>>();
        for (Map.Entry<Integer,String> entry : indexList) {
            String word = entry.getValue();
            sortedWordMap.put(word,shuffleWordMap.get(word));
        }
        return sortedWordMap;
    }
    public static Map<Integer,String> getIndexMap(Map<String,ArrayList<Integer>> shuffleMap) {
        Map<Integer,String> resultIndex = new HashMap<Integer,String>();
        for (Map.Entry<String,ArrayList<Integer>> entry : shuffleMap.entrySet()) {
            resultIndex.put(entry.getValue().get(0),entry.getKey());
        }
        return resultIndex;
    }
    public static void main(String[] args) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/Exercise25.java";
        String regex = "\\w+";
        System.out.println(sortedStatistic(path,regex));
    }
}
