/**
 * Exercise 18
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

/**
 * Create the following three methods to implement a Set:
 * 1. size()
 * 2. iterator()
 * 3. add()
 */
public class Exercise18 {
    private static class SlowSet<K> extends AbstractSet<K> {
        private List<K> list = new ArrayList<K>();
        public int size() {
            return list.size();
        }
        public Iterator<K> iterator() {
            return list.iterator();
        }
        public boolean add(K k) {
            if ( ! list.contains(k) ) {
                list.add(k);
                return true;
            }
            return false;
        }
    }
    private static class Sets {
        private static void test(Set<String> set) {
            // Class Name
            System.out.println("Set is: " + set.getClass().getSimpleName());
            // add,addAll
            set.addAll(new CountingListData(60));
            System.out.println("Look at the Set: " + set);
            // size
            System.out.println("Size: " + set.size());
            // contains
            System.out.println("Set contains Ic? " + set.contains("Ic"));
            // remove, removeAll
            set.removeAll(Arrays.asList(new String[]{"Ix","Iy","Iz"}));
            System.out.println("After remove Ix,Iy,Iz: " + set);
            // retainsAll
            set.retainAll(Arrays.asList(new String[]{"Ia","Ib","Ic"}));
            System.out.println("After retains Ia,Ib,Ic: " + set);
            // clear
            set.clear();
            System.out.println("After call clear() method: " + set);
            // isEmpty
            System.out.println("Now Set is empty? " + set.isEmpty());
        }
    }
    public static void main(String[] args) {
        Sets.test(new SlowSet<String>());
    }
}
