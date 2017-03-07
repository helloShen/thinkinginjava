/**
 * 测试框架
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class StringGenerator implements Generator<String> {
    private static final int DEFAULT_LENGTH = 7;
    private static Generator<String> GEN = null;
    private final char[] UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final Random R = new Random();
    private final int STR_LENGTH;
    private StringGenerator(int size) { STR_LENGTH = size; }
    public static Generator<String> newInstance() { // pre-charge Singleton
        if (GEN == null) {
            GEN = new StringGenerator(DEFAULT_LENGTH);
        }
        return GEN;
    }
    public static Generator<String> newInstance(int size) { // the only public factory return Generator interface
        return new StringGenerator(size);
    }
    public String next() {
        StringBuilder sb = new StringBuilder();
        sb.append(UPPER[R.nextInt(UPPER.length)]);
        for (int i = 0; i < STR_LENGTH-1; i++) {
            sb.append(LOWER[R.nextInt(LOWER.length)]);
        }
        return sb.toString();
    }
}
