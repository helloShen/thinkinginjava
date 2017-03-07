/**
 * Exercise 5
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise5 {
    private static final Random RAND = new Random();
    private static final int MAX = 1000;
    public static List<Integer> getIntegerArrayList(int size) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(RAND.nextInt(MAX));
        }
        return list;
    }
    public static Integer random() {
        return RAND.nextInt(MAX);
    }
    public static void main(String[] args) {
        List<Integer> intList= getIntegerArrayList(7);
        System.out.println("1: " + intList);
        Integer oneInt = random();
        intList.add(oneInt); // Automatically resizes
        System.out.println("2: " + intList);
        System.out.println("3: " + intList.contains(oneInt));
        intList.remove(oneInt); // Remove by object
        Integer p = intList.get(2);
        System.out.println("4: " + p + " " + intList.indexOf(p));
        Integer aNewInt = random();
        System.out.println("5: " + intList.indexOf(aNewInt));
        System.out.println("6: " + intList.remove(aNewInt));
        // Must be the exact object:
        System.out.println("7: " + intList.remove(p));
        System.out.println("8: " + intList);
        intList.add(3, random()); // Insert at an index
        System.out.println("9: " + intList);
        List<Integer> sub = intList.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + intList.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + intList.containsAll(sub));
        Collections.shuffle(sub, RAND); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + intList.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(intList);
        sub = Arrays.asList(intList.get(1), intList.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(intList); // Get a fresh copy
        copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, random()); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + intList.isEmpty());
        intList.clear(); // Remove all elements
        System.out.println("19: " + intList);
        System.out.println("20: " + intList.isEmpty());
        intList.addAll(getIntegerArrayList(4));
        System.out.println("21: " + intList);
        Object[] o = intList.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = intList.toArray(new Integer[0]);
        System.out.println("23: " + pa[3]);
    }
}
