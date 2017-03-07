/**
 * Exercise 17
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

/**
 * CountingListData不是传统的List。它使用享元模式，每次调用迭代器，都会生成一组随机的List<String>。
 * 只能用来配合addAll()方法，填充Collection。
 */
public class CountingListData extends AbstractList<String> {
    private static final String[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    private static final String[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".split("");
    private final int SIZE;
    private final String SEED;
    private final Random R = new Random();
    public CountingListData(int size) {
        SIZE = size;
        SEED = UPPERCASE[size % UPPERCASE.length];
    }
    public int size() {
        return SIZE;
    }
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;
            public boolean hasNext() {
                return index < SIZE;
            }
            public String next() {
                index++;
                return SEED + LOWERCASE[R.nextInt(LOWERCASE.length)];
            }
            public void remove() {
                throw new UnsupportedOperationException("CountingListData is only used to generate random data list!");
            }
        };
    }
    public String get(int index) {
        throw new UnsupportedOperationException("CountingListData is only used to generate random data list!");
    }
    public String toString() {
        Iterator<String> ite = iterator();
        StringBuilder sb = new StringBuilder("[");
        while (ite.hasNext()) {
            sb.append(ite.next());
            if (ite.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
    public static void main(String[] args) {
        System.out.println(new CountingListData(60));
    }
}
