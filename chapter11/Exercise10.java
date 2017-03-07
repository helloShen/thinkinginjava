/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise10 {
    public static interface Rodent {
        public void hop();
    }
    public static class Mouse implements Rodent {
        private static String NAME = "Mouse";
        private static int count = 0;
        private int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }
    public static class Gerbil implements Rodent {
        private static String NAME = "Gerbil";
        private static int count = 0;
        private int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }
    public static class Hamster implements Rodent {
        protected static String NAME = "Hamster";
        protected static int count = 0;
        protected int ID = ++count;
        public void hop() {
            System.out.println(NAME + "#" + ID + " is hopping!");
        }
    }

    public static void main(String[] args) {
        List<Rodent> rodents = new ArrayList<Rodent>();
        int rodentsNum = 10;
        for (int i = 0; i < rodentsNum; i++) {
            rodents.add(new Mouse());
            rodents.add(new Gerbil());
            rodents.add(new Hamster());
        }
        Iterator<Rodent> rodentIte = rodents.iterator();
        while (rodentIte.hasNext()) {
            rodentIte.next().hop();
        }
    }
}
