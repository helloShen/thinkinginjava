/**
 * Exercise 2
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise2 {
    private static class ThreeElementsHolder<T> {
        private T first;
        private T second;
        private T third;
        public T getFirst() {
            return first;
        }
        public T setFirst(T t) {
            T old = first;
            first = t;
            return old;
        }
        public T getSecond() {
            return second;
        }
        public T setSecond(T t) {
            T old = second;
            second = t;
            return old;
        }
        public T getThird() {
            return third;
        }
        public T setThird(T t) {
            T old = third;
            third = t;
            return old;
        }
        public String toString() {
            return "[First: " + first + "], [Second: " + second + "], [Third: " + third + "]";
        }
    }
    public static void main(String[] args) {
        ThreeElementsHolder<TypeInfo.Pet> threePets = new ThreeElementsHolder<>();
        TypeInfo.ForNameCreator myCreator = new TypeInfo.ForNameCreator();
        threePets.setFirst(myCreator.randomPet());
        threePets.setSecond(myCreator.randomPet());
        threePets.setThird(myCreator.randomPet());
        System.out.println(threePets);
    }
}
