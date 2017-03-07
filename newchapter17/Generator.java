/**
 * Interface Generator
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 无状态对象模拟函数指针（策略模式）
// 适合用匿名内部类的形式初始化
interface Generator<T> {
    public T next();
}
