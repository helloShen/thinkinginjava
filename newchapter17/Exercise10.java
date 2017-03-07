/**
 * Exercise 10
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise10 {
    // bounds of type-variable E is: <E extends Comparable<? super E>>
    public static class LinkedSortedSet<E extends Comparable<? super E>> extends AbstractSet<E> implements SortedSet<E> {
        private LinkedList<E> data = new LinkedList<E>();
        private Comparator<? super E> comparator = null;
        public LinkedSortedSet() {}
        public LinkedSortedSet(List<? extends E> list) {
            addAll(list);
        }
        public LinkedSortedSet(Comparator<? super E> c) {
            comparator = c;
        }
        public LinkedSortedSet(List<? extends E> list, Comparator<? super E> c) {
            comparator = c;
            addAll(list);
        }

        /**
         * implements Set interface
         */
        public Iterator<E> iterator() { // abstract, must implement
            return data.iterator();
        }
        public int size() { // abstract, mush implement
            return data.size();
        }
        public boolean equals(Object o) { // take order into account
            if (o == this) {
                return true;
            }
            if (!(o instanceof Collection)) {
                return false;
            }
            @SuppressWarnings("unchecked")
            Collection<E> anotherSet = (Collection<E>)o;
            if (anotherSet.size() != size()) {
                return false;
            }
            return containsAll(anotherSet);
        }
        public int hashCode() { // take order into account
            int code = 31;
            int index = 1;
            for (E ele : this) {
                code = code + ele.hashCode()*(index++);
            }
            return code;
        }

        public boolean contains(Object o) { // more efficiently
            boolean result = false;
            @SuppressWarnings("unchecked")
            E e = (E)o; // ClassCastException
            if (comparator != null) {
                for (E ele : this) {
                    if (comparator.compare(e,ele) > 0) { // ele小于e，continue
                        continue;
                    }
                    if (comparator.compare(e,ele) == 0) { // ele等于e, true, break
                        result = true;
                        break;
                    }
                    if (comparator.compare(e,ele) < 0) { // ele大于e, break
                        break;
                    }
                }
            } else {
                for (E ele : this) {
                    if (e.compareTo(ele) > 0) {
                        continue;
                    }
                    if (e.compareTo(ele) == 0) { // ele等于e, true, break
                        result = true;
                        break;
                    }
                    if (e.compareTo(ele) < 0) { // ele大于e, break
                        break;
                    }
                }
            }
            return result;
        }

        /**
         * modification realized based on LinkedList
         */
        public boolean add(E e) { // maintains order with insertion
            boolean result = data.add(e);
            if (result) {
                if (comparator != null) {
                    data.sort(comparator);
                } else {
                    Collections.sort(data); // must be <E extends Comparable<? super E>>
                }
            }
            return result;
        }
        public boolean addAll(Collection<? extends E> c) {
            boolean result = data.addAll(c);
            if (result) {
                if (comparator != null) {
                    data.sort(comparator);
                } else {
                    Collections.sort(data); // must be <E extends Comparable<? super E>>
                }
            }
            return result;
        }
        public void clear() {
            data.clear();
        }
        public boolean remove(Object o) {
            return data.remove(o);
        }
        public boolean removeAll(Collection<?> c) {
            return data.removeAll(c);
        }
        public boolean retainAll(Collection<?> c) {
            return data.retainAll(c);
        }

        /**
         * implements SortedSet interface
         */
        public Comparator<? super E> comparator() {
            return comparator;
        }
        public E first() {
            return data.getFirst();
        }
        public E last() {
            return data.getLast();
        }
        public SortedSet<E> headSet(E toElement) { // return the copy but not the view
            if (! contains(toElement)) {
                return null;
            }
            return subSet(first(),toElement);
        }
        public SortedSet<E> tailSet(E fromElement) { // return the copy but not the view
            if (! contains(fromElement)) {
                return null;
            }
            return subSet(fromElement,last());
        }
        public SortedSet<E> subSet(E fromElement, E toElement) { // return the copy but not the view
            if (! contains(fromElement) || ! contains(toElement)) {
                return null;
            }
            int fromIndex = data.indexOf(fromElement);
            int toIndex = data.indexOf(toElement);
            List<E> sublist = data.subList(fromIndex,toIndex);
            return new LinkedSortedSet<E>(sublist,comparator);
        }
    }
    private static class TestUnit {
        private static int listSize = 10;
        private static Random r = new Random();
        private static List<String> data = randomStringList(listSize); // original list not sorted
        private static LinkedSortedSet<String> mySet1; // test these two list
        private static LinkedSortedSet<String> mySet2; // test these two list
        // Initialize the lists for test
        private static void initWithComparator() {
            mySet1 = new LinkedSortedSet<>(data, String.CASE_INSENSITIVE_ORDER);
            mySet2 = new LinkedSortedSet<>(data, String.CASE_INSENSITIVE_ORDER);
        }
        private static void initWithoutComparator() {
            mySet1 = new LinkedSortedSet<>(data);
            mySet2 = new LinkedSortedSet<>(data);
        }
        private static List<String> randomStringList(int size) {
            Generator<String> strGen = new RandomGenerator.String();
            List<String> data = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                data.add(strGen.next());
            }
            return data;
        }
        private static void test() {
            // constructor, iterator, size, contains, containsAll, equals
            System.out.println("Data Source: " + data);
            System.out.println("My set 1: " + mySet1 + " Size: " + mySet1.size());
            System.out.println("My set 2: " + mySet2 + " Size: " + mySet2.size());
            System.out.println("My set 1 contains " + mySet1.first() + " : " + mySet1.contains(mySet1.first()));
            System.out.println("My set 1 contains \" hello \": " + mySet1.contains("hello"));
            System.out.println("Set 1 equals Set 2 ? " + mySet1.equals(mySet2));
            SortedSet<String> subset;
            tryManyTimes:
            while (true) { // possible to fail, so we try sevral times
                try {
                    subset = mySet1.subSet(data.get(r.nextInt(listSize)),data.get(r.nextInt(listSize)));
                    break tryManyTimes;
                } catch(IllegalArgumentException e) {
                    continue tryManyTimes;
                }
            }
            SortedSet<String> subset2 = mySet1.headSet(data.get(listSize/3*2));
            System.out.println("SubSet of Set1: " + subset);
            System.out.println("SubSet2 of Set1: " + subset2);
            System.out.println("Set 1 equals sub set ? " + mySet1.equals(subset));
            mySet1.addAll(mySet2);
            System.out.println("Union of Set1 and Set2: " + mySet1);
            LinkedSortedSet<String> mySet3 = new LinkedSortedSet<>(String.CASE_INSENSITIVE_ORDER);
            mySet3.addAll(data.subList(listSize/3,listSize/2));
            System.out.println("My set 3: " + mySet3);
        }
        private static void withNonComparableElement() {
            List<Map.Entry<String,String>> countriesList = Countries.getSortedCountries();
            LinkedSortedSet<Map.Entry<String,String>> errorSet = new LinkedSortedSet(countriesList);
            System.out.println("This Set is Error, it cannot be printed: " + errorSet);
        }
    }
    public static void main(String[] args) {
        /*
         * with comparator
         */
        //TestUnit.initWithComparator();
        //TestUnit.test();
        /*
         * without comparator
         */
        TestUnit.initWithoutComparator();
        TestUnit.test();
        /*
         * with non comparable elements
         */
        //TestUnit.withNonComparableElement(); // ERROR: type argument Entry<String,String> is not within bounds of type-variable E
    }
}
