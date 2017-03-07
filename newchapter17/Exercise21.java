/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise21 {
    private static class SimpleHashMap<K,V> extends AbstractMap<K,V> {
        private static final int SIZE = 997;
        @SuppressWarnings({"rawtypes","unchecked"})
        private LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
        public V put(K key, V value) {
            V oldValue = null;
            int index = Math.abs(key.hashCode()) % SIZE;
            if(buckets[index] == null) {
                buckets[index] = new LinkedList<MapEntry<K,V>>();
            }
            LinkedList<MapEntry<K,V>> bucket = buckets[index];
            MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
            boolean found = false;
            ListIterator<MapEntry<K,V>> it = bucket.listIterator();
            int iteTimes = 0; // 记录循环次数
            while(it.hasNext()) {
                iteTimes++;
                MapEntry<K,V> iPair = it.next();
                if(iPair.getKey().equals(key)) {
                    if (iPair.getValue().equals(value)) { // 检查是否是相等元素
                        System.out.println(iteTimes + "th node in LinkedList: " + pair + " >>> Already exist!");
                    }
                    oldValue = iPair.getValue();
                    it.set(pair); // Replace old with new
                    found = true;
                    break;
                }
            }
            if(!found) {
                buckets[index].add(pair);
            }
            return oldValue;
        }
        public V get(Object key) {
            int index = Math.abs(key.hashCode()) % SIZE;
            if(buckets[index] == null) { return null; }
            for(MapEntry<K,V> iPair : buckets[index]) {
                if(iPair.getKey().equals(key)) {
                    return iPair.getValue();
                }
            }
            return null;
        }
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
            for(LinkedList<MapEntry<K,V>> bucket : buckets) {
                if(bucket == null) { continue; }
                for(MapEntry<K,V> mpair : bucket) {
                    set.add(mpair);
                }
            }
            return set;
        }
        private static class MapEntry<K,V> implements Map.Entry<K,V> {
            private K key;
            private V value;
            public MapEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }
            public K getKey() { return key; }
            public V getValue() { return value; }
            public V setValue(V v) {
                V result = value;
                value = v;
                return result;
            }
            public int hashCode() {
                return (key==null ? 0 : key.hashCode()) ^ (value==null ? 0 : value.hashCode());
            }
            public boolean equals(Object o) {
                if(!(o instanceof MapEntry)) { return false; }
                @SuppressWarnings("rawtypes")
                MapEntry me = (MapEntry)o;
                return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                       (value == null ? me.getValue()== null : value.equals(me.getValue()));
            }
            public String toString() { return key + "=" + value; }
        }
    }
    public static void main(String[] args) {
        Map<String,Integer> map = new SimpleHashMap<>();
        map.put("Hello Ronald", 100);
        map.put("Hello Shen", 200);
        map.put("Hello Ronald", 100);
    }
}
