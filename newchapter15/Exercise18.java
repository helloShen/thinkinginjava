/**
 * Exercise 18
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise18 {
    public static interface Generator<T> {
        public T next();
    }
    public static class Generators {
        public static <T> List<T> fill(List<T> c, Generator<T> g, int size) {
            for (int i = 0; i < size; i++) {
                c.add(g.next());
            }
            return c;
        }
    }
    public static class BigFish {
        private static int count = 0;
        private final int ID = ++count;
        private enum Args {
            NAME("BigFish");
            private String description;
            private Args(String str) {
                description = str;
            }
            public String toString() {
                return description;
            }
        }
        public String toString() {
            return Args.NAME + "#" + ID;
        }
        public static Generator<BigFish> generator() {
            return new Generator<BigFish>() {
                public BigFish next() {
                    return new BigFish();
                }
            };
        }
    }
    public static class SmallFish {
        private static int count = 0;
        private final int ID = ++count;
        private enum Args {
            NAME("SmallFish");
            private String description;
            private Args(String str) {
                description = str;
            }
            public String toString() {
                return description;
            }
        }
        public String toString() {
            return Args.NAME + "#" + ID;
        }
        public static Generator<SmallFish> generator() {
            return new Generator<SmallFish>() {
                public SmallFish next() {
                    return new SmallFish();
                }
            };
        }
    }
    public static void eat(BigFish big, SmallFish small) {
        System.out.println(big + " eats " + small);
    }
    public static void main(String[] args) {
        List<BigFish> bigfishes = Generators.fill(new ArrayList<BigFish>(), BigFish.generator(), 5);
        List<SmallFish> smallfishes = Generators.fill(new ArrayList<SmallFish>(), SmallFish.generator(), 20);
        Random r = new Random();
        for (SmallFish small : smallfishes) {
            eat(bigfishes.get(r.nextInt(bigfishes.size())), small);
        }
    }
}
