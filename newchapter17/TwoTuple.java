/**
 * Tuple 通用类。 复合优于继承。
 * 使用继承会让Comparable很难实现。
 * 如果TwoTuple<A,B>实现了Comparable<TwoTuple<A,B>>接口
 * 那么ThreeTuple继承TwoTuple以后，不能再实现Comparable<ThreeTuple<A,B,C>>接口
 *
 * 而且不用继承之后，就不用开放本来不需要的访问权限和可变性限制。
 */
package com.ciaoshen.thinkinjava.newchapter17;

final class TwoTuple<A extends Comparable<? super A>,B extends Comparable<? super B>> implements Comparable<TwoTuple<A,B>> {
    private final A first;
    private final B second;
    public TwoTuple(A a, B b) { first = a; second = b; }
    public A getFirst() { return first; } // 暴露了可变对象引用，打破了不变性
    public B getSecond() { return second; } // 暴露了可变对象引用，打破了不变性
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (! (o instanceof TwoTuple)) { return false; }
        @SuppressWarnings({"unchecked","rawtypes"})
        TwoTuple tuple = (TwoTuple)o;
        return tuple.first.equals(first) && tuple.second.equals(second);
    }
    public int hashCode() {
        int result = 17;
        result = 31 * result + first.hashCode();
        result = 31 * result + second.hashCode();
        return result;
    }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
    public int compareTo(TwoTuple<A,B> tuple) {
        if (tuple == this) { return 0; }
        if (! tuple.first.equals(first)) {
            return tuple.first.compareTo(first);
        }
        return tuple.second.compareTo(second);
    }
}
