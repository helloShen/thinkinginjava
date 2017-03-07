/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise13 {
    private static interface Generator<T> {
        public T next();
    }
    private static class Generators {
        public static <T> List<T> fill(List<T> list, Generator<T> gen, int size) {
            for (int i = 0; i < size; i++) {
                list.add(gen.next());
            }
            return list;
        }
        public static <T> LinkedList<T> fill(LinkedList<T> list, Generator<T> gen, int size) {
            for (int i = 0; i < size*2; i++) {
                list.add(gen.next());
            }
            return list;
        }
    }
    public static void main(String[] args) {
        System.out.println("List: " + Generators.fill(new ArrayList<String>(), new Generator<String>() {
            public String next(){
                Random r = new Random();
                return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")[r.nextInt(26)];
            }
        }, 10));
        System.out.println("LinkedList: " + Generators.fill(new LinkedList<String>(), new Generator<String>() {
            public String next(){
                Random r = new Random();
                return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")[r.nextInt(26)];
            }
        }, 10));
    }
}
