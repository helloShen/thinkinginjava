/**
 * Exercise 26
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise26 {
    private static final class CountedString {
        // Pair is immutable
        private static final class Pair {
            private final String s;
            private final char c;
            private Pair(String s, char c) {
                this.s = s;
                this.c = c;
            }
            public static Pair newInstance(String s, char c) {
                return new Pair(s,c);
            }
            public boolean equals(Object o) {
                if ( o == this) { return true; }
                if ( ! ( o instanceof Pair ) ) { return false; }
                Pair p = (Pair)o;
                return p.s.equals(s) && p.c == c;
            }
            public int hashCode() {
                int result = 17;
                result = 31 * result + s.hashCode();
                result = 31 * result + (int)c;
                return result;
            }
            public String toString() {
                return "P[" + s + "," + c + "]";
            }
        }
        private static final List<Pair> list = new ArrayList<>(); //不能暴露可变对象域的引用给用户
        private final String s;
        private final char c;
        private final int id;
        private CountedString(String s, char c) {
            this.s = s;
            this.c = c;
            Pair p = Pair.newInstance(s,c);
            list.add(p);
            int count = 0;
            for (Pair ele : list) {
                if (p.equals(ele)) { count++; }
            }
            id = count;
        }
        public static CountedString newInstance(String s, char c) {
            return new CountedString(s,c);
        }
        public static void print() {
            System.out.println(list);
        }
        public String getS() { return s; }
        public String getC() { return c; }
        public String getId() { return id; }
        public boolean equals(Object o) {
            if ( o == this) { return true; }
            if ( ! ( o instanceof CountedString ) ) { return false; }
            CountedString cs = (CountedString)o;
            return cs.s.equals(s) && cs.c == c && cs.id == id;
        }
        public int hashCode() {
            int result = 17;
            result = 31 * result + s.hashCode();
            result = 31 * result + (int)c;
            result = 31 * result + id;
            return result;
        }
        public String toString() {
            return "CS[" + s + "," + c + "," + id + "]";
        }
    }
    public static void main(String[] args) {
        int max = 128;
        int min = 32;
        int size = 30;
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            int seed = r.nextInt(max-min)+min;
            char[] chars = new char[]{(char)seed,(char)(seed+1),(char)(seed+2)};
            CountedString.newInstance(new String(chars), (char)(seed+1));
        }
        CountedString.print();
    }
}
