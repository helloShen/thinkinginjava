/**
 * Exercise 23
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise23 {
    private static Map<Integer,Integer> randomNum(int size) {
        Random rand = new Random();
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i = 0; i < 10000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(size);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        return m;
    }
    // merge the second map to the first map
    private static Map<Integer,Integer> mergeMap(Map<Integer,Integer> map1, Map<Integer,Integer> map2) {
        if (map1 == null || map1.isEmpty() || map2 == null || map2.isEmpty()) {
            return map1;
        }
        Set<Map.Entry<Integer,Integer>> set1 = map1.entrySet();
        Set<Map.Entry<Integer,Integer>> set2 = map2.entrySet();
        Map<Integer,Integer> result = new HashMap<Integer,Integer>();
        for (Map.Entry<Integer,Integer> entry1 : set1) {
            Integer key1 = entry1.getKey();
            Integer value1 = entry1.getValue();
            for (Map.Entry<Integer,Integer> entry2 : set2) {
                Integer key2 = entry2.getKey();
                Integer value2 = entry2.getValue();
                if (key2 != null && value2 != null && key2.equals(key1)) {
                    result.put(key1, value1 + entry2.getValue());
                    break;
                }
                result.put(key1,value1);
            }
        }
        return result;
    }
    public static Map<Integer,Integer> repeatRandomNum(int times, int size) {
        Map<Integer,Integer> result = randomNum(size);
        for (int i = 0; i < times-1; i++) {
            result = mergeMap(result,randomNum(size));
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(repeatRandomNum(10,20));
    }
}
