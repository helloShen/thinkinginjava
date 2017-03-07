/**
 * Tuple 通用类。可以考虑成为API。
 */
package com.ciaoshen.thinkinjava.newchapter17;

final class Tuple {
    public static <A extends Comparable<? super A>,B extends Comparable<? super B>> TwoTuple<A,B> tuple(A a, B b) {
        return new TwoTuple<A,B>(a, b);
    }
    public static <A extends Comparable<? super A>,B extends Comparable<? super B>,C extends Comparable<? super C>> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
        return new ThreeTuple<A,B,C>(a, b, c);
    }
}
