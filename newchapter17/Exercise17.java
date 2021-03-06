/**
 * Exercise 17
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise17 {
    public static class SlowMap<K,V> extends AbstractMap<K,V> {
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
        private class MapEntry implements Map.Entry<K,V> {
            private K key;
            private V value;
            public MapEntry() {}
            public MapEntry(K key, V value) {
                this.key = key;
                this.value = value;
            }
            public K getKey() { return key; }
            public V getValue() { return value; }
            public K setKey(K k) { // not included in interface Map.Entry
                K result = key;
                key = k;
                return result;
            }
            public V setValue(V v) {
                V result = value;
                value = v;
                return result;
            }
            public int hashCode() {
                return (key==null ? 0 : key.hashCode()) ^ (value==null ? 0 : value.hashCode());
            }
            public boolean equals(Object o) {
                if(!(o instanceof Map.Entry)) {
                    return false;
                }
                @SuppressWarnings({"unckeked","rawtypes"})
                Map.Entry me = (Map.Entry)o;
                return (key == null ? me.getKey() == null : key.equals(me.getKey())) && (value == null ? me.getValue()== null : value.equals(me.getValue()));
            }
            public String toString() { return key + "=" + value; }
        }
        private class ViewSet extends AbstractSet<Map.Entry<K,V>> { // 明白为什么内部类是闭包了吗孩子？ 外部类的数据随便用，连泛型都和外部类保持一致。其实闭包的名字起得很好！就是外部类的一个可选组件，不用的时候不初始化。
            public int size() {
                return keys.size();
            }
            public Iterator<Map.Entry<K,V>> iterator() {
                return new Iterator<Map.Entry<K,V>>() {
                    private int index = 0;
                    Iterator<K> iteKey = keys.iterator();
                    Iterator<V> iteValue = values.iterator();
                    MapEntry entry = new MapEntry();
                    public boolean hasNext() {
                        return iteKey.hasNext();
                    }
                    public Map.Entry<K,V> next() {
                        entry.setKey(iteKey.next());
                        entry.setValue(iteValue.next());
                        return entry;
                    }
                    // 这里是关键！
                    public void remove() { // AbstractMap的remove()方法，调用这个Set的Iterator的remove()方法，来删除元素。必须直接删除SlowMap的两个List里的元素。
                        iteKey.remove();
                        iteValue.remove();
                    }
                };
            }
        }
        public Set<Map.Entry<K,V>> entrySet() { // entrySet()要提供视图，而不是副本。
            return new ViewSet();
        }
    }
    public static class Maps {
        public static void printKeys(Map<Integer,String> map) {
            System.out.print("Size = " + map.size() + ", ");
            System.out.print("Keys: ");
            System.out.println(map.keySet()); // Produce a Set of the keys
        }
        public static void test(Map<Integer,String> map) {
            System.out.println(map.getClass().getSimpleName());
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
            map.remove(key); // 原始版SlowMap()的remove()方法不奏效,因为entrySet()提供的是元素的副本，不是视图。
            printKeys(map);
            map.clear();
            System.out.println("map.isEmpty(): " + map.isEmpty());
            map.putAll(new CountingMapData(25));
            // Operations on the Set change the Map:
            map.keySet().removeAll(map.keySet());
            System.out.println("map.isEmpty(): " + map.isEmpty());
        }
    }
    private static class TestUnit {
        private static void exercise17() {
            Maps.test(new SlowMap<Integer,String>());
        }
    }
    public static void main(String[] args) {
        TestUnit.exercise17();
    }
}
