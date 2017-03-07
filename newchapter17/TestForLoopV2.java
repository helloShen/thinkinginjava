/**
 * TestForLoop v2
 */
 package com.ciaoshen.thinkinjava.newchapter17;
 import java.util.*;

 final class TestForLoopV2 {
     private static final Random R = new Random();
     private static final char[] LETTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
     private static String randomWord() {
         int length = R.nextInt(10);
         char[] chars = new char[length];
         for (int i = 0; i < length; i++) {
             chars[i] = LETTERS[R.nextInt(LETTERS.length)];
         }
         return new String(chars);
     }
     private static String randomUpperWord() {
         return randomWord().toUpperCase();
     }
     private static int wordLength() {
         return randomWord().length();
     }
     private static long threeOperation(int times) {
         long start = System.nanoTime();
         for (int i = 0; i < times; i++) {
             randomWord();
             randomUpperWord();
             wordLength();
         }
         long end = System.nanoTime();
         return end - start;
     }
     private static long[] threeOperationInThreeLoop(int times) {
         long[] results = new long[3];
         long as = System.nanoTime();
         for (int i = 0; i < times; i++) {
             randomWord();
         }
         long ae = System.nanoTime();
         results[0] = ae - as;
         long bs = System.nanoTime();
         for (int i = 0; i < times; i++) {
             randomUpperWord();
         }
         long be = System.nanoTime();
         results[1] = be - bs;
         long cs = System.nanoTime();
         for (int i = 0; i < times; i++) {
             wordLength();
         }
         long ce = System.nanoTime();
         results[2] = ce - cs;
         return results;
     }
     private static void test(int loop , int warmup) {
         long[] results = new long[3];
         for (int i = 0; i < loop; i++) {
             if (i >= warmup) {
                 long[] tempResult = threeOperationInThreeLoop(10000);
                 results[0] += tempResult[0];
                 results[1] += tempResult[1];
                 results[2] += tempResult[2];
             }
         }
         long result = 0;
         for (int i = 0; i < loop; i++) {
             if (i >= warmup) {
                  result += threeOperation(10000);
             }
         }
         System.out.println(result/(loop-warmup));
         long sum = 0;
         for (long l : results) {
             sum += l/(loop-warmup);
         }
         System.out.println(sum + " = " + results[0]/(loop-warmup) + " + " + results[1]/(loop-warmup)+ " + " + results[2]/(loop-warmup));
     }
     public static void main(String[] args) {
         int loop = 100;
         int warmup = 10;
         for (int i = 0; i < 10; i++) {
             test(loop,warmup);
         }
     }
 }
