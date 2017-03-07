/**
 * Exercise 41
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;
import java.lang.reflect.*;
import static com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak.*;

public class Exercise41 {
    private static interface Addable<T> {
        public void add(T t);
    }
    private static interface Generator<T> {
        public T next();
    }
    private static class Filler {
        private static <T> void fill(Addable<T> target, Class<? extends T> klass, int size) {
            for ( int i = 0; i < size; i++ ) {
                try {
                    target.add(klass.newInstance());
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        private static <T> void fill(Addable<T> target, Generator<? extends T> gen, int size) {
            for ( int i = 0; i < size; i++ ) {
                target.add(gen.next());
            }
        }
    }
    private static class AddableCollection<T> implements Addable<T>, Iterable<T> {
        private Collection<T> collect;
        public AddableCollection(Collection<T> c) {
            collect = c;
        }
        public void add(T t) {
            collect.add(t);
        }
        public Iterator<T> iterator() {
            return collect.iterator();
        }
    }
    private static class AddableQueue<T> implements Addable<T>, Iterable<T> {
        private Queue<T> queue;
        public AddableQueue(Queue<T> q) {
            queue = q;
        }
        public void add(T t) {
            queue.offer(t);
        }
        public Iterator<T> iterator() {
            return queue.iterator();
        }
    }
    private static class Adapter {
        private static <T> AddableCollection<T> addableCollection(Collection<T> c) {
            return new AddableCollection<T>(c);
        }
        private static <T> AddableQueue<T> addableQueue(Queue<T> q) {
            return new AddableQueue<T>(q);
        }
    }
    public static void main(String[] args) {
        ForNameCreator petsCreator = new ForNameCreator();
        int productSize = 3;
        List<Pet> petsList = petsCreator.arrayList(productSize);
        Filler.fill(new AddableCollection<Pet>(petsList), Pet.class, productSize);
        Filler.fill(Adapter.addableCollection(petsList), new Generator<Pet>() { // 匿名内部类创建一个小闭包
            public Pet next() {
                return petsCreator.randomPet();
            }
        } , productSize);
        for(Pet p: petsList) {
            System.out.println(p);
        }
        System.out.println("----------------------");
        AddableQueue<Pet> petsQueue = Adapter.addableQueue(new LinkedList<Pet>());
        Filler.fill(petsQueue, Dog.class, productSize);
        Filler.fill(petsQueue, Cat.class, productSize);
        for(Pet p: petsQueue) {
            System.out.println(p);
        }
    }
}
