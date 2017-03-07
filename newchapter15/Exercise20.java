/**
 * Exercise20
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise20 {
    private static interface TwoMethods {
        public void methodOne();
        public void methodTwo();
    }
    private static class ThreeMethods implements TwoMethods {
        public void methodOne() {
            System.out.println("This is Method One!");
        }
        public void methodTwo() {
            System.out.println("This is Method Two!");
        }
        public void methodThree() {
            System.out.println("This is Method Three!");
        }
    }
    private static class GenericMethods {
        public static <T extends TwoMethods> void callTwoMethod(T t) {
            t.methodOne();
            t.methodTwo();
        }
    }
    public static void main(String[] args) {
        GenericMethods.callTwoMethod(new ThreeMethods());
    }
}
