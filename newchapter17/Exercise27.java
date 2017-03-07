/**
 * Exercise 27
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

final class Exercise27 {
    private static final class CountedString {
        private static List<String> created = new ArrayList<String>();
        private String s;
        private int id = 0;
        public CountedString(String str) {
            s = str;
            created.add(s);
            for(String s2 : created) {
                if(s2.equals(s)) {
                    id++;
                }
            }
        }
        public String toString() {
            return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
        }
        // 并没有违反equals()的约定。equals()判断相等的对象，hashCode()也一定相等。
        public int hashCode() {
            int result = 17;
            return 37 * result + s.hashCode();
        }
        public boolean equals(Object o) {
            return o instanceof CountedString && s.equals(((CountedString)o).s) && id == ((CountedString)o).id;
        }
    }
    public static void main(String[] args) {
        Map<CountedString,Integer> map = new HashMap<CountedString,Integer>();
        CountedString[] cs = new CountedString[5];
        for(int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i); // 这几个点虽然id域不相等，但hashCode()都相等。导致碰撞严重。5个点在同一个桶里。影响了HashMap的性能。 
        }
        System.out.println(map);
        for(CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }
}
