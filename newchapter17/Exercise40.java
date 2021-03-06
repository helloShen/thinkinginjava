/**
 * Exercise 40
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise40 {
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
    public static void exercise40Part1() {
        int size = 10;
        StringTuple[] tupleArray = stringTupleArray(size);
        List<StringTuple> tupleList = stringTupleList(size);
        System.out.println("Array of StringTuple: ");
        System.out.println("Original order: " + Arrays.toString(tupleArray));
        Arrays.sort(tupleArray); // use Arrays.sort(Object[] a)
        System.out.println("After sort: " + Arrays.toString(tupleArray) + "\n");
        System.out.println("List of StringTuple: ");
        System.out.println("Original order: " + tupleList);
        Collections.sort(tupleList);
        System.out.println("After sort: " + tupleList);
    }
    public static void exercise40Part2() {
        int size = 10;
        StringTuple[] tupleArray = stringTupleArray(size);
        List<StringTuple> tupleList = stringTupleList(size);
        Comparator<StringTuple> comparator = new Comparator<StringTuple>() {
            public int compare(StringTuple tuple1, StringTuple tuple2) {
                return tuple1.compareTo(tuple2);
            }
        };
        StringTuple toSearch = GEN.next();
        Arrays.sort(tupleArray, comparator); // use Arrays.sort(Object[] a)
        System.out.println(Arrays.toString(tupleArray));
        System.out.println(toSearch + "should be at index of: " + Arrays.binarySearch(tupleArray,toSearch,comparator));
        Collections.sort(tupleList,comparator);
        System.out.println(tupleList);
        System.out.println(toSearch + "should be at index of: " + Collections.binarySearch(tupleList,toSearch,comparator));
    }
    public static void main(String[] args) {
        exercise40Part1();
        exercise40Part2();
    }
}
