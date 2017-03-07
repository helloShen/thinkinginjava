/**
  *  石头剪刀布
  */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}