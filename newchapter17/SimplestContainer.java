/**
 * 最简实现容器
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class SimplestContainer {
    private static class SimplestList<E> extends AbstractList<E> {
        List<E> list = new ArrayList<>();
        @Override
        public E get(int index) {
            return list.get(index);
        }
        @Override
        public int size() {
            return list.size();
        }
    }
    private static class SimplestSet<E> extends AbstractSet<E> {
        Set<E> set = new HashSet<>();
        @Override
        public int size() {
            return set.size();
        }
        public Iterator<E> iterator() {
            return set.iterator();
        }
    }
    private static class SimplestMap<K,V> extends AbstractMap<K,V> {
        Map<K,V> map = new HashMap<>();
        @Override
        public Set<Map.Entry<K,V>> entrySet() { // 自己写entrySet的话，可以利用AbstractMap.SimpleEntry
            return map.entrySet();
        }
    }
    public static void main(String[] args) {
        SimplestList<String> simpleList = new SimplestList<>();
        System.out.println(simpleList.size());
        System.out.println(simpleList.isEmpty());
        SimplestSet<String> simpleSet = new SimplestSet<>();
        System.out.println(simpleSet.size());
        System.out.println(simpleSet.isEmpty());
        SimplestMap<Integer,String> simpleMap = new SimplestMap<>();
        System.out.println(simpleMap.size());
        System.out.println(simpleMap.isEmpty());
    }
}
