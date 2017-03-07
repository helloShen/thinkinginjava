/**
 * Exercise 35
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise35 {
    private static class Coffee {
        private static long counter = 0;
        private final long id = counter++;
        public String toString() {
            return getClass().getSimpleName() + " " + id;
        }
    }
    private static class Latte extends Coffee {}
    private static class Mocha extends Coffee {}
    private static class Cappuccino extends Coffee {}
    private static class Americano extends Coffee {}
    private static class Breve extends Coffee {}

    private static class CheckedList {
        @SuppressWarnings({"unchecked","rawtypes"})
        public static void oldStyleMethod(List probablyCapuccino) {
            probablyCapuccino.add(new Mocha());
        }
    }
    public static void main(String[] args) {
        List<Cappuccino> capus = new ArrayList<Cappuccino>();
        CheckedList.oldStyleMethod(capus); //Accepts quietly a mocha
        List<Cappuccino> checkedCappuccino = Collections.checkedList(new ArrayList<Cappuccino>(), Cappuccino.class);
        try {
            CheckedList.oldStyleMethod(checkedCappuccino); //java.lang.ClassCastException
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
