/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise24 {
    private static interface Factory<T> {
        public T create();
    }
    public static class ClassTypeCapture {
        private Map<String,Factory<?>> factoriesMap = new HashMap<String,Factory<?>>();
        public void addType(String name , Factory<?> fac) {
            factoriesMap.put(name, fac);
        }
        public Object createNew(String typename) {
            if (!factoriesMap.containsKey(typename)) {
                throw new IllegalArgumentException("I didn't find " + typename + " !");
            }
            return factoriesMap.get(typename).create();
        }
    }
    public static class TestObject { // must be public
        private static int count = 0;
        private int ID = ++count;
        public String toString() {
            return "TestObject#" + ID;
        }
        public static Factory<TestObject> factory = new Factory<TestObject>() {
            public TestObject create() {
                return new TestObject();
            }
        };
    }
    public static void main(String[] args) {
        ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("TestObject", TestObject.factory);
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
    }
}
