/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

// For a basic sanity check:
public class RandomInputGenerator11 implements Generator<Input11> {
    public Input11 next() { return Input11.randomSelection(); }
}