/**
 * Tuple 通用类
 */
package com.ciaoshen.thinkinjava.newchapter17;

class ThreeTuple<A extends Comparable<? super A>,B extends Comparable<? super B>,C extends Comparable<? super C>> implements Comparable<ThreeTuple<A,B,C>> {
    private final TwoTuple<A,B> firstTwo;
    private final C third;
    public ThreeTuple(A a, B b, C c) {
        firstTwo = new TwoTuple<>(a, b);
        third = c;
    }
    public A getFirst() { return firstTwo.getFirst(); }
    public B getSecond() { return firstTwo.getSecond(); }
    public C getThird() { return third; }
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (! (o instanceof ThreeTuple)) { return false; }
        @SuppressWarnings({"unchecked","rawtypes"})
        ThreeTuple tuple = (ThreeTuple)o;
        return tuple.firstTwo.equals(firstTwo) && tuple.third.equals(third);
    }
    public int hashCode() {
        int result = firstTwo.hashCode();
        result = 31 * result + third.hashCode();
        return result;
    }
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ", " + third +")";
    }
    public int compareTo(ThreeTuple<A,B,C> tuple) {
        if (tuple == this) { return 0; }
        if (! tuple.getFirst().equals(getFirst())) {
            return tuple.getFirst().compareTo(getFirst());
        }
        if (! tuple.getSecond().equals(getSecond())) {
            return tuple.getSecond().compareTo(getSecond());
        }
        return tuple.third.compareTo(third);
    }
}
