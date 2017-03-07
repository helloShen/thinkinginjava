/**
 * Exercise 38
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.lang.Math.*;

final class Exercise38 {
    private static final class MapTester {
        public static final long test(Map<String,Integer> map) {
            return test(map, 10000, 100, 10);
        }
        public static final long test(Map<String,Integer> map, int size, int loop, int warmup) {
            long result = 0;
            for (int i = 0; i < loop; i++) {
                if (i >= warmup) {
                    result += testUnit(map,size);
                }
            }
            return result;
        }
        private static final Generator<String> GEN = StringGenerator.newInstance(7);
        // give me the lovely map, and I test it
        private static final long testUnit(Map<String,Integer> map,int size) {
            Integer freq = 0;
            String str = GEN.next();
            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                freq = map.get(str);
            }
            long end = System.nanoTime();
            return end - start;
        }
        public static final Map<String,Integer> fillWordFrequence(Map<String,Integer> map, int size) {
            String word = "";
            for (int i = 0; i < size; i++) {
                word = GEN.next();
                if (map.containsKey(word)) {
                    map.put(word,map.get(word)+1);
                } else {
                    map.put(word,1);
                }
            }
            return map;
        }
    }
    public static void main(String[] args) {
        /**
        int capacity = 4096;
        float loadFactor = 0.9f;
        Map<String,Integer> map = new HashMap<>(capacity, loadFactor);
        map = MapTester.fillWordFrequence(map,Math.round(capacity*loadFactor)-10); // don't resize
        Formatter f = new Formatter(System.out);
        String formatField = "%10.10s %10d \n";
        f.format(formatField,"Small Map: ", MapTester.test(map));
        Map<String,Integer> largerMap = new HashMap<>(capacity*2, loadFactor);
        largerMap.putAll(map);
        f.format(formatField, "Large Map: : ", MapTester.test(largerMap));
        */
        String str = "Hello";
        System.out.println(str == str.intern());
    }
}
