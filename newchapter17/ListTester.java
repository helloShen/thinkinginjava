/**
 * Tester测试框架
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class ListTester<T> {
    private static final int DEFAULT_SIZE = 10;
    private final Generator<T> GEN;
    private final int SIZE;
    private ListTester(Generator<T> gen) {
        this(gen, DEFAULT_SIZE);
    }
    private ListTester(Generator<T> gen, int listSize) {
        GEN = gen;
        SIZE = listSize;
    }
    public static <T> ListTester<T> newInstance(Generator<T> gen) { // public Factory return instance of Tester
        return new ListTester<T>(gen);
    }
    public static <T> ListTester<T> newInstance(Generator<T> gen, int size) {
        return new ListTester<T>(gen,size);
    }
    private List<T> randomList(int size) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(GEN.next());
        }
        return result;
    }
    public long testAdd(List<T> list, int times) {
        assert list.isEmpty();
        T ele = GEN.next();
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            list.add(ele);
        }
        long end = System.nanoTime();
        assert list.size() == times;
        return end - start;
    }
    public long testIteAddAll(List<T> list, int times) {
        assert list.isEmpty();
        List<T> tempList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            tempList.add(GEN.next());
        }
        assert tempList.size() == times;
        long start = System.nanoTime();
        for (T t : tempList) {
            list.add(t);
        }
        long end = System.nanoTime();
        assert list.size() == tempList.size();
        return end - start;
    }
    public long testAddAll(List<T> list, int times) {
        assert list.isEmpty();
        List<T> tempList = new ArrayList<>();
        for (int i = 0; i< times; i++) {
            tempList.add(GEN.next());
        }
        assert tempList.size() == times;
        long start = System.nanoTime();
        list.addAll(tempList);
        long end = System.nanoTime();
        assert list.size() == tempList.size();
        return end - start;
    }
    public void test(List<T> list) { // give me an empty list
        // Fill: add()  addAll()
        list.addAll(randomList(SIZE));
        if (list.size() != SIZE) {
            throw new RuntimeException("Error occured during insertion!");
        }
        System.out.println(list.getClass() + ", size = " + list.size());
        System.out.println(list);
        // Check: get(), isEmpty(), contains(), containsAll(), indexOf(), lastIndexOf(), subList()
        System.out.println("List is empty now? " + list.isEmpty());
        System.out.println("The element in the middle is: " +list.get(SIZE/2));
        System.out.println("Is the list contains \"Ch\"? " + list.contains("Ch"));
        List<T> sublist1 = new ArrayList<>(list.subList(SIZE/3,SIZE/2)); // subList()返回的只是一个视图
        if (sublist1.size() != (SIZE/2-SIZE/3)) {
            throw new RuntimeException("subList() has problems!");
        }
        System.out.println("Sub list 1: " + sublist1);
        System.out.println("My list contains this sublist? " + list.containsAll(sublist1));
        if (! list.containsAll(sublist1)) {
            throw new RuntimeException("subList() or containsAll() method have some bugs!");
        }
        // Remove: remove(), removeAll(), clear()
        list.remove(list.get(0)); // remove the first element
        System.out.println(list + " (size: " + list.size() + ")");
        list.removeAll(sublist1);
        //list.retainAll(sublist1);
        System.out.println(list + " (size: " + list.size() + ")");
        list.clear();
        System.out.println("Now the list is empty? " + list.isEmpty());
    }
    public static void main(String[] args) {
        ListTester<String> myTester = ListTester.newInstance(StringGenerator.newInstance(2));
        myTester.test(new ArrayList<String>());
        System.out.println(myTester.testAdd(new ArrayList<String>(), 10000));
        System.out.println(myTester.testIteAddAll(new ArrayList<String>(), 10000));
        System.out.println(myTester.testAddAll(new ArrayList<String>(), 10000));
    }
}
