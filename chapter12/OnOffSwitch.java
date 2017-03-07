/**
 *  exercise 14
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

public class OnOffSwitch {
    public static void f() throws OnOffException1,OnOffException2 {}
    private static Switch sw = new Switch();
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
            throw new OnOffException2();
            //throw new RuntimeException();
            //sw.off();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
        sw.read();
    }
}