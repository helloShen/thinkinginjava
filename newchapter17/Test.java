/**
 * 测试框架
 */
package com.ciaoshen.thinkinjava.newchapter17;

// 无状态对象模拟函数指针（策略模式）
// 适合用匿名内部类的形式初始化
interface Test<C> {
    long test(C container, int times);
}
