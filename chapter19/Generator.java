/**
 *  Generator 接口
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public interface Generator<T>{
    public T next();
}