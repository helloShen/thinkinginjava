/**
 * Test
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class BenchmarkTest2 {
    private static final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final Random R = new Random();
    private static StringBuilder sb = new StringBuilder();
    private static String str;

    public static long test1(int loops) {
        long start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            sb.append(LETTERS[R.nextInt(LETTERS.length)]);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long test2(int loops) {
        long start = System.nanoTime();
        String str = sb.toString();
        long end = System.nanoTime();
        return end - start;
    }

    public static long test3(int loops) {
        long start = System.nanoTime();
        String upper = str.toUpperCase();
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(test1(1000) + " - " + test2(1000) + " - " + test3(1000));
        }
    }
}
