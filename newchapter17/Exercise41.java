/**
 * Exercise 41
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise41 {
    private static final class StringTuple implements Comparable<StringTuple> {
        private final String first;
        private final String second;
        private StringTuple(String str1, String str2) {
            first = str1;
            second = str2;
        }
        public int compareTo(StringTuple target) {
            return first.compareTo(target.first);
        }
        public boolean equals(Object o) {
            if (o == this) { return true; }
            if (! (o instanceof StringTuple)) {
                return false;
            }
            StringTuple target = (StringTuple)o;
            return target.first.equals(first);
        }
        public int hashCode() { // field second is not involved
            int result = 17;
            result = result * 31 + first.hashCode();
            return result;
        }
        public String toString() {
            return "T[" + first + "," + second + "]";
        }
        private static final int DEFAULT_LENGTH= 2;
        public static Generator<StringTuple> generator() {
            return generator(DEFAULT_LENGTH);
        }
        public static Generator<StringTuple> generator(int strLength) {
            return new Generator<StringTuple>() {
                private Generator<String> gen = StringGenerator.newInstance(strLength);
                public StringTuple next() {
                    return new StringTuple(gen.next(),gen.next());
                }
            };
        }
    }
    private static final Generator<StringTuple> GEN = StringTuple.generator();
    private static StringTuple[] stringTupleArray(int size) {
        StringTuple[] array = new StringTuple[size];
        for (int i = 0; i < size; i++) {
            array[i] = GEN.next();
        }
        return array;
    }
    private static List<StringTuple> stringTupleList(int size) {
        List<StringTuple> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(GEN.next());
        }
        return list;
    }
    public static void exercise41Part1() {
        int size = 10;
        Set<StringTuple> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            set.add(GEN.next());
        }
        Iterator<StringTuple> ite = set.iterator();
        StringTuple firstTuple = ite.next(); // get the first element
        System.out.println("Set: " + set + "\n" + "contains element: " + firstTuple + "? " + set.contains(firstTuple));
    }
    public static void exercise41Part2() {
        int size = 1000;
        Map<StringTuple,Integer> tupleDic = new HashMap<>(); // count the occurrence of each StringTuple
        StringTuple tempTuple = null;
        for (int i = 0; i < size; i++) {
            tempTuple = GEN.next();
            if (tupleDic.containsKey(tempTuple)) {
                tupleDic.put(tempTuple,tupleDic.get(tempTuple)+1);
            } else {
                tupleDic.put(tempTuple,1);
            }
        }
        System.out.println(tupleDic);
    }
    public static void main(String[] args) {
        exercise41Part1();
        exercise41Part2();
    }
}
