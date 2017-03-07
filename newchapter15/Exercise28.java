/**
 * Exercise 28
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise28 {
    private static class Generic1<T> {
        private T item;
        public Generic1(T t) {
            item = t;
        }
        public void set(T t) {
            item = t;
            System.out.println("Set " + item);
        }
    }
    private static class Generic2<T> {
        private T item;
        public Generic2(T t) {
            item = t;
        }
        public T get() {
            System.out.println("Get " + item);
            return item;
        }
    }
    private static <E> void method1(Generic1<? super E> g, E e) {
        g.set(e);
    }
    private static <E> E method2(Generic2<? extends E> g) {
        return g.get();
    }
    public static void main(String[] args) {
        TypeInfo.PetCreator creator = new TypeInfo.ForNameCreator();
        method1(new Generic1<Object>(creator.randomPet()), creator.randomPet());
        method2(new Generic2<TypeInfo.Pet>(creator.randomPet()));
    }
}
