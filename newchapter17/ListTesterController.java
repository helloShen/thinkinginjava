/**
 * 使用Tester
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

/**
 * ListTester依赖两组数据：
 *     1. 注册一组针对List接口的Test类
 *     2. 注册一组实现List接口的容器类Class对象
 */
final class ListTesterController extends AbstractTesterController<List<String>> {
    /**
     * 实现primitive方法
     */
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
        tests.put("AddAll", new Test<List<String>>() {
            public long test(List<String> list, int size) {
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    tempList.add(gen.next());
                }
                long start = System.nanoTime();
                list.addAll(tempList);
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
        ListTesterController controller = new ListTesterController();
        controller.containerRegistry().addAll(Arrays.asList(args));
        controller.run();
    }
    public static void main(String[] args) {
        ListTesterController.test("java.util.ArrayList","java.util.LinkedList","java.util.Stack","java.util.Vector");
    }
}
