/**
 * Exercise 22
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.util.regex.*;

public class Exercise22 {
    private static class Pair implements Comparable<Pair> {
        private String key = "";
        private int value = 0;
        public Pair() {}
        public Pair(String word, int freq) {
            key = word;
            value = freq;
        }
        public String getKey() {
            return key;
        }
        public int getValue() {
            return value;
        }
        public void setKey(String word) {
            key = word;
        }
        public void setValue(int freq) {
            value = freq;
        }
        public String toString() {
            return "(" + key + "," + value + ")";
        }
        public int compareTo(Pair p) {
            return String.CASE_INSENSITIVE_ORDER.compare(this.key, p.getKey());
        }
        @Override
        public boolean equals(Object o) {
            Pair p = (Pair)o;
            return this.key.equals(p.getKey());
        }
        @Override
        public int hashCode() {
            return this.key.hashCode();
        }
    }
    private static Set<Pair> uniqueWords(String path) {
        MyReader reader = new MyReader();
        String content = reader.readFile(path);
        if (content == null || content.isEmpty()) {
            throw new RuntimeException(path + " is null or empty!");
        }
        Matcher wordM = Pattern.compile("\\w+").matcher(content);
        Set<Pair> pairSet = new HashSet<Pair>();
        while (wordM.find()) {
            Pair word = new Pair(wordM.group(), 1);
            if (pairSet.contains(word)) {
                if (updateSet(pairSet, word)) {
                    continue;
                }
            }
            pairSet.add(word);
        }
        return pairSet;
    }
    private static boolean updateSet(Set<Pair> set, Pair p) {
        Iterator<Pair> ite = set.iterator();
        while (ite.hasNext()) {
            Pair current = ite.next();
            if (current.equals(p)) {
                String key = current.getKey();
                int freq = current.getValue();
                Pair newPair = new Pair(key, freq + 1);
                set.remove(p);
                set.add(newPair);
                return true;
            }
        }
        return false;
    }
    public static List<Pair> sortedUniqueWords(String path) {
        Set<Pair> pairSet = uniqueWords(path);
        if (pairSet == null || pairSet.isEmpty()) {
            throw new RuntimeException("The pair set for the file " + path + " is null or empty!");
        }
        List<Pair> list = new ArrayList<Pair>();
        list.addAll(pairSet);
        Collections.sort(list);
        return list;
    }
    public static void display(List<Pair> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("The args list for display() method is null or empty!");
        }
        Formatter f = new Formatter(System.out);
        f.format("%1$20.20s %2$-5.5s \n", "WORD", "FQ");
        for (Pair pair : list) {
            f.format("%1$20.20s %2$-5d \n", pair.getKey(), pair.getValue());
        }
    }
    public static void main(String[] args) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/Exercise21.java";
        //System.out.println(uniqueWords(path));
        //System.out.println(sortedUniqueWords(path));
        display(sortedUniqueWords(path));
    }
}
