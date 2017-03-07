/**
 * Exercise 19
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise39 {
    private static class SimpleHashMap<K,V> extends AbstractMap<K,V> {
        private static int maxSize = 997;
        @SuppressWarnings({"rawtypes","unchecked"})
        private LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[maxSize];
        public V put(K key, V value) {
            checkCapacity();
            V oldValue = null;
            int index = Math.abs(key.hashCode()) % maxSize;
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
            int index = Math.abs(key.hashCode()) % maxSize;
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
        private static float loadFactor = 0.75f;
        private void checkCapacity() {
            if (size() > Math.round(maxSize * loadFactor)) {
                System.out.println("I am resizing the map!");
                System.out.println("Original size is: " + SimpleHashMap.maxSize);
                reSize();
                reHash();
                System.out.println("Now the size is: " + SimpleHashMap.maxSize);
            }
        }
        private void reSize() {
            int result = maxSize * 2;
            maxSize = nextPrime(result);
        }
        private int nextPrime(int num) { // can accept the negative int
            if (num < 2) {
                return 2;
            }
            whileLoop:
            while (true) {
                num++;
                eachNum:
                for (int i = 2; i < num; i++) {
                    if ( (num % i) == 0 ) { // not prime
                        continue whileLoop;
                    }
                }
                return num;
            }
        }
        private void reHash() {
            @SuppressWarnings({"rawtypes","unchecked"})
            LinkedList<MapEntry<K,V>>[] newBuckets = new LinkedList[maxSize];
            for (LinkedList<MapEntry<K,V>> bucket : buckets) {
                if (bucket != null && (! bucket.isEmpty())) {
                    for (MapEntry<K,V> entry : bucket) {
                        int index = Math.abs(entry.getKey().hashCode()) % maxSize;
                        if (newBuckets[index] == null) {
                            newBuckets[index] = new LinkedList<MapEntry<K,V>>();
                        }
                        newBuckets[index].add(entry);
                    }
                }
            }
            buckets = newBuckets;
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
    private static class TestUnit {
        private static final Generator<String> GEN = StringGenerator.newInstance();
        private static void testMap(Map<String,String> map) {
            int size = 10;
            for (int i = 0; i < size; i++) {
                map.put(GEN.next(),GEN.next());
            }
            System.out.println(map);
        }
        private static void checkPrime(int num, int nextPrime) {
            SimpleHashMap<String,String> map = new SimpleHashMap<>();
            int result = map.nextPrime(num);
            if (result != nextPrime) {
                throw new RuntimeException("Given " + num + " nextPrime() should return " + nextPrime + ", not " + result + " !");
            }
        }
        private static void testNextPrime() {
            checkPrime(-1,2);
            checkPrime(0,2);
            checkPrime(1,2);
            checkPrime(2,3);
            checkPrime(3,5);
            checkPrime(7,11);
            checkPrime(19,23);
            System.out.println("Method nextPrime() pass the test!!");
        }
        private static void testResize() {
            SimpleHashMap<String,String> map = new SimpleHashMap<>();
            int before = SimpleHashMap.maxSize;
            map.reSize();
            int after = SimpleHashMap.maxSize;
            if (before != 997 || after != 1997) {
                throw new RuntimeException("Should return " + 1997 + ", not " + SimpleHashMap.maxSize + " !");
            }
        }
        private static void testResizeTheMap() {
            SimpleHashMap<String,String> map = new SimpleHashMap<>();
            int currentSize = SimpleHashMap.maxSize;
            for (int i = 0, times = 5; i < SimpleHashMap.maxSize && times > 0; i++) {
                if (currentSize != SimpleHashMap.maxSize) {
                    times--;
                    currentSize = SimpleHashMap.maxSize;
                }
                map.put(GEN.next(), GEN.next());
            }
        }
    }
    public static void main(String[] args) {
        //TestUnit.testNextPrime();
        //TestUnit.testResize();
        TestUnit.testResizeTheMap();
    }
}
