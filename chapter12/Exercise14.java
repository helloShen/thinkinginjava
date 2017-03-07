/**
 * Exercise 14
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise14 {
    public static class OnOffSwitch {
        private static Switch sw = new Switch();
        public static void f() throws OnOffException1,OnOffException2 {throw new RuntimeException();}
    }
    public static void main(String[] args) {
            try {
                Exercise14.OnOffSwitch.sw.on();
                // Code that can throw exceptions...
                Exercise14.OnOffSwitch.f();
                Exercise14.OnOffSwitch.sw.off();
            } catch(OnOffException1 e) {
                System.out.println("OnOffException1");
                Exercise14.OnOffSwitch.sw.off();
            } catch(OnOffException2 e) {
                System.out.println("OnOffException2");
                Exercise14.OnOffSwitch.sw.off();
            }
    }
}
