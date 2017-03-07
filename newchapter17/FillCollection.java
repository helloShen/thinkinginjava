/**
 * Generator
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class FillCollection<T> extends ArrayList<T> {
    private static final long serialVersionUID = 0;
    private FillCollection(Generator<T> gen, int size) {
        for ( int i = 0; i < size; i++) {
            add(gen.next());
        }
    }
    public static <V> Collection<V> fill(Generator<V> gen, int size) {
        return new FillCollection<V>(gen,size);
    }
    private static class IntegerGenerator implements Generator<Integer> {
        private int max = 1000;
        public IntegerGenerator() {}
        public IntegerGenerator(int num) {
            max = num;
        }
        private final Random rand = new Random();
        public Integer next() {
            return rand.nextInt(max);
        }
    }
    public static void main(String[] args) {
        List<Integer> strList = new ArrayList<Integer>();
        strList.addAll(FillCollection.fill(new IntegerGenerator(), 100));
        System.out.println(strList);
    }
}
