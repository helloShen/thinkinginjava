/**
 * Exercise 36
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise36 {
    private static interface Processor<T, EA extends Exception, EB extends Exception> {
        public void process(List<T> resultCollector) throws EA,EB;
    }
    private static class Failure1 extends Exception {}
    private static class Failure2 extends Exception {}

    private static class Processor1 implements Processor<String,Failure1,Failure2> {
        private int count = 3;
        public Processor1() {}
        public Processor1(int num) {
            count = num;
        }
        public void process(List<String> resultCollector) throws Failure1, Failure2 {
            if(count > 100) {
                throw new Failure1();
            }
            if(count-- > 1) {
                resultCollector.add("Hep!");
            } else {
                resultCollector.add("Ho!");
            }
            if(count < 0) {
                throw new Failure2();
            }
        }
    }
    public static void main(String[] args) {
        Processor1 p1 = new Processor1(5);
        Processor1 p2 = new Processor1(200);
        List<String> resultCollector1 = new ArrayList<String>();
        try {
            p1.process(resultCollector1);
        } catch(Failure1 e) {
            System.out.println(e);
        } catch(Failure2 e) {
            System.out.println(e);
        }

        List<String> resultCollector2 = new ArrayList<String>();
        try {
            p2.process(resultCollector2);
        } catch(Failure1 e) {
            System.out.println(e);
        } catch(Failure2 e) {
            System.out.println(e);
        }
        System.out.println(resultCollector1);
        System.out.println(resultCollector2);
    }
}
