/**
 *  Generator接口
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public interface Generator<T>{
    public T next();
}