/**
 * Random Generator
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class RandomGenerator {
    private static Random r = new Random();
    public static class Boolean implements Generator<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }
    public static class Byte implements Generator<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte)r.nextInt();
        }
    }
    public static class Character implements Generator<java.lang.Character> {
        public java.lang.Character next() {
            return (char)((int)'a' + r.nextInt(26));
        }
    }
    public static class String implements Generator<java.lang.String> {
        private static final Generator<java.lang.Character> charGen = new Character();
        private int length =7;
        public String() {}
        public String(int num) {
            length = num;
        }
        public java.lang.String next() {
            char[] charArray = new char[length];
            for (int i = 0; i < length; i++) {
                charArray[i] = charGen.next();
            }
            return new java.lang.String(charArray);
        }
    }

    public static class Short implements Generator<java.lang.Short> {
        public java.lang.Short next() {
            return (short)r.nextInt();
        }
    }
    public static class Integer implements Generator<java.lang.Integer> {
        private int mod = 10000;
        public Integer() {}
        public Integer(int modulo) { mod = modulo; }
        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }
    public static class Long implements Generator<java.lang.Long> {
        private int mod = 10000;
        public Long() {}
        public Long(int modulo) { mod = modulo; }
        public java.lang.Long next() {
            return new java.lang.Long(r.nextInt(mod));
        }
    }
    public static class Float implements Generator<java.lang.Float> {
        public java.lang.Float next() {
        // Trim all but the first two decimal places:
        int trimmed = Math.round(r.nextFloat() * 100);
            return ((float)trimmed) / 100;
        }
    }
    public static class Double implements Generator<java.lang.Double> {
        public java.lang.Double next() {
            long trimmed = Math.round(r.nextDouble() * 100);
            return ((double)trimmed) / 100;
        }
    }
    public static void main(java.lang.String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Character().next());
        }
        System.out.println(new String().next());
    }
}
