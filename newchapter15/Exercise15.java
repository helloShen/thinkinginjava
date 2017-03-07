/**
 * Exercise 15
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise15 {
    private static class TwoTuple<A,B>{
        private A a;
        private B b;
        public TwoTuple(A a,B b){
            this.a = a;
            this.b = b;
        }
        public String toString(){return "["+ a +","+ b +"]";}
    }
    private static <U,V> TwoTuple<U,V> twoTuple(U u, V v) {
        return new TwoTuple(u,v);
    }
    public static void main(String[] args) {
        TwoTuple<String,Integer> two = twoTuple("Hello World", 100);
    }
}
