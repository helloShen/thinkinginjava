/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise13 {
    private static class AssociativeArray<K,V> extends AbstractMap<K,V> {
        private Object[][] pairs; // 用Object到处会出现unckeked警告，强制转型。用定长数组，需要处理超出负载问题。
        private int index;
        public AssociativeArray(int length) {
            pairs = new Object[length][2];
        }
        private class Pair implements Map.Entry<K,V> {
            private K key;
            private V value;
            public Pair(K k, V v) {
                key = k;
                value = v;
            }
            public K getKey() {
                return key;
            }
            public V getValue() {
                return value;
            }
            public V setValue(V newVal) {
                V old = value;
                value = newVal;
                return old;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) { // including null
                    return true;
                }
                if (! (o instanceof Map.Entry)) {
                    return false;
                }
                @SuppressWarnings("unchecked")
                Map.Entry<K,V> entry = (Map.Entry<K,V>)o;
                // 必须考虑key和value为null的情况
                return ( ( key == null ) ? ( entry.getKey() == null ) : key.equals(entry.getKey()) ) && ( (value == null ) ? ( entry.getValue() == null ) : value.equals( entry.getValue() ) );
            }
            @Override
            public int hashCode() {
                // 必须考虑key和value为null的情况
                return ( ( key == null ) ? 0 : key.hashCode() ) + ( ( value == null ) ? 0 : value.hashCode() );
            }
            @Override
            public String toString() {
                return "[" + key + ":" + value + "]";
            }
            public boolean isEmpty() {
                return key == null && value == null;
            }
        }
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> entries = new HashSet<>();
            for (Object[] o : pairs) {
                @SuppressWarnings("unchecked")
                K inputKey = (K)o[0];
                @SuppressWarnings("unchecked")
                V inputValue = (V)o[1];
                entries.add(new Pair(inputKey,inputValue));
            }
            return entries;
        }
        @Override
        public V put(K key, V value) {
            if(index >= pairs.length) { // 定长Map，肯定会遇到超出长度范围，所以不抛出错误，只提示用户Map超过负载
                System.out.println("AssociativeArray is not long enough!");
                return null;
            } else {
                pairs[index++] = new Object[]{ key, value };
                @SuppressWarnings("unchecked")
                V outValue = (V) pairs[index-1][1];
                return outValue;
            }
        }
        @Override
        public V get(Object key) {
            @SuppressWarnings("unchecked")
            K inputKey = (K) key;
            for(int i = 0; i < index; i++) {
                if(inputKey.equals(pairs[i][0])) {
                    @SuppressWarnings("unchecked")
                    V returnValue = (V)pairs[i][1];
                    return returnValue;
                }
            }
            return null; // Did not find key
        }
        public String toString() {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < index; i++) {
                result.append(pairs[i][0].toString());
                result.append(" : ");
                result.append(pairs[i][1].toString());
                if(i < index - 1) {
                    result.append("\n");
                }
            }
            return result.toString();
        }
    }
    private static class TestUnit {
        private static int size = 10;
        private static Random r = new Random();
        private static Generator<String> strGen = new RandomGenerator.String();
        private static void testMap() {
            Map<String,Integer> myMap = new AssociativeArray<String,Integer>(size);
            for ( int i = 0; i < size; i++ ) {
                myMap.put(strGen.next(), r.nextInt(size));
            }
            System.out.println(myMap);
        }
        private static void exercise13() {
            String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/MyFileReader.java";
            // 100的长度，可能不够。但AssociativeArray能应付。
            System.out.println(MyFileReader.getWordsFrequence(MyFileReader.readFile(path), new AssociativeArray<String,Integer>(100)));
        }
    }
    public static void main(String[] args) {
        TestUnit.testMap();
        TestUnit.exercise13();
    }
}
