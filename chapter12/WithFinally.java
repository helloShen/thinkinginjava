/**
 *  exercise 15
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

public class WithFinally {
    static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            OnOffSwitch.f();
            throw new OnOffException2();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
        sw.read();
    }
}