/**
 *  Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

// For a basic sanity check:
public class RandomInputGenerator implements Generator<Input> {
    public Input next() { return Input.randomSelection(); }
}