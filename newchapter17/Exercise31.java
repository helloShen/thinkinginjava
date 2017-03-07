/**
 * Exercise 31
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public final class Exercise31 {
    public static final class SimpleStringList extends AbstractList<String> {
        private static final int INIT_SIZE = 16;
        private String[] items = new String[INIT_SIZE];
        private int size;
        public int size() {
            return size;
        }
        public boolean add(String str) {
            checkCapacity();
            items[size++] = str;
            return true;
        }
        public String get(int index) {
            if (index < 0 || index >= items.length) {
                throw new IndexOutOfBoundsException("Length of the list is " + items.length);
            }
            return items[index];
        }
        private void checkCapacity() {
            if (size == items.length) {
                items = Arrays.copyOf(items,items.length*2);
            }
        }
    }
    private static final class ListPerformance extends AbstractTesterController<List<String>> {
        public Map<String,Test<List<String>>> testRegistry() {
            Generator<String> gen = StringGenerator.newInstance();
            Map<String,Test<List<String>>> tests = new LinkedHashMap<String,Test<List<String>>>();
            tests.put("Add", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    String str = gen.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.add(str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Get", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    for (int i = 0; i < size; i++) {
                        list.add(gen.next());
                    }
                    long start = System.nanoTime();
                    String str = "";
                    for (int i = 0; i < size; i++) {
                        str = list.get(i);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        public static void test(String... args) {
            ListPerformance controller = new ListPerformance();
            controller.containerRegistry().clear();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    public static void main(String[] args) {
        ListPerformance.test("java.util.ArrayList","com.ciaoshen.thinkinjava.newchapter17.Exercise31$SimpleStringList");
    }
}
