/**
 * 看看书上的Tester做了什么。作者这个框架太复杂写得不好。
 * 精简了它的display模块。太复杂没必要。
 * 精简了它的TestParam类型。一共才size和loops两个域，没必要用特殊结构体精简参数。
 * Tester的计时职责被重新划分到Test类的test()方法完成。为了让计时更精确，不带入调用方法的时间。
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 包级私有
final class TesterInBook<C> {
    /**
     * 配置成员域
     */
    private static final int[] defaultParams = new int[]{10,5000,100,5000,1000,500,10000,50};
    private int[] paramList = defaultParams; // 参数
    private final C container; // 被测试容器
    private final Map<String,Test<C>> tests; // 测试策略对象注册表
    private final String header; // 标题

    /**
     * 配置函数
     */
    public C initialize(int size) { // 可以测试前配置。目前此功能没有激活。
        return container;
    }
    // 不公开构造器
    // 没有保护性拷贝，因为只是用来自己测试
    private TesterInBook(C container, Map<String,Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        header = container.getClass().getSimpleName();
    }
    // 静态工厂方法入口应该保证：
    //   参数数组至少有一组（2个）参数，而且数组长度为偶数。
    private TesterInBook(C container, Map<String,Test<C>> tests, int[] paramList) {
        this(container,tests);
        assert paramList.length >= 2;
        assert paramList.length % 2 == 0;
        this.paramList = paramList;
    }

    /**
     * 公开静态工厂方法，方便运行测试
     */
    public static <C> void run(C cntnr, Map<String,Test<C>> tests) {
        new TesterInBook<C>(cntnr,tests).timedTest();
    }
    public static <C> void run(C cntnr, Map<String,Test<C>> tests, int[] paramList) throws IllegalArgumentException {
        if (paramList.length < 2) {
            throw new IllegalArgumentException("Need at least 1 pair(test size and loop times) of paramater!");
        }
        if ( (paramList.length % 2) != 0 ) {
            throw new IllegalArgumentException("Parameters should be in pair!");
        }
        new TesterInBook<C>(cntnr,tests,paramList).timedTest();
    }

    /**
     * 实际测试模块。
     * 调用每个Test的test()方法。
     */
     private static final String SIZE_FIELD = "%5d";
     private static final String RESULT_FIELD = "%10.10s: %10d";
     public void timedTest() { // paramList的长度已经检查过
         Formatter f = new Formatter(System.out);
         for (int i = 0; i < paramList.length/2; i++) {
             int size = paramList[i*2];
             int loops = paramList[i*2+1];
             f.format(SIZE_FIELD, size);
             for (Map.Entry<String,Test<C>> test : tests.entrySet()) {
                 C kontainer = initialize(size);
                 f.format(RESULT_FIELD, test.getKey(), eachTest(test.getValue(),kontainer,size,loops));
             }
             f.format("\n");
         }
     }
     // 为了和Test接口匹配
     private long eachTest(Test<C> test, C kontainer, int size, int loops) {
         assert size > 0;
         assert loops > 0;
         int warmup = loops/10; // 预热
         long result = 0;
         for (int i = 0; i < loops; i++) {
             long time = test.test(kontainer, size);
             if (i >= warmup) {
                 result += time;
             }
         }
         return result / (loops-warmup);
     }
}
