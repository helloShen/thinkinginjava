/**
 * Exercise 29
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise29 {
    private static class Holder<T> {
        private T item;
        public Holder(T t) {
            item = t;
        }
        public T get() {
            return item;
        }
        public T set(T t) {
            T old = item;
            item = t;
            return old;
        }
        public String toString() {
            return item.toString();
        }
    }

    /*
     * 前期铺垫
     */
    public static Object wildcardsListGet(List<?> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("list for wildcardsListGet() method cannot be empty!");
        }
        return list.get(0);
    }
    public static <E> void half(List<E> list) {
        List<E> firstHalf = list.subList(0,list.size()/2);
        List<E> secondHalf = list.subList(list.size()/2,list.size());
        System.out.println("First Half: " + firstHalf);
        System.out.println("Second Half: " + secondHalf);
    }
    public static void wildcardsHalf(List<?> list) {
        List<?> firstHalf = firstHalfHelper(list);
        List<?> secondHalf = secondHalfHelper(list);
        System.out.println("First Half: " + firstHalf);
        System.out.println("Second Half: " + secondHalf);
    }
    public static <E> List<E> firstHalfHelper(List<E> list) {
        List<E> firstHalf = list.subList(0,list.size()/2);
        return firstHalf;
    }
    public static <E> List<E> secondHalfHelper(List<E> list) {
        List<E> secondHalf = list.subList(list.size()/2,list.size());
        return secondHalf;
    }

    /*
     * Holder<List<?>>是异构的：Holder里可以放List<String>,也可以放List<Integer>.
     */
    public static void holderGet(Holder<List<?>> holder) { // Holder的get()方法，无障碍。
        List<?> origList = holder.get();
        System.out.println(origList);
    }
    public static void holderSet(Holder<List<?>> holder, List<Integer> intList) { // List<?>是任何List的基类。比如List<String>,List<Integer>。
        holder.set(intList); // 用List<Integer>替换List<?>
        System.out.println(holder.get());
    }
    public static Object holderListGet(Holder<List<?>> holder) {
        List<?> origList = holder.get();
        Object o = origList.get(0); // List<?>里的元素取出来只能放在Object里。
        return o;
    }
    public static void holderListSet(Holder<List<?>> holder, Integer i) {
        List<?> origList = holder.get();
        //origList.add(i); // ERROR: 做不到。List<?>里什么也放不了，除了null。
    }

    /*
     * List<Holder<?>>可以是"异构"的：{Holder<String>, Holder<Integer>, Holder<Pet>}
     */
    public static void listAdd(List<Holder<?>> list, Holder<?> xHolder) {
        list.add(xHolder); // 实际是把捕获的Holder<CAP#1>装到List<Holder<?>>里。 因为Holder<CAP#1>是List<Holder<?>>的派生类。
    }
    public static void listGet(List<Holder<?>> list) {
        for (Holder<?> holder : list) {
            System.out.println(holder.get());
        }
    }
    public static void main(String[] args) {
        Holder<List<?>> stringListHolder = new Holder<List<?>>(new ArrayList<String>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""))));
        List<Integer> integerList = new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        System.out.println(wildcardsListGet(integerList));
        half(integerList);
        wildcardsHalf(integerList);
        holderGet(stringListHolder);
        holderSet(stringListHolder,integerList);
        System.out.println(holderListGet(stringListHolder));
        //holderListSet(stringListHolder,100); // ERROR: no suitable method found for add(Integer)

        //List<Holder<?>>里什么Holder都可以装。可以是Holder<String>也可以是Holder<Integer>,Holder<Pet>，等等等等。
        TypeInfo.PetCreator creator = new TypeInfo.ForNameCreator();
        List<Holder<?>> xHolderList = new ArrayList<Holder<?>>(); // 声明的时候，一定要是List<Holder<?>>
        listAdd(xHolderList, new Holder<String>("I have"));
        listAdd(xHolderList, new Holder<Integer>(100));
        listAdd(xHolderList, new Holder<TypeInfo.Pet>(creator.randomPet()));
        listGet(xHolderList);
    }
}
