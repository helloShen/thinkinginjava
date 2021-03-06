/**
 * Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise11 {
    public static Collection<Object> fillCollection(Collection<Object> c, Class<?> klass, int size) {
        try {
            for (int i = 0; i < size; i++) {
                c.add(klass.newInstance());
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    public static <T> void parseCollection(Collection<T> c) {
        Iterator<T> ite = c.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
    public static class MyObject implements Comparable<MyObject> {
        private static int count = 0;
        private final int ID = ++count;
        public MyObject() {}
        public String toString() {
            return "MyObject#" + ID + "!";
        }
        public int getId() {
            return ID;
        }
        public int compareTo(MyObject o) {
            return o.getId() - getId();
        }
    }
    public static void main(String[] args) {
        Class<?> klass;
        try {
            klass = Class.forName("com.ciaoshen.thinkinjava.chapter11.Exercise11$MyObject");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int size = 10;
        //ArrayList
        parseCollection(fillCollection(new ArrayList<Object>(), klass, size));
        //LinkedList
        parseCollection(fillCollection(new LinkedList<Object>(), klass, size));
        //HashSet
        parseCollection(fillCollection(new HashSet<Object>(), klass, size));
        //TreeSet
        parseCollection(fillCollection(new TreeSet<Object>(), klass, size));
        //LinkedHashSet
        parseCollection(fillCollection(new LinkedHashSet<Object>(), klass, size));
    }
}
