/**
 * Exercise 37
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public final class Exercise37 {
    public static final class SimpleLinkedHashMap<K,V> extends AbstractMap<K,V> {
        static final int SIZE = 997;
        @SuppressWarnings({"unchecked","rawtypes"})
        LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
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
            while(it.hasNext()) {
                MapEntry<K,V> iPair = it.next();
                if(iPair.getKey().equals(key)) {
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
        private static final class MapEntry<K,V> implements Map.Entry<K,V> {
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
                @SuppressWarnings({"unchecked","rawtypes"})
                MapEntry me = (MapEntry)o;
                return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                    (value == null ? me.getValue()== null : value.equals(me.getValue()));
            }
            public String toString() { return key + "=" + value; }
        }
    }
    public static final class SimpleArrayHashMap<K,V> extends AbstractMap<K,V> {
        static final int SIZE = 997;
        @SuppressWarnings({"rawtypes","unchecked"})
        ArrayList<MapEntry<K,V>>[] buckets = new ArrayList[SIZE];
        public V put(K key, V value) {
            V oldValue = null;
            int index = Math.abs(key.hashCode()) % SIZE;
            if(buckets[index] == null) {
                buckets[index] = new ArrayList<MapEntry<K,V>>();
            }
            ArrayList<MapEntry<K,V>> bucket = buckets[index];
            MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
            boolean found = false;
            ListIterator<MapEntry<K,V>> it = bucket.listIterator();
            while(it.hasNext()) {
                MapEntry<K,V> iPair = it.next();
                if(iPair.getKey().equals(key)) {
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
        public Set<Map.Entry<K,V>> entrySet() { // 为了更好地和原来的SimpleHashMap比较，还是返回副本而不是视图。
            Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
            for(ArrayList<MapEntry<K,V>> bucket : buckets) {
                if(bucket == null) { continue; }
                for(MapEntry<K,V> mpair : bucket) {
                    set.add(mpair);
                }
            }
            return set;
        }
        private static final class MapEntry<K,V> implements Map.Entry<K,V> {
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
                if(!(o instanceof MapEntry)) return false;
                @SuppressWarnings({"rawtypes","unchecked"})
                MapEntry me = (MapEntry)o;
                return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                        (value == null ? me.getValue()== null : value.equals(me.getValue()));
            }
            public String toString() { return key + "=" + value; }
        }
    }
    private static void testMap(Map<String,String> m) {
        Generator<String> gen = StringGenerator.newInstance();
        Random r = new Random();
        int size = 10;
        for (int i = 0; i < size; i++) {
            m.put(String.valueOf(r.nextInt(size)),gen.next());
        }
        System.out.println(m);
        System.out.println(m.get("1"));
        System.out.println(m.entrySet());
    }
    public static void main(String[] args) {
        testMap(new SimpleArrayHashMap<String,String>());
        testMap(new SimpleLinkedHashMap<String,String>());
        Exercise35.MapPerformance.test("java.util.HashMap", "java.util.LinkedHashMap", "com.ciaoshen.thinkinjava.newchapter17.Exercise37$SimpleArrayHashMap","com.ciaoshen.thinkinjava.newchapter17.Exercise37$SimpleLinkedHashMap");
    }
}
