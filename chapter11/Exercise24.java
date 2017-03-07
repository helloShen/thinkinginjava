/**
 * Exercise 24
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise24 {
    public static class Dog {
        private static int count = 0;
        private final int ID = ++count;
        private final String NAME;
        public Dog(String name) {
            NAME = name;
        }
        public String toString() {
            return "Dog#" + ID + " called " + NAME;
        }
    }
    public static String randomName(int length) {
        Random rand = new Random();
        char[] name = new char[length];
        for (int i = 0; i < length; i++) {
            name[i] = (char)((int)'a' + rand.nextInt(26));
        }
        return new String(name);
    }
    public static void main(String[] args) {
        Map<String,Dog> dogMap = new LinkedHashMap<String,Dog>();
        int mapSize = 20;
        int nameLength =4;
        for (int i = 0; i < mapSize; i++) {
            String dogName = randomName(nameLength);
            dogMap.put(dogName,new Dog(dogName));
        }
        //System.out.println(dogMap);
        Set<Map.Entry<String,Dog>> dogSet = dogMap.entrySet();
        List<Map.Entry<String,Dog>> dogList = new ArrayList<Map.Entry<String,Dog>>();
        dogList.addAll(dogSet);
        //System.out.println(dogList);
        Collections.sort(dogList, new Comparator<Map.Entry<String,Dog>>() {
            public int compare(Map.Entry<String,Dog> entry1, Map.Entry<String,Dog> entry2) {
                return String.CASE_INSENSITIVE_ORDER.compare(entry1.getKey(),entry2.getKey());
            }
        });
        //System.out.println(dogList);
        Map<String,Dog> sortedDogMap = new LinkedHashMap<String,Dog>();
        for (Map.Entry<String,Dog> entry : dogList) {
            sortedDogMap.put(entry.getKey(),entry.getValue());
        }
        System.out.println(sortedDogMap);
    }
}
