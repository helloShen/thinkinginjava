/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public interface SmallEventFactory<T>{
    public T create(long delayTime);
}