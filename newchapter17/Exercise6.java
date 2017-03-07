/**
 * Exercise 6
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise6 {
    public static class Unsupported<E> extends AbstractCollection<E> {
        private List<E> list = new ArrayList<E>();

        // unmodifiable collection 只需要额外实现iterator()和size()方法。当然equals()和hashCode()最好也实现一下。
        public int size() {
            return list.size();
        }
        public Iterator<E> iterator() {
            return list.iterator();
        }

        // modifiable collection 还要补上Iterator#remove()和add()以及addAll()方法
        public boolean add(E item) {
            return list.add(item);
        }
        public boolean addAll(Collection<? extends E> c) {
            return list.addAll(c);
        }

        // 以下是Collection接口不支持，但List接口却支持的方法。
        public E get(int index) {
            return list.get(index);
        }
        public int indexOf(Object o) {
            return list.indexOf(o);
        }
        public int lastIndexOf(Object o) {
            return list.lastIndexOf(o);
        }
        public ListIterator<E> listIterator() {
            return list.listIterator();
        }
        public List<E> subList(int fromIndex, int toIndex) {
            return list.subList(fromIndex,toIndex);
        }
    }
    public static void main(String[] args) {
        List<Map.Entry<String,String>> countriesList = Countries.getSortedCountries();
        System.out.println(countriesList.size());
        System.out.println(countriesList);
        countriesList.addAll(countriesList);
        System.out.println(countriesList.get(Countries.countriesSize()*2-1));
        System.out.println(countriesList.indexOf(new Countries.CountryPair("ALGERIA","Algiers")));
    }
}
