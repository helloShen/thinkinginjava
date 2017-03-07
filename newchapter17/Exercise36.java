/**
 * Exercise 36
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise36 {
      public static class BetterSlowMap<K,V> extends AbstractMap<K,V> { // AbstractMap自带Entry
         protected List<Map.Entry<K,V>> list = new ArrayList<>();
         public Set<Map.Entry<K,V>> entrySet() { //直接用AbstractSet骨架实现封装一个ArrayList迭代器返回的视图。
             return new AbstractSet<Map.Entry<K,V>>() {
                 public int size() {
                     return list.size();
                 }
                 public Iterator<Map.Entry<K,V>> iterator() {
                     return list.iterator();
                 }
             };
         }
         public V put(K key, V value) {
             V oldValue = null;
             int index = 0;
             for (Map.Entry<K,V> entry : list) {
                 if (key.equals(entry.getKey())) {
                     oldValue = entry.getValue();
                     list.set(index, new SimpleEntry<K,V>(key,value));
                     return oldValue;
                 }
                 index++;
             }
             list.add(new SimpleEntry<K,V>(key,value));
             return oldValue;
         }
         public V get(Object key) { // key is type Object, not K
             if (key == null) {
                 for (Map.Entry<K,V> entry : list) {
                     if (entry.getKey() == null) {
                         return entry.getValue();
                     }
                 }
             } else {
                 @SuppressWarnings("unchecked")
                 K k = (K)key; // otherwise throw ClassCastException
                 for (Map.Entry<K,V> entry : list) {
                     if (k.equals(entry.getKey())) {
                         return entry.getValue();
                     }
                 }
             }
             return null;
         }
     }
     public static class BetterSlowMapV2<K extends Comparable<? super K>,V> extends BetterSlowMap<K,V> { // AbstractMap自带Entry
        private final Comparator<Map.Entry<K,V>> keyNaturalOrder = new Comparator<Map.Entry<K,V>>() {
            public int compare(Map.Entry<K,V> entry1, Map.Entry<K,V> entry2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        };
        @Override
        public V put(K key, V value) {
            V oldValue = null;
            int index = 0;
            forlist:
            for (Map.Entry<K,V> entry : list) {
                if (key.equals(entry.getKey())) { // had this key
                    oldValue = entry.getValue();
                    list.set(index, new SimpleEntry<K,V>(key,value));
                    break forlist;
                }
                index++;
            }
            if (oldValue == null) {
                list.add(new SimpleEntry<K,V>(key,value));
            }
            Collections.sort(list,keyNaturalOrder);
            return oldValue;
        }
        @Override
        public V get(Object key) { // key is type Object, not K
            if (key == null) {
                for (Map.Entry<K,V> entry : list) {
                    if (entry.getKey() == null) {
                        return entry.getValue();
                    }
                }
            } else {
                @SuppressWarnings("unchecked")
                Map.Entry<K,V> entry = new SimpleEntry<K,V>((K)key,(V)new Object());
                int index = Collections.binarySearch(list,entry,keyNaturalOrder);
                if (index >= 0) {
                    return list.get(index).getValue();
                }
            }
            return null;
        }
    }
     private static final void testMap(Map<Integer,String> map) {
         int max = 10;
         Random r = new Random();
         Generator<String> gen = StringGenerator.newInstance();
         for (int i = 0; i < max; i++) {
             map.put(r.nextInt(max),gen.next());
         }
         System.out.println(map);
         for (int i = 0; i < max; i++) {
             String str = map.get(i);
             if (str != null) {
                 System.out.println("My map contains: Entry[" + i + "," + str + "]" );
             }
         }
     }
     public static void main(String[] args) {
         testMap(new BetterSlowMap<Integer,String>());
         testMap(new BetterSlowMapV2<Integer,String>());
         Exercise35.MapPerformance.test("com.ciaoshen.thinkinjava.newchapter17.Exercise36$BetterSlowMap","com.ciaoshen.thinkinjava.newchapter17.Exercise36$BetterSlowMapV2");
     }
 }
