/**
 * Exercise 14
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.util.concurrent.*;

public class Exercise14 {
    public static class Maps {
        public static void printKeys(Map<Integer,String> map) {
            System.out.print("Size = " + map.size() + ", ");
            System.out.print("Keys: ");
            System.out.println(map.keySet()); // Produce a Set of the keys
        }
        public static void test(Map<Integer,String> map) {
            System.out.println(map.getClass().getSimpleName());
            map.putAll(new CountingMapData(25));
            // Map has ‘Set’ behavior for keys:
            map.putAll(new CountingMapData(25));
            printKeys(map);
            // Producing a Collection of the values:
            System.out.print("Values: ");
            System.out.println(map.values());
            System.out.println(map);
            System.out.println("map.containsKey(11): " + map.containsKey(11));
            System.out.println("map.get(11): " + map.get(11));
            System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
            Integer key = map.keySet().iterator().next();
            System.out.println("First key in map: " + key);
            map.remove(key);
            printKeys(map);
            map.clear();
            System.out.println("map.isEmpty(): " + map.isEmpty());
            map.putAll(new CountingMapData(25));
            // Operations on the Set change the Map:
            map.keySet().removeAll(map.keySet());
            System.out.println("map.isEmpty(): " + map.isEmpty());
        }

        /**
         * [Properties implements Map<Object,Object>]
         */
        public static void printPropertyKeys(Map<Object,Object> map) {
            System.out.print("Size = " + map.size() + ", ");
            System.out.print("Keys: ");
            System.out.println(map.keySet()); // Produce a Set of the keys
        }
        public static void testProperties(Map<Object,Object> map) {
            System.out.println(map.getClass().getSimpleName());
            // 这里看出Map接口设计中，通配符的巧妙使用
            // putAll(Map<? extends K,? extends V> m) 通配符让Map<Integer,String>能放进Map<Object,Object>
            map.putAll(new CountingMapData(25));
            map.putAll(new CountingMapData(25));
            printPropertyKeys(map);
            // 能放进去，往外拿完全没有问题
            System.out.print("Values: ");
            System.out.println(map.values());
            System.out.println(map);
            System.out.println("map.containsKey(11): " + map.containsKey(11));
            System.out.println("map.get(11): " + map.get(11));
            System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
            // 只有这里需要强制向下转型
            @SuppressWarnings("unckeked")   // CountingMapData has key of integer
            Integer key = (Integer) map.keySet().iterator().next();
            System.out.println("First key in map: " + key);
            // remove(Object key)也是面向Object。删除也完全没有问题
            map.remove(key);
            printPropertyKeys(map);
            map.clear();
            System.out.println("map.isEmpty(): " + map.isEmpty());
            map.putAll(new CountingMapData(25));
            // entrySet(),keySet()返回的都是视图，可以直接在返回的结果上，对Map本体操作。其实values()方法，返回的也是视图。
            map.keySet().removeAll(map.keySet());
            System.out.println("map.isEmpty(): " + map.isEmpty());
        }
    }
    public static void main(String[] args) {
        //Maps.test(new HashMap<Integer,String>());
        //Maps.test(new TreeMap<Integer,String>());
        //Maps.test(new LinkedHashMap<Integer,String>());
        //Maps.test(new IdentityHashMap<Integer,String>());
        //Maps.test(new ConcurrentHashMap<Integer,String>());
        //Maps.test(new WeakHashMap<Integer,String>());
        Maps.testProperties(new Properties());
    }
}
