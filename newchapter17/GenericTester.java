/**
 * 测试框架：主要利用了Strategy模式和Builder模式，把测试对象某行为的执行效率的辅助平台和测试逻辑剥离开来。
 *          用户只需要把注意力集中在测试逻辑单元的设计上，而把程序性的运行，计时工作交给框架来负责。
 * 测试框架的骨架是Tester<C>和Test<C>两个接口提供的服务，即：
 *     首先，Test是一个无状态对象，用来模拟函数指针（策略模式）。它的策略由它的 test() 方法定义，
 *         1. Test#test(C c, int n)：执行 C 类型对象的一系列方法 n 次，并返回总时间开销。
 *     然后，Tester是一个负责执行Test策略的工具，它内部维护着一个由一组策略和它们的名字组成的映射Map，
 *         2. Tester#runForName(String name, int size, int repeat)：根据提供的名称，从映射中找出相应的策略Test，
 *             然后执行规模为size的Test#test()测试，每次都得出耗时，然后重复repeat遍，最后计算出单次实验的平均时间。
 *         3. Tester#runAll(int size, int repeat) 对映射表中的每一个Test策略都执行规模为size * repeat的测试。
 *
 * 框架的核心组件：
 *     1. Test.java
 *     2. Tester.java
 *     3. Builder.java
 *     4. Generator.java
 *     4. GenericTester.java
 *     5. StringGenerator.java
 *     6. SimpleListTester.java
 *
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 实现这个泛型类的饿子类会是不可变类。
// 所有字段都是private final。也没有提供getter或setter访问方法。没有暴露成员域引用，尤其是可变成员域Map的引用。
// 但其实是有隐患的：因为构造器没有进行保护性拷贝，一旦用户保留了参与构造对象的引用，我们Tester还是有可能受到攻击。
// 所幸，我们用TesterBuilder构造Tester的时候，无论是Generator还是Test都是匿名内部类的形式。因此没有暴露引用。
class GenericTester<C> implements Tester<C> {
    private final Map<String,Test<C>> TESTS;
    private final Generator<C> GEN;
    public GenericTester(TesterBuilder<C> builder) {
        GEN = builder.GEN_TO_BUILD;
        TESTS = Collections.unmodifiableMap(builder.TESTS_TO_BUILD);
    }
    public long runForName(String name, int testSize, int repeat) throws NoSuchElementException {
        Test<C> test = TESTS.get(name);
        if (test == null) { throw new NoSuchElementException("No test called " + name + "!"); }
        long time = 0l;
        for (int i = 0; i < repeat; i++) {
            time = time + test.test(GEN.next(), testSize);
        }
        return time/repeat;
    }
    public void runAll(int testSize, int repeat) {
        Formatter f = new Formatter(System.out);
        for (Map.Entry<String,Test<C>> entry : TESTS.entrySet()) {
            long time = runForName(entry.getKey(), testSize, repeat);
            f.format("%15.15s %10d %15d \n", entry.getKey(), testSize, time);
        }
    }
    // 外围类GenericTester的配套Builder，当然是可变的。
    // 使用Builder模式，首先是想保护Tester，使其保持不可变性。
    // 其次，Tester因为内部可以持有很多个Test对象，构造过程比较复杂。Builder让客户端代码更清晰。
    static class TesterBuilder<T> implements Builder<Tester<T>> {
        private final Generator<T> GEN_TO_BUILD;
        private final Map<String,Test<T>> TESTS_TO_BUILD = new HashMap<>();
        public TesterBuilder(Generator<T> gen) { GEN_TO_BUILD = gen; }
        public void addTest(String name, Test<T> test) {
            TESTS_TO_BUILD.put(name, test);
        }
        public Tester<T> build() {
            return new GenericTester<T>(this);
        }
    }
}
