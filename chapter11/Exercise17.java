/**
 * Exercise 17
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise17 {
    public static class Gerbil {
        private static int count = 0;
        private final int id = ++count;
        private final String name;
        public Gerbil(String name) {
            this.name = name;
        }
        public void hop() {
            System.out.println("Gerbil#" + id + ": " + name + ", is hopping!");
        }
        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        Gerbil fuzzy = new Gerbil("Fuzzy");
        Gerbil spot = new Gerbil("Spot");
        Gerbil piupiu = new Gerbil("PiuPiu");
        Map<String, Gerbil> gerbilMap = new HashMap<String, Gerbil>();
        gerbilMap.put(fuzzy.getName(),fuzzy);
        gerbilMap.put(spot.getName(),spot);
        gerbilMap.put(piupiu.getName(),piupiu);
        Iterator<Map.Entry<String, Gerbil>> ite = gerbilMap.entrySet().iterator();
        while (ite.hasNext()) {
            Map.Entry<String, Gerbil> entry = ite.next();
            System.out.print("(Gerbil: " + entry.getKey() + ")    >>>     ");
            entry.getValue().hop();
        }
    }
}
