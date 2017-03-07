/**
 * Exercise 15
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise15 {
    private static class SlowMap<K,V> extends AbstractMap<K,V> {
        private List<K> keys = new ArrayList<K>();
        private List<V> values = new ArrayList<V>();
        public V put(K key, V value) {
            V oldValue = get(key); // The old value or null
            if(!keys.contains(key)) {
                keys.add(key);
                values.add(value);
            } else {
                values.set(keys.indexOf(key), value);
            }
            return oldValue;
        }
        public V get(Object key) { // key is type Object, not K
            if(!keys.contains(key)) {
                return null;
            }
            return values.get(keys.indexOf(key));
        }
        public class MapEntry<K,V> implements Map.Entry<K,V> {
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
                if(!(o instanceof MapEntry)) {
                    return false;
                }
                @SuppressWarnings({"unckeked","rawtypes"})
                MapEntry me = (MapEntry)o;
                return (key == null ? me.getKey() == null : key.equals(me.getKey())) && (value == null ? me.getValue()== null : value.equals(me.getValue()));
            }
            public String toString() { return key + "=" + value; }
        }
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
            Iterator<K> ki = keys.iterator();
            Iterator<V> vi = values.iterator();
            while(ki.hasNext()) {
                set.add(new MapEntry<K,V>(ki.next(), vi.next()));
            }
            return set;
        }
    }
    private static class TestUnit {
        private static void testSlowMap() {
            SlowMap<String,String> m= new SlowMap<>();
            m.putAll(Countries.fillMapByList(Countries.getSortedCountries(15)));
            System.out.println(m);
            System.out.println(m.get("BULGARIA"));
            System.out.println(m.entrySet());
        }
        private static void exercise15() {
            String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/MyFileReader.java";
            System.out.println(MyFileReader.getWordsFrequence(MyFileReader.readFile(path), new SlowMap<String,Integer>()));
        }
    }
    public static void main(String[] args) {
        TestUnit.testSlowMap();
        TestUnit.exercise15();
    }
}
