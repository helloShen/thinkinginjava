/**
 * Test
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class BenchmarkTest {
    private static final char[] LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final Random R = new Random();
    private static StringBuilder sb = new StringBuilder();

    public static long test(int loops) {
        long start = System.nanoTime();
        for (int i = 0; i < loops; i++) {
            sb.append(LETTERS[R.nextInt(LETTERS.length)]);
        }
        String str = sb.toString();
        String upper = str.toUpperCase();
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                test(1000);
            }
        };
        System.out.println(new Benchmark(task));
    }
}
