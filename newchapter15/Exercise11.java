/**
 * Exercise 11
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise11 {
    private static class TwoTuple<U,V> {
        private U u;
        private V v;
        public TwoTuple(U inU, V inV) {
            u = inU;
            v = inV;
        }
        public String toString() {
            return "Two Tuple: \n"
                    + "\t " + u.getClass().getSimpleName() + ":\t" + u
                    + "\t " + v.getClass().getSimpleName() + ":\t" + v;
        }
    }
    private static class ThreeTuple<U,V,W> {
        private U u;
        private V v;
        private W w;
        public ThreeTuple(U inU, V inV, W inW) {
            u = inU;
            v = inV;
            w = inW;
        }
        public String toString() {
            return "Three Tuple: \n"
                    + "\t " + u.getClass().getSimpleName() + ":\t" + u
                    + "\t " + v.getClass().getSimpleName() + ":\t" + v
                    + "\t " + w.getClass().getSimpleName() + ":\t" + w;
        }
    }
    public static class New {
        public static <U,V> TwoTuple<U,V> twoTuple(U u,V v) {
            return new TwoTuple<U,V>(u,v);
        }
        public static <U,V,W> ThreeTuple<U,V,W> threeTuple(U u,V v,W w) {
            return new ThreeTuple<U,V,W>(u,v,w);
        }
    }
    public static void main(String[] args) {
        System.out.println(New.twoTuple("Hello World", 100));
        System.out.println(New.threeTuple("Hello World", 100, true));
    }
}
