/**
 * Exercise 28
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise28 {
    public static void main(String[] args) {
        ThreeTuple<String,Integer,Double> ronald = Tuple.tuple("Hello Ronald",100,111.111);
        ThreeTuple<String,Integer,Double> shen = Tuple.tuple("Hello Shen",200,222.222);
        List<ThreeTuple<String,Integer,Double>> list = new ArrayList<>();
        list.add(ronald);
        list.add(shen);
        Collections.sort(list);
        System.out.println(list);
    }
}
