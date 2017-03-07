/**
 * Test for loop
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class TestForLoop {
    /**
    private static long oneFor(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x++;
            x++;
            x++;
        }
        long end = System.nanoTime();
        return end-start;
    }
    private static long oneForThreeVars(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0, y = 0, z = 0; i < times; i++) {
            x++;
            y++;
            z++;
        }
        long end = System.nanoTime();
        return end-start;
    }
    private static long threeFor(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x++;
        }
        for (int i = 0, x = 0; i < times; i++) {
            x++;
        }
        for (int i = 0, x = 0; i < times; i++) {
            x++;
        }
        long end = System.nanoTime();
        return end-start;
    }
*/

    private static int plusOne(int i) {
        return ++i;
    }
    /**
    private static long oneForMethod(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
            x = plusOne(x);
            x = plusOne(x);
        }
        long end = System.nanoTime();
        return end-start;
    }
    private static long threeForMethod(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long end = System.nanoTime();
        return end-start;
    }


    private static List<Integer> randomList(int size) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(size));
        }
        return list;
    }
    private static void operationExpensive(int size) {
        List<Integer> list = randomList(size);
        Collections.sort(list);
    }
    private static long oneForExpensiveMethod(int times) {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            operationExpensive(1000);
            operationExpensive(1000);
            operationExpensive(1000);
        }
        long end = System.nanoTime();
        return end-start;
    }
    private static long threeForExpensiveMethod(int times) {
        long start = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            operationExpensive(1000);
        }
        for (int i = 0, x = 0; i < times; i++) {
            operationExpensive(1000);
        }
        for (int i = 0, x = 0; i < times; i++) {
            operationExpensive(1000);
        }
        long end = System.nanoTime();
        return end-start;
    }
    private static void test() {
        long[] result = new long[6];
        int loops= 100;
        //System.out.println("### INTO LOOP ###");
        for (int i = 0; i < loops; i++) {
            if (i >= 10) {
                //System.out.println("#############1");
                result[0] += oneFor(10000);
                //System.out.println("#############2");
                result[1] += threeFor(10000);
                //System.out.println("#############3");
                result[2] += oneForMethod(10000);
                //System.out.println("#############4");
                result[3] += threeForMethod(10000);
                //System.out.println("#############5");
                result[4] += oneForExpensiveMethod(100);
                //System.out.println("#############6");
                result[5] += threeForExpensiveMethod(100);
                //System.out.println("#############7");
            }
        }
        //System.out.println("### FINISH LOOP ###");
        Formatter f = new Formatter(System.out);
        f.format("%50.50s %10d \n", "One loop: ", result[0]/(loops-10));
        f.format("%50.50s %10d \n", "Three loop: ", result[1]/(loops-10));
        f.format("%50.50s %10d \n", "One loop call method: ", result[2]/(loops-10));
        f.format("%50.50s %10d \n", "Three loop call method: ", result[3]/(loops-10));
        f.format("%50.50s %10d \n", "One loop call expensive method: ", result[4]/(loops-10));
        f.format("%50.50s %10d \n", "Three loop call expensive method: ", result[5]/(loops-10));
    }

    private static long[] threeForMethodV2(int times) {
        long[] results = new long[3];
        long as = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long ae = System.nanoTime();
        results[0] = ae - as;
        long bs = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long be = System.nanoTime();
        results[1] = be - bs;
        long cs = System.nanoTime();
        for (int i = 0, x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long ce = System.nanoTime();
        results[2] = ce - cs;
        return results;
    }

    private static final Generator<String> GEN = StringGenerator.newInstance();
    private static final Random R = new Random();
    private static void upperCase() {
        String srt = GEN.next().toUpperCase();
    }
    private static void double() {
        int i = R.nextInt(1000) * 2;
    }
    private static void split() {
        char[] chars = GEN.next().toCharArray();
    }
    private static long threeOperation(int times) {
        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            upperCase();
            double();
            split();
        }
        long end = System.nanoTime();
        return end - start;
    }
    */
    private static long[] threeOperationSeprate(int times) {
        long[] results = new long[3];
        long as = System.nanoTime();
        for (int i = 0 , x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long ae = System.nanoTime();
        results[0] = ae - as;
        long bs = System.nanoTime();
        for (int i = 0 , x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long be = System.nanoTime();
        results[1] = be - bs;
        long cs = System.nanoTime();
        for (int i = 0 , x = 0; i < times; i++) {
            x = plusOne(x);
        }
        long ce = System.nanoTime();
        results[2] = ce - cs;
        return results;
    }

    public static void main(String[] args) {
        //for (int i = 0; i < 5; i++) {
        //    System.out.println(i + " times test >>>");
        //    test();
        //} 
        int loop = 1000;
        int warmup = 100;
        long[] results = new long[3];
        for (int i = 0; i < loop; i++) {
            if (i >= warmup) {
                long[] tempResult = threeOperationSeprate(10000);
                results[0] += tempResult[0];
                results[1] += tempResult[1];
                results[2] += tempResult[2];
            }
        }
        //System.out.println(result/950);
        System.out.println(results[0]/(loop-warmup) + " - " + results[1]/(loop-warmup) + " - " + results[2]/(loop-warmup));
    }
}
