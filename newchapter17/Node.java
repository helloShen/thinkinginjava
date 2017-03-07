/**
 * Node for SinglyLinkedList
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Node<T> {
    private T info = null;
    private Node<T> next = null;

    public Node() {}
    public Node(T t) {
        info = t;
    }
    @SuppressWarnings("rawtypes")
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof Node)) {
            return false;
        }
        Node node = (Node)o;
        return info.equals(node.info);
    }
    public int hashCode() {
        if (info == null) {
            return 0;
        }
        return info.hashCode();
    }
    public T getInfo() {
        return info;
    }
    public T setInfo(T t) { // return old value
        T old = getInfo();
        info = t;
        return old;
    }
    public Node<T> getNext() {
        return next;
    }
    public Node<T> setNext(Node<T> n) {
        Node<T> old = next;
        next = n;
        return old;
    }
    public String toString() {
        return "[" + info + "]";
    }
}
