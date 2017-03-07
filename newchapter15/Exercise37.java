/**
 * Exercise 37
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise37 {
    private static interface TimeStamped { long getStamp(); }
    private static class TimeStampedImp implements TimeStamped {
        private final long timeStamp;
        public TimeStampedImp() {
            timeStamp = new Date().getTime();
        }
        public long getStamp() { return timeStamp; }
    }
    private static interface SerialNumbered { long getSerialNumber(); }
    private static class SerialNumberedImp implements SerialNumbered {
        private static long counter = 1;
        private final long serialNumber = counter++;
        public long getSerialNumber() { return serialNumber; }
    }
    private static interface KnowSelfName { String getName(); }
    private static class KnowSelfNameImp implements KnowSelfName {
        private final String name;
        public KnowSelfNameImp(String str) {
            name = str;
        }
        public String getName() {
            return name;
        }
    }
    private static interface Basic {
        public void set(String val);
        public String get();
    }
    private static class BasicImp implements Basic {
        private String value;
        public void set(String val) { value = val; }
        public String get() { return value; }
    }
    private static class Mixin extends BasicImp implements TimeStamped, SerialNumbered, KnowSelfName {
        private TimeStamped timeStamp = new TimeStampedImp();
        private SerialNumbered serialNumber = new SerialNumberedImp();
        private KnowSelfName hisName;
        public Mixin(String name) {
            hisName = new KnowSelfNameImp(name);
        }
        public long getStamp() { return timeStamp.getStamp(); }
        public long getSerialNumber() {
            return serialNumber.getSerialNumber();
        }
        public String getName() {
            return hisName.getName();
        }
    }
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin("Hello"), mixin2 = new Mixin("World");
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " Called: " + mixin1.getName() + " " +
        mixin1.getStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " Called: " + mixin2.getName() + " " +
        mixin2.getStamp() + " " + mixin2.getSerialNumber());
    }
}
