/**
 * Exercise 33
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

/**
 * 继承LinkedList。内部再维护着一个ArrayList。
 * 除了iterator(), listIterator(), get()三个方法调用ArrayList，其他所有方法都调用LinkedList的方法。
 * 之所以能这么做，基于下面这个重要事实：
 *     {@literal LinkedList的所有方法都不依赖于iterator(),listIterator()和get()中的任何一个。所以覆盖他们不会影响其他方法的行为。}
 * 每次调用ArrayList上述3个方法前，需要把LinkedList的数据同步到ArrayList上。惰性同步的策略，为了减少同步带来的性能损失。
 */
public final class Exercise33 {
    // public to be accessable for reflect
    public static final class FastTraversalLinkedList<T> extends LinkedList<T> {
        private static final long serialVersionUID = 0l;
        private final ArrayList<T> arraylist = new ArrayList<>(this); // 内部维护一个ArrayList
        private transient int arrayListModCount = modCount; // 靠它检测外部LinkedList和内部ArrayList是否同步
        // iterator, listIterator, get: ArrayList
        public Iterator<T> iterator() {
            synchronizeArrayList();
            return arraylist.iterator();
        }
        public ListIterator<T> listIterator() {
            synchronizeArrayList();
            return arraylist.listIterator();
        }
        public ListIterator<T> listIterator(int index) {
            synchronizeArrayList();
            return arraylist.listIterator(index);
        }
        public T get(int index) {
            if (index < 0 || index >= size()) {
                throw new IndexOutOfBoundsException();
            }
            synchronizeArrayList();
            return arraylist.get(index);
        }
        private final void synchronizeArrayList() {
            if (listIsChanged()) {
                arraylist.clear();
                arraylist.addAll(this);
                arrayListModCount = modCount;
            }
        }
        private final boolean listIsChanged() {
            return arrayListModCount != modCount;
        }
    }
    private static final class FastTraversalLinkedListPerformance extends AbstractTesterController<List<String>> {
        private final Generator<String> gen = StringGenerator.newInstance();
        private final List<String> randomFill(List<String> list, int size) {
            for (int i = 0; i < size; i++) {
                list.add(gen.next());
            }
            return list;
        }
        public Map<String,Test<List<String>>> testRegistry() {
            Generator<String> gen = StringGenerator.newInstance();
            Map<String,Test<List<String>>> tests = new LinkedHashMap<String,Test<List<String>>>();
            tests.put("Add", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    String str = gen.next();
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.add(str);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("addAll", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    List<String> tempList = randomFill(new ArrayList<String>(),size);
                    long start = System.nanoTime();
                    list.addAll(tempList);
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("remove", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    list = randomFill(list,size*2);
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.remove(i); // always remove the element in the middle
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("iterator", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    list = randomFill(list,size);
                    long start = System.nanoTime();
                    for (Iterator<String> ite = list.iterator(); ite.hasNext(); ) {
                        ite.next();
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("listIterator", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    list = randomFill(list,size);
                    long start = System.nanoTime();
                    for (ListIterator<String> li = list.listIterator(list.size()); li.hasPrevious(); ) {
                        li.previous();
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            tests.put("Get", new Test<List<String>>() {
                public long test(List<String> list, int size) {
                    list = randomFill(list,size);
                    long start = System.nanoTime();
                    for (int i = 0; i < size; i++) {
                        list.get(i);
                    }
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }
        public static void test(String... args) {
            FastTraversalLinkedListPerformance controller = new FastTraversalLinkedListPerformance();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10,50,100,50,1000,25,10000,10});
        }
    }
    public static void main(String[] args) {
        FastTraversalLinkedListPerformance.test("com.ciaoshen.thinkinjava.newchapter17.Exercise33$FastTraversalLinkedList");
    }
}
