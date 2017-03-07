/**
 * Exercise 30
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise30 {
    private static final class SortPerformance extends AbstractTesterController<List<Integer>> {
        /**
         * 生成器
         */
        private static final int MAX_VALUE = 10000;
        private static final Random R = new Random();
        /**
         * 实现核心primitive method
         */
        public Map<String,Test<List<Integer>>> testRegistry() {
            Map<String,Test<List<Integer>>> tests = new HashMap<>();
            tests.put("Collections.sort()", new Test<List<Integer>>() {
                public long test(List<Integer> list, int size) {
                    for (int i = 0; i < size; i++) {
                        list.add(R.nextInt(MAX_VALUE));
                    }
                    long start = System.nanoTime();
                    Collections.sort(list);
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        /**
         * 静态快捷方法
         */
        public static void test(String... args) {
            SortPerformance controller = new SortPerformance();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    public static void main(String[] args) {
        SortPerformance.test();
    }
}
