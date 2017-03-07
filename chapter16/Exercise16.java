/**
 * Exercise16
 * 测试CountingGenerator等生成器
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise16 {
    public static void main(String[] args) {
        int size=6;
        SkipGenerator sg=new SkipGenerator(2);
        boolean[] a1 = PrimConv.toPrim(Generated.array(Boolean.class, sg.new Boolean(), size));
        System.out.println("a1 = " + Arrays.toString(a1));
        byte[] a2 = PrimConv.toPrim(Generated.array(Byte.class, sg.new Byte(), size));
        System.out.println("a2 = " + Arrays.toString(a2));
        char[] a3 = PrimConv.toPrim(Generated.array(Character.class, sg.new Character(), size));
        System.out.println("a3 = " + Arrays.toString(a3));
        short[] a4 = PrimConv.toPrim(Generated.array(Short.class, sg.new Short(), size));
        System.out.println("a4 = " + Arrays.toString(a4));
        int[] a5 = PrimConv.toPrim(Generated.array(Integer.class, sg.new Integer(), size));
        System.out.println("a5 = " + Arrays.toString(a5));
        long[] a6 = PrimConv.toPrim(Generated.array(Long.class, sg.new Long(), size));
        System.out.println("a6 = " + Arrays.toString(a6));
        float[] a7 = PrimConv.toPrim(Generated.array(Float.class, sg.new Float(), size));
        System.out.println("a7 = " + Arrays.toString(a7));
        double[] a8 = PrimConv.toPrim(Generated.array(Double.class, sg.new Double(), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }
}