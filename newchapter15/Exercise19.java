/**
 * Exercise 19
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise19 {
    private static interface Generator<T> {
        public T next();
    }
    private static class Generators {
        public static <T> List<T> fill(List<T> c, Generator<T> g, int size) {
            for (int i = 0; i < size; i++) {
                c.add(g.next());
            }
            return c;
        }
    }
    private static class Product {
        private static long count = 0;
        private final long id = ++count;
        private double price;
        public Product(double price){
            this.price = price;
            System.out.println(this);
        }
        public String toString() {
            return "Product No."+id + " >>> " + "price: $" + price;
        }
        public static Generator<Product> generator = new Generator<Product>() {
            private Random rand = new Random();
            public Product next() {
                return new Product( Math.round(rand.nextDouble() * 1000.0) + 0.99);
            }
        };
    }
    private static class Container extends ArrayList<Product>{
        private static final long serialVersionUID=0;
        private static final int MAX_PRO=1000;
        public Container(int numP){
            if (numP > MAX_PRO) {
                throw new IllegalArgumentException("Container can have maximum 1000 products!");
            }
            Generators.fill(this, Product.generator ,Math.min(MAX_PRO,numP));
        }
    }
    public static class Deck extends ArrayList<Container>{
        private static final long serialVersionUID=0;
        private static final int MAX_CON = 10000;
        private Deck(final int numC, final int numP){
            if (numC > MAX_CON) {
                throw new IllegalArgumentException("Deck can have maximum 10000 Containers!");
            }
            Generators.fill(this, new Generator<Container>() {
                public Container next() {
                    return new Container(numP);
                }
            }, numC);
        }
    }
    public static class CargoShip extends ArrayList<Deck> {
        private static final long serialVersionUID=0;
        private static final int MAX_DECK = 20;
        private CargoShip(final int numD, final int numC, final int numP) {
            if (numD > MAX_DECK) {
                throw new IllegalArgumentException("Cargo ship can have maximum 20 decks!");
            }
            Generators.fill(this, new Generator<Deck>() {
                public Deck next() {
                    return new Deck(numC, numP);
                }
            }, numD);
        }
    }
    public static void main(String[] args) {
        new CargoShip(5, 5, 5);
    }
}
