/**
 * Exercise 29
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise29 {
     private static final class ListPerformance extends AbstractTesterController<List<String>> {
         /**
          * 数据生成器
          */
         private static final Generator<String> GEN = StringGenerator.newInstance();
         private static List<String> randomFill(List<String> list, int size) {
             for (int i = 0; i < size; i++) {
                 list.add(GEN.next());
             }
             return list;
         }
         /**
          * 实现关键primitive方法
          */
         public Map<String,Test<List<String>>> testRegistry() {
             Map<String,Test<List<String>>> tests = new LinkedHashMap<String,Test<List<String>>>();
             tests.put("Add", new Test<List<String>>() {
                 public long test(List<String> list, int size) {
                     String str = GEN.next();
                     long start = System.nanoTime();
                     for (int i = 0; i < size; i++) {
                         list.add(str);
                     }
                     long end = System.nanoTime();
                     return end - start;
                 }
             });
             tests.put("AddAll", new Test<List<String>>() {
                 public long test(List<String> list, int size) {
                     List<String> tempList = randomFill(new ArrayList<String>(), size);
                     long start = System.nanoTime();
                     list.addAll(tempList);
                     long end = System.nanoTime();
                     return end - start;
                 }
             });
             tests.put("Get", new Test<List<String>>() {
                 public long test(List<String> list, int size) {
                     list = randomFill(list,size);
                     long start = System.nanoTime();
                     String itg = "";
                     for (int i = 0; i < size; i++) {
                         itg = list.get(i);
                     }
                     long end = System.nanoTime();
                     return end - start;
                 }
             });
             tests.put("Set", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    list = randomFill(list,size);
                    String str = GEN.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.set(i, str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
             });
             return tests;
         }
         /**
          * 快捷静态方法：可变长参数设置需要测试的容器
          */
         public static void test(String... args) {
             ListPerformance controller = new ListPerformance();
             controller.containerRegistry().addAll(Arrays.asList(args));
             controller.run();
         }
     }
     public static void main(String[] args) {
         ListPerformance.test("java.util.ArrayList","java.util.LinkedList","java.util.Stack","java.util.Vector");
     }
 }
