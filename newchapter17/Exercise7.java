/**
 * Exercise 7
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise7 {
    // insert elements in list B into list A
    public static void insertion(ListIterator<String> iteA, ListIterator<String> iteB) {
        while (iteA.hasNext()) {
            iteA.next();
            if (iteB.hasNext()) {
                iteA.add(iteB.next() + "_2");
                //iteA.next();
            }
        }
        while (iteB.hasNext()) { // if LinkedList is longer than ArrayList
            iteA.add(iteB.next());
            iteA.next();
        }
    }
    // insert elements in list B into list A from the end
    public static void inverseInsertion(ListIterator<String> iteA, ListIterator<String> iteB) {
        while (iteA.hasNext()) {
            iteA.next();
        }
        while (iteA.hasPrevious()) {
            iteA.previous();
            if (iteB.hasNext()) {
                iteA.add(iteB.next() + "_2");
                iteA.previous();    // skip the last inserted element
            }
        }
        while (iteB.hasNext()) {
            iteA.add(iteB.next());
        }
    }
    public static void main(String[] args) {
        // create two list
        List<String> al = new ArrayList<String>();
        List<String> ll = new LinkedList<String>();
        al.addAll(Countries.name());
        ll.addAll(Countries.name());
        System.out.println("ArrayList: \n" + al);
        System.out.println("LinkedList: \n" + al);

        // normal insertion
        ListIterator<String> alIte = al.listIterator();
        ListIterator<String> llIte = ll.listIterator();
        //insertion(alIte, llIte);
        inverseInsertion(alIte, llIte); // inverse insertion
        System.out.println(al);
    }
}
