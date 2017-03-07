/**
 * Singly Linked List Implementation
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class SinglyLinkedList<E> implements Collection<E>, Iterable<E> {
    private int size = 0;
    private Node<E> head = new Node<E>();
    // constructor
    public SinglyLinkedList() {
        head.setNext(head);
    }
    public SinglyLinkedList(Collection<E> c) {
        this();
        addAll(c);
    }
    // unmodifiable collection (except remove() method)
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> cursor = head;
            Node<E> previous = head;
            public boolean hasNext() {
                return cursor.getNext() != head;
            }
            public E next() {
                if (! hasNext()) {
                    throw new IndexOutOfBoundsException("Iterator has reached the end of the list!");
                }
                Node<E> toReturn = cursor.getNext();
                previous = cursor;
                cursor = toReturn;
                return toReturn.getInfo();
            }
            public void remove() { // only remove once the last node return by next() method.
                if (cursor == previous) {
                    throw new IndexOutOfBoundsException("Cannot remove current node. Last node returned by next() already removed, or reach the head of the list!");
                }
                previous.setNext(cursor.getNext());
                cursor.setNext(null);
                cursor = previous;
                size--;
            }
        };
    }
    public int size() {
        return size;
    }
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<E> ite = iterator();
        sb.append("[");
        while (ite.hasNext()) {
            sb.append(ite.next());
            if (ite.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Object for contains() method is null!");
        }
        E ele = (E)o; // throw ClassCastException
        Iterator<E> ite = iterator();
        while (ite.hasNext()) {
            if (ite.next().equals(ele)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Collection arg is null in conainsAll() method!");
        }
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("rawtypes")
    public boolean equals(Object o) {
        if (o == null || !(o instanceof SinglyLinkedList)) {
            return false;
        }
        SinglyLinkedList target = (SinglyLinkedList)o;
        if (size() != target.size()) {
            return false;
        }
        return hashCode() == target.hashCode();
    }
    public int hashCode() {
        int init = 31;
        for (E ele : this) {
            init = (init + ele.hashCode()) * 31;
        }
        return init;
    }
    public boolean isEmpty() {
        return head.getNext() == head;
    }
    public Object[] toArray() { // keep silence even if list is changed during the copy (naive way)
        Object[] array = new Object[size()];
        Iterator<E> ite = iterator();
        for (int i = 0; i <array.length; i++) {
            if (ite.hasNext()) {
                array[i] = ite.next();
            }
        }
        return Arrays.copyOf(array,array.length);  // deep copy, not shallow copy
    }
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not Yet!");
    }
    // modifible optional operations
    public boolean add(E e) { // add after head
        if (e == null) {
            return false;
        }
        Node<E> newNode = new Node<E>(e);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        size ++;
        return true;
    }
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        if (c == null || c.isEmpty()) {
            return result;
        }
        for (E ele : c) {
            if (add(ele)) {
                result = true;
            }
        }
        return result;
    }
    public void clear() {
        head.setNext(head);
        size = 0;
    }
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        boolean result = false;
        if (o == null) {
            Iterator<E> ite = iterator();
            while (ite.hasNext()) {
                if (ite.next() == null) {
                    ite.remove();
                    result = true;
                }
            }
        } else {
            E ele = (E)o;
            Iterator<E> ite = iterator();
            while (ite.hasNext()) {
                if (ite.next().equals(ele)) {
                    ite.remove();
                    result = true;
                }
            }
        }
        return result;
    }
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        if (c == null || c.isEmpty()) {
            return result;
        }
        if (!(c instanceof Collection)) {
            throw new ClassCastException("Argument for removeAll() method should be a Collection!");
        }
        for (Object o : c) {
            if (remove(o)) {
                result = true;
            }
        }
        return result;
    }
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        if (c == null || c.isEmpty()) {
            return result;
        }
        if (!(c instanceof Collection)) {
            throw new ClassCastException("Argument for retainAll() method should be a Collection!");
        }
        Iterator<E> ite = iterator();
        while (ite.hasNext()) {
            if (!c.contains(ite.next())) {
                ite.remove();
                result = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Collection<String> data = new ArrayList<String>(Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")));
        System.out.println("Data source: " + data);
        Collection<String> myList = new SinglyLinkedList<String>(data);
        System.out.println("My list: " + myList);
        System.out.println("Length of list is: " + myList.size());
        System.out.println("My list equals the data resource? " + myList.equals(data));
        Iterator<String> ite = myList.iterator();
        int half = myList.size()/2;
        for (int i = 0; i < half; i++) {
            if (ite.hasNext()) {
                ite.next();
                ite.remove();
            }
        }
        System.out.println("After remove half of the list: " + myList);
        System.out.println("Length of list is: " + myList.size());
        System.out.println("myList contains K? " + myList.contains("K"));
        System.out.println("myList contains k? " + myList.contains("k"));
        Collection<String> vowels = new SinglyLinkedList<String>(Arrays.asList("AEIOU".split("")));
        myList.removeAll(vowels);
        System.out.println("After removing the Vowels: " + myList);
        System.out.println("Length of list is: " + myList.size());
        Collection<String> onlyK = Arrays.asList(new String[]{"K","k"});
        myList.retainAll(onlyK);
        System.out.println("Only the K left: " + myList);
        System.out.println("Length of list is: " + myList.size());
        Object[] arrayK = myList.toArray();
        System.out.println("I got the K array now: " + Arrays.asList(arrayK));
    }
}
