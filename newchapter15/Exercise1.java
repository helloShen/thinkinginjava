/**
 * Exercise 1
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise1 {
    public static class Holder<T> {
        private T item;
        public Holder(T t) {
            item = t;
        }
        public T set(T t) {
            T old = item;
            item = t;
            return old;
        }
        public T get() {
            return item;
        }
    }

    public static void main(String[] args) {
        TypeInfo.ForNameCreator petsCreator = new TypeInfo.ForNameCreator();
        Holder<TypeInfo.Pet> petsHolder = new Holder<>(petsCreator.randomPet());
        int size = 10;
        for (int i = 0; i < size; i++) {
            petsHolder.set(petsCreator.randomPet());
            System.out.println(petsHolder.get());
        }
    }
}
