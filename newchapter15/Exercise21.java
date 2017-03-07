/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise21 {
    public static class ClassTypeCapture {
        private Map<String,Class<?>> kindMap = new HashMap<String,Class<?>>();
        public void addType(String name , Class<?> klass) {
            kindMap.put(name, klass);
        }
        public boolean find(Object arg) {
            for (Class<?> c : kindMap.values()) {
                if (c.isInstance(arg)) {
                    return true;
                }
            }
            return false;
        }
        public Object createNew(String typename) {
            if (!kindMap.containsKey(typename)) {
                throw new IllegalArgumentException("I didn't find " + typename + " !");
            }
            try {
                return kindMap.get(typename).newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static class TestObject { // must be public
        private static int count = 0;
        private int ID = ++count;
        public String toString() {
            return "TestObject#" + ID;
        }
    }
    public static void main(String[] args) {
        ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("String", String.class);
        capture.addType("Integer", Integer.class);
        System.out.println("I can find type of \"Hello\": " + capture.find(new String("Hello")));
        System.out.println("I can find type of \"100\": " + capture.find(new Integer(100)));
        System.out.println("I can find type of \"19.999\": " + capture.find(new Double(19.999)));

        capture.addType("TestObject", TestObject.class);
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
    }
}
