/**
 * Exercise 1
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise1 {
    public static class Gerbil {
        private static int count = 0;
        private final int id = ++count;
        public void hop() {
            System.out.println("Gerbil#" + id + " is hopping!");
        }
    }
    public static void main(String[] args) {
        List<Exercise1.Gerbil> list = new ArrayList<Exercise1.Gerbil>();
        for(int i = 0; i < 10; i++) {
            list.add(new Exercise1.Gerbil());
        }
        for(Exercise1.Gerbil gerbil : list) {
            gerbil.hop();
        }
    }
}
