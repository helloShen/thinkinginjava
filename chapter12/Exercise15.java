/**
 * Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise15 {
    public static class WithFinally {
        private static Switch sw = new Switch();
    }
    public static void main(String[] args) {
        try {
            Exercise15.WithFinally.sw.on();
            // Code that can throw exceptions...
            Exercise14.OnOffSwitch.f();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            Exercise15.WithFinally.sw.off();
        }
    }
}
