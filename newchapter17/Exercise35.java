/**
 * Exercise 35
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise35 {
    static final class MapPerformance extends AbstractTesterController<Map<String,String>> {
        private final Generator<String> gen = StringGenerator.newInstance();
        private Map<String,String> randomFill(Map<String,String> map, int size) {
            for (int i = 0; i < size; i++) {
                map.put(gen.next(),gen.next());
            }
            return map;
        }
        public Map<String,Test<Map<String,String>>> testRegistry() {
            Map<String,Test<Map<String,String>>> tests = new HashMap<>();
            tests.put("Put", new Test<Map<String,String>>() {
                public long test(Map<String,String> map, int size) {
                    String str = gen.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        map.put(str,str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Get", new Test<Map<String,String>>() {
                public long test(Map<String,String> map, int size) {
                    map = randomFill(map,size);
                    String str = gen.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        map.get(str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Iterate", new Test<Map<String,String>>() {
                public long test(Map<String,String> map, int size) {
                    map = randomFill(map,size);
                    long start = System.nanoTime();
                    for (Map.Entry<String,String> entry : map.entrySet()) {
                        // do nothing
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        static void test(String... args) {
            MapPerformance controller = new MapPerformance();
            controller.containerRegistry().clear();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,25,1000,10,10000,1});
        }
    }
    public static void main(String[] args) {
        MapPerformance.test("java.util.HashMap", "java.util.LinkedHashMap", "com.ciaoshen.thinkinjava.newchapter17.Exercise17$SlowMap");
    }
}
