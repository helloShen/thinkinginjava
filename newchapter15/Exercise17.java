/**
 * Exercise 17
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise17 {
    public static class Sets {
        /*
        public static <T> Set<T> union(Set<T> a, Set<T> b) {
            Set<T> result = new HashSet<>(a);
            result.addAll(b);
            return result;
        }
        */
        public static <T extends Enum<T>> EnumSet<T> union(EnumSet<T> a, EnumSet<T> b) {
            EnumSet<T> result = a.clone();
            result.addAll(b);
            return result;
        }
        /*
        public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
            Set<T> result = new HashSet<>(a);
            result.retainAll(b);
            return result;
        }
        */
        public static <T extends Enum<T>> EnumSet<T> intersection(EnumSet<T> a, EnumSet<T> b) {
            EnumSet<T> result = a.clone();
            result.retainAll(b);
            return result;
        }
        // Subtract subset from superset:
        /*
        public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
            Set<T> result = new HashSet<>(superset);
            result.removeAll(subset);
            return result;
        }
        */
        public static <T extends Enum<T>> EnumSet<T> difference(EnumSet<T> superset, EnumSet<T> subset) {
            EnumSet<T> result = superset.clone();
            result.removeAll(subset);
            return result;
        }
        // Reflexive--everything not in the intersection:
        /*
        public static <T> Set<T> complement(Set<T> a, Set<T> b) {
            return difference(union(a, b), intersection(a, b));
        }
        */
        public static <T extends Enum<T>> EnumSet<T> complement(EnumSet<T> a, EnumSet<T> b) {
            return difference(union(a, b), intersection(a, b));
        }
    }
    private enum Watercolors {
        ZINC, LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW, ORANGE,
        BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET,
        CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE,
        COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE,
        SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER,
        BURNT_UMBER, PAYNES_GRAY, IVORY_BLACK
    }
    public static void main(String[] args) {
        EnumSet<Watercolors> set1 = EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
        EnumSet<Watercolors> set2 = EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
        EnumSet<Watercolors> subset = Sets.intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + Sets.difference(set1, subset));
        System.out.println("difference(set2, subset): " + Sets.difference(set2, subset));
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
