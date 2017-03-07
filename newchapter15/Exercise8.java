/**
 * Exercise 8
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise8 {
    private static interface Generator<T> {
        public T next();
    }
    public static interface StoryCharacters extends Generator<StoryCharacters> {}
    public enum GoodGuys implements StoryCharacters {
        Jack_Nicholson, Ralph_Fiennes, Daniel_Day_Lewis, Robert_De_Niro, Al_Pacino, Dustin_Hoffman, Tom_Hanks;
        private final Random r = new Random();
        public StoryCharacters next() {
            return values()[r.nextInt(values().length)];
        }
    }
    public enum BadGuys implements StoryCharacters {
        Brad_Pitt, Marlon_Brando, Jeremy_Irons, Denzel_Washington, Gene_Hackman, Jeff_Bridges, Tim_Robbins, Henry_Fonda;
        private final Random r = new Random();
        public StoryCharacters next() {
            return values()[r.nextInt(values().length)];
        }
    }
    public static void main(String[] args) {
        int size = 5;
        System.out.println("Show me " + size + " Good Guys: ");
        for (int i = 0; i < size; i++) {
            System.out.println(GoodGuys.Jack_Nicholson.next());
        }
        System.out.println("Show me " + size + " Bad Guys: ");
        for ( int i = 0; i < size; i++) {
            System.out.println(BadGuys.Brad_Pitt.next());
        }
    }
}
