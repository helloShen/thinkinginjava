/**
 * Exercise 5
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise5 extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public Exercise5(int size) {
        if(size < 0) {this.size = 0;}
        this.size = size;
    }
    private static class Entry implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey() { return index; }
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
        public String toString() {
            return getKey() + " = " + getValue();
        }
    }
    private class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        private int setSize = Exercise5.this.size;
        public int size() {return setSize;}
        public Iterator<Map.Entry<Integer,String>> iterator() {
            return new Iterator<Map.Entry<Integer,String>>() {
                private int index;
                private Entry viewWindow = new Entry(-1);
                public boolean hasNext() {
                    return index < setSize;
                }
                public Map.Entry<Integer,String> next() {
                    viewWindow.index++;
                    index++;
                    return viewWindow;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }
    public Set<Map.Entry<Integer,String>> entrySet() {
        return new EntrySet();
    }
    public static void main(String[] args) {
        Map<Integer,String> data = new Exercise5(60);
        Iterator<Map.Entry<Integer,String>> ite = data.entrySet().iterator();
        System.out.print("{ ");
        while (ite.hasNext()) {
            System.out.print("[" + ite.next() + "]");
            if (ite.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.print(" } \n");
    }
}
