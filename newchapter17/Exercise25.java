/**
 * Exercise 25
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise25 {
    private static class LinkedMap<K,V> extends AbstractMap<K,V> {
        private LinkedSet nodeSet = new LinkedSet();
        // 只有entrySet()是面向Set<Map.Entry<K,V>>接口的。
        public Set<Map.Entry<K,V>> entrySet() { return nodeSet; }
        // 其他所有方法都可以直接面向功能更强大的LinkedSet。
        public V put(K k,V v) {
            return nodeSet.put(new Node<K,V>(k,v));
        }
        private static class Node<K,V> implements Map.Entry<K,V> { // no visitor for "next" field
            private K key;
            private V value;
            private Node<K,V> next;
            private Node() {}
            private Node(K k, V v) {
                key = k;
                value = v;
                next = null;
            }
            public K getKey() {
                return key;
            }
            public V getValue() {
                return value;
            }
            public V setValue(V v) {
                V oldValue = value;
                value = v;
                return oldValue;
            }
            public boolean equals(Object o) { // only compare key
                if (o == this) { return true; }
                if ( ! ( o instanceof Node ) ) {
                    return false;
                }
                @SuppressWarnings({"rawtypes","unchecked"})
                Node<K,V> n = (Node)o;
                return n.key.equals(key);
            }
            public int hashCode() { // only calculate key
                return 31 * 17 + key.hashCode();
            }
            public String toString() {
                return "N[" + key + "," + value + "]";
            }
        }
        /**
         *  Map.Entry<K,V>接口太弱，不支持链表操作。
         * 但又不能用上界通配符<? extends Map.Entry<K,V>>来泛化接口匹配范围，
         * 因为根据PECP原则，上界通配符细化粒度以后，LinkedSet无法插入元素，add()方法无法执行。
         * 这里的解决方案是：
         *      LinkedList不支持add()方法，新增一个支持链表操作的put()方法。
         */
        private class LinkedSet extends AbstractSet<Map.Entry<K,V>> {
            private Node<K,V> head = new Node<K,V>();
            private int size;
            public int size() { return size; }
            public Iterator<Map.Entry<K,V>> iterator() {
                return new Iterator<Map.Entry<K,V>>() {
                    private Node<K,V> cursor = head; // last node returned by next() method
                    private Node<K,V> previous = cursor; // previous node of last Node returned by next()
                    public boolean hasNext() {
                        return cursor.next != null;
                    }
                    public Map.Entry<K,V> next() {
                        if (cursor.next == null) {
                            throw new NoSuchElementException();
                        }
                        Node<K,V> next = cursor.next;
                        previous = cursor;
                        cursor = next;
                        return next;
                    }
                    public void remove() {
                        if (cursor == previous) {
                            throw new IllegalStateException();
                        }
                        previous.next = cursor.next;
                        cursor.next = null;
                        cursor = previous;
                        size--;
                    }
                };
            }
            // Set<Map.Entry<K,V>>接口的add()方法太弱，必须接受Map.Entry<K,V>接口的参数。
            // 不支持链表操作，所以废弃。
            public boolean add(Map.Entry<K,V> node) {
                throw new UnsupportedOperationException("add() method of Set interface is too weak!");
            }
            // 面向Node<K,V>的put()方法，是add()方法的增强版。支持链表操作。
            public V put(Node<K,V> node) {
                V result = null;
                Iterator<Map.Entry<K,V>> ite = iterator();
                while (ite.hasNext()) {
                    Map.Entry<K,V> entry = ite.next();
                    if (node.equals(entry)) { // replace = remove + addFirst
                        ite.remove();
                        result = entry.getValue();
                    }
                }
                node.next = head.next;
                head.next = node;
                size++;
                return result;
            }
        }
    }
    public static void main(String[] args) {
        int max = 128;
        int min = 32;
        int size = 10;
        Random r = new Random();
        Map<Integer,Character> ascii = new LinkedMap<>();
        for (int i = 0; i < size; i++) {
            int index = r.nextInt(max-min) + min;
            ascii.put(index,(char)index);
        }
        System.out.println(ascii);
        loopAsciiRange:
        for (int i = 0; i < max; i++) { // remove the smallest element
            if (ascii.containsKey(i)) {
                ascii.remove(i);
                System.out.println(new LinkedMap.Node<Integer,Character>(i,(char)i) + " is removed!");
                break loopAsciiRange;
            }
        }
        System.out.println(ascii);
    }
}
