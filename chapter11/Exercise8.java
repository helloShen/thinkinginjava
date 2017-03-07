/**
 * Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise8 {
    public static class Gerbil {
        private static int count = 0;
        private final int ID = ++count;
        public void hop() {
            System.out.println("Gerbil#" + ID + " is hopping!");
        }
    }
    public static void main(String[] args) {
        List<Gerbil> list = new ArrayList<Gerbil>();
        for(int i = 0; i < 10; i++) {
            list.add(new Gerbil());
        }
        Iterator<Gerbil> ite = list.iterator();
        while (ite.hasNext()) {
            ite.next().hop();
        }
    }
}
