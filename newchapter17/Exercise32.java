/**
 * Exercise 32
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public final class Exercise32 {
    public static final class IntList extends AbstractList<Integer> {
        private static final int INIT_SIZE = 16;
        private int[] items = new int[INIT_SIZE];
        private int size;
        public int size() {
            return size;
        }
        public boolean add(Integer i) {
            checkCapacity();
            items[size++] = i;
            return true;
        }
        public Integer get(int index) {
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
    private static final class StringListPerformance extends AbstractTesterController<List<String>> {
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
                    for (int i = 0; i < size; i++) {
                        list.get(i);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        public static void test(String... args) {
            StringListPerformance controller = new StringListPerformance();
            controller.containerRegistry().clear();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    private static final class IntListPerformance extends AbstractTesterController<List<Integer>> {
        public Map<String,Test<List<Integer>>> testRegistry() {
            int max = 1000;
            Random r = new Random();
            Map<String,Test<List<Integer>>> tests = new LinkedHashMap<String,Test<List<Integer>>>();
            tests.put("Add", new Test<List<Integer>>() {
                public long test(List<Integer> list, int size) {
                    Integer num = r.nextInt(max);
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.add(num);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Get", new Test<List<Integer>>() {
                public long test(List<Integer> list, int size) {
                    for (int i = 0; i < size; i++) {
                        list.add(r.nextInt(max));
                    }
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.get(i);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        public static void test(String... args) {
            IntListPerformance controller = new IntListPerformance();
            controller.containerRegistry().clear();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    public static void main(String[] args) {
        StringListPerformance.test("java.util.ArrayList");
        IntListPerformance.test("com.ciaoshen.thinkinjava.newchapter17.Exercise32$IntList");
    }
}
