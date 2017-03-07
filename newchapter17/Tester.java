/**
 * 测试框架
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

interface Tester<C> {
    long runForName(String name, int testSize, int repeatTimes) throws NoSuchElementException;
    void runAll(int testSize, int repeatTimes);
}
