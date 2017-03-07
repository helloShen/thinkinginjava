/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise12 {
    private static void testMap(Map<String,String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object"); // Past the end
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
    public static void main(String[] args) {
        int size = 6;
        Map<String,String> hashmap = new HashMap<String,String>(size);
        Map<String,String> treemap = new TreeMap<String,String>();
        Map<String,String> linkedhashmap = new LinkedHashMap<String,String>(size);
        testMap(hashmap);
        testMap(treemap);
        testMap(linkedhashmap);
    }
}
