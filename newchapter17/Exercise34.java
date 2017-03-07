/**
 * Exercise 34
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise34 {
    private static final class SetPerformance extends AbstractTesterController<Set<String>> {
        private final Generator<String> gen = StringGenerator.newInstance();
        private Set<String> randomFill(Set<String> set, int size) {
            for (int i = 0; i < size; i++) {
                set.add(gen.next());
            }
            return set;
        }
        public Map<String,Test<Set<String>>> testRegistry() {
            Map<String,Test<Set<String>>> tests = new HashMap<>();
            tests.put("Add", new Test<Set<String>>() {
                public long test(Set<String> set, int size) {
                    String str = gen.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        set.add(str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Contains", new Test<Set<String>>() {
                public long test(Set<String> set, int size) {
                    set = randomFill(set,size);
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        set.contains(gen.next()); // 被生成器操作污染
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Iterate", new Test<Set<String>>() {
                public long test(Set<String> set, int size) {
                    set = randomFill(set,size);
                    long start = System.nanoTime();
                    for (String str : set) {
                        // do nothing
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        private static void test(String... args) {
            SetPerformance controller = new SetPerformance();
            controller.containerRegistry().clear();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    public static void main(String[] args) {
        SetPerformance.test("java.util.HashSet", "java.util.LinkedHashSet", "java.util.TreeSet");
    }
}
