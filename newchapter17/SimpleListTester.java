/**
 * 框架测试
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 因为使用匿名内部类的形式初始化Tester，无法保留进入Tester内部对象的引用。
// 所以尽管Tester和TesterBuilder都没有保护性拷贝，我们的SimplemListTester最终还是不可变的。
final class SimpleListTester extends GenericTester<List<String>> {
    public SimpleListTester(TesterBuilder<List<String>> builder) {
        super(builder);
    }
    public static void main(String[] args) {
        TesterBuilder<List<String>> testerBuilder = new SimpleListTester.TesterBuilder<List<String>>(new Generator<List<String>>() {
            public List<String> next() {
                return new ArrayList<String>();
            }
        });
        testerBuilder.addTest("Add", new Test<List<String>>() {
            public long test(List<String> list, int times) {
                assert list.isEmpty();
                Generator<String> gen = StringGenerator.newInstance();
                String str = gen.next();
                long start = System.nanoTime();
                for (int i = 0; i < times; i++) {
                    list.add(str);
                }
                long end = System.nanoTime();
                assert list.size() == times;
                return end - start;
            }
        });
        testerBuilder.addTest("AddAll", new Test<List<String>>() {
            public long test(List<String> list, int times) {
                assert list.isEmpty();
                List<String> tempList = new ArrayList<>();
                Generator<String> gen = StringGenerator.newInstance();
                for (int i = 0; i < times; i++) {
                    tempList.add(gen.next());
                }
                long start = System.nanoTime();
                list.addAll(tempList);
                long end = System.nanoTime();
                assert list.size() == times;
                return end - start;
            }
        });
        Tester<List<String>> myTester = testerBuilder.build();
        myTester.runAll(10000,10);
    }
}
