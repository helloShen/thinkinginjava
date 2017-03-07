/**
 * Exercise 6
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise6 {
    public static interface Generator<T> {
        public T next();
        public List<T> createList(int listSize);
    }
    public static class StringGenerator implements Generator<String> {
        private static final Random RAND = new Random();
        private int length = 10;    //number of characters in each string
        public StringGenerator() {}
        public StringGenerator(int len) {
            length = len;
        }
        public List<String> createList(int listSize) {
            List<String> list = new ArrayList<String>();
            for (int i= 0; i < listSize; i++) {
                list.add(next());
            }
            return list;
        }
        public String next() {
            char[] result = new char[length];
            for (int i = 0; i < length; i++) {
                char letter = (char)(((int)'a') + RAND.nextInt(26));    //random a-z
                result[i] = letter;
            }
            return new String(result);
        }
    }
    public static void testUnitNext(int length) {
        StringGenerator gen = new StringGenerator(length);
        System.out.println(gen.next());
    }
    public static void testUnitCreatList(int listSize) {
        StringGenerator gen = new StringGenerator();
        System.out.println(gen.createList(listSize));
    }
    public static void main(String[] args) {
        /**
         * Unit Test
         */
        //int strLength = 7;
        //testUnitNext(strLength);
        //int listSize = 20;
        //testUnitCreatList(listSize);

        /**
         * Exercise 6
         */
        int strLength = 7;
        int initListSize = 20;
        StringGenerator gen = new StringGenerator(strLength);
        List<String> list = gen.createList(initListSize);
        System.out.println("1: " + list);
        String str = gen.next();
        list.add(str); // Automatically resizes
        System.out.println("2: " + list);
        System.out.println("3: " + list.contains(str));
        list.remove(str); // Remove by object
        String second = list.get(2);
        System.out.println("4: " + second + " " + list.indexOf(second));
        String str2 = gen.next();
        System.out.println("5: " + list.indexOf(str2));
        System.out.println("6: " + list.remove(str2));
        // Must be the exact object:
        System.out.println("7: " + list.remove(second));
        System.out.println("8: " + list);
        list.add(3, gen.next()); // Insert at an index
        System.out.println("9: " + list);
        List<String> sub = list.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + list.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + list.containsAll(sub));
        Collections.shuffle(sub, StringGenerator.RAND); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + list.containsAll(sub));
        List<String> copy = new ArrayList<String>(list);
        sub = Arrays.asList(list.get(1), list.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<String>(list); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, gen.next()); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + list.isEmpty());
        list.clear(); // Remove all elements
        System.out.println("19: " + list);
        System.out.println("20: " + list.isEmpty());
        list.addAll(gen.createList(4));
        System.out.println("21: " + list);
        Object[] o = list.toArray();
        System.out.println("22: " + o[3]);
        String[] pa = list.toArray(new String[0]);
        System.out.println("23: " + pa[3]);
    }
}
