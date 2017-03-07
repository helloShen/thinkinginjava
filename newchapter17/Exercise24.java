/**
 * Exercise 24
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise24 {
    private static class SimpleHashSet<K> extends AbstractSet<K> {
        private static final int MAX_SIZE = 1024;
        private static final int DEFAULT_SIZE = 16;
        private LinkedList<K>[] buckets;
        @SuppressWarnings({"rawtypes","unchecked"})
        private SimpleHashSet(int size) {
            buckets = new LinkedList[size];
        }
        // 静态工厂方法，只暴露Set接口的引用，向用户隐藏具体实现SimpleHashSet
        public static <K> Set<K> newInstance() { // return Set reference
            return newInstanceForTest(DEFAULT_SIZE);
        }
        public static <K> Set<K> newInstance(int size) { // return Set reference
            return newInstanceForTest(size);
        }
        private static <K> SimpleHashSet<K> newInstanceForTest(int size) { // return SimpleHashSet for test
            if (size <= 0) {
                size = DEFAULT_SIZE;
            }
            if (size > MAX_SIZE) {
                size = MAX_SIZE;
            }
            return new SimpleHashSet<K>(size);
        }
        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int bucketIndex;
                private Iterator<K> currentIte; // 一直保持要执行next()的iterator
                private Iterator<K> previousIte; // 用来执行remove()，保持上一个next()返回元素的iterator
                { // find the first node, if exists
                    moveToNextIte();
                }
                public boolean hasNext() {
                    return currentIte.hasNext();
                }
                public K next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException("Reach the end of the iteration!");
                    }
                    K result = currentIte.next();
                    previousIte = currentIte; // update previousIte
                    if (!currentIte.hasNext()) {
                        bucketIndex++;
                        moveToNextIte(); // change another iterator
                    }
                    return result;
                }
                public void remove() {
                    previousIte.remove();
                }
                // move to the next LinkedList if the current has reached the end
                private void moveToNextIte() { // not open to the public users, not part of the API
                    searchNextLinkedList:
                    while (true) {
                        if (bucketIndex >= buckets.length) { break; }
                        if (buckets[bucketIndex] != null && ! buckets[bucketIndex].isEmpty()) {
                            LinkedList<K> bucket = buckets[bucketIndex];
                            currentIte = bucket.iterator(); // update currentIte
                            break searchNextLinkedList;
                        }
                        bucketIndex++;
                    }
                }
            };
        }
        @Override
        public int size() {
            int size = 0;
            Iterator<K> ite = iterator();
            while (ite.hasNext()) {
                ite.next();
                size++;
            }
            return size;
        }
        @Override
        public boolean add(K k) {
            int bucketIndex = Math.abs(k.hashCode() % buckets.length);
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new LinkedList<K>();
            }
            if (!buckets[bucketIndex].contains(k)) {
                return buckets[bucketIndex].add(k);
            }
            return false;
        }
        private void showBuckets() { // not open as part of the API
            System.out.println("=========================");
            for (int i = 0; i < buckets.length; i++) {
                System.out.println("|---" + buckets[i]);
            }
            System.out.println("=========================");
        }
    }
    public static void main(String[] args) {
        int size = 16;
        Random r = new Random();
        SimpleHashSet<Integer> set = SimpleHashSet.newInstanceForTest(size);
        for (int i = 0; i < size; i++) {
            set.add(r.nextInt(size*10));
        }
        set.showBuckets();

        Iterator<Integer> ite = set.iterator();
        while (ite.hasNext()) {
            System.out.print(ite.next());
        }
        System.out.println("");
        removeFirst:
        for (int i = 0; i < size * 10; i++) { // remove the smallest number in the set
            if (set.contains(i)) {
                set.remove(i);
                System.out.println(i + " is removed!");
                break removeFirst;
            }
        }
        set.showBuckets();
        System.out.println("Now the size is: " + set.size());
    }
}
