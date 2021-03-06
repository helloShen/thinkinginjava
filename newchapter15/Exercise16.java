/**
 * Exercise 16
 */
package com.ciaoshen.thinkinjava.newchapter15;

public class Exercise16 {
    private static class TwoTuple<A,B> {
        public final A first;
        public final B second;
        public TwoTuple(A a, B b) { first = a; second = b; }
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
    private static class ThreeTuple<A,B,C> extends TwoTuple<A,B> {
        public final C third;
        public ThreeTuple(A a, B b, C c) {
            super(a, b);
            third = c;
        }
        public String toString() {
            return "(" + first + ", " + second + ", " + third +")";
        }
    } ///:~
    private static class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C> {
        public final D fourth;
        public FourTuple(A a, B b, C c, D d) {
            super(a, b, c);
            fourth = d;
        }
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
        }
    } ///:~
    private static class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D> {
        public final E fifth;
        public FiveTuple(A a, B b, C c, D d, E e) {
            super(a, b, c, d);
            fifth = e;
        }
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
        }
    }
    private static class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E> {
        public final F sixth;
        public SixTuple(A a, B b, C c, D d, E e, F f) {
            super(a, b, c, d, e);
            sixth = f;
        }
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
        }
    }
    public static class Tuple {
        public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
            return new TwoTuple<A,B>(a, b);
        }
        public static <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
            return new ThreeTuple<A,B,C>(a, b, c);
        }
        public static <A,B,C,D> FourTuple<A,B,C,D> tuple(A a, B b, C c, D d) {
            return new FourTuple<A,B,C,D>(a, b, c, d);
        }
        public static <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e) {
            return new FiveTuple<A,B,C,D,E>(a, b, c, d, e);
        }
        public static <A,B,C,D,E,F> SixTuple<A,B,C,D,E,F> tuple(A a, B b, C c, D d, E e, F f) {
            return new SixTuple<A,B,C,D,E,F>(a, b, c, d, e, f);
        }
    }
    private static class Amphibian {}
    private static class Vehicle {}
    public static class TupleTest2 {
        static TwoTuple<String,Integer> f() {
            return Tuple.tuple("hi", 47);
        }
        @SuppressWarnings("rawtypes")
        static TwoTuple f2() { return Tuple.tuple("hi", 47); }
        static ThreeTuple<Amphibian,String,Integer> g() {
            return Tuple.tuple(new Amphibian(), "hi", 47);
        }
        static FourTuple<Vehicle,Amphibian,String,Integer> h() {
            return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47);
        }
        static FiveTuple<Vehicle,Amphibian,String,Integer,Double> k() {
            return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
        }
        static SixTuple<Vehicle,Amphibian,String,Integer,Double,Boolean> l() {
            return Tuple.tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1, true);
        }
    }
    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = TupleTest2.f();
        System.out.println(ttsi);
        System.out.println(TupleTest2.f2());
        System.out.println(TupleTest2.g());
        System.out.println(TupleTest2.h());
        System.out.println(TupleTest2.k());
        System.out.println(TupleTest2.l());
    }
}
