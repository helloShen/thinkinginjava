/**
 * Exercise 1
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise1 {
    public static List<Map.Entry<String,String>> fillCountriesList(List<Map.Entry<String,String>> list,int size) {
        Map<String,String> countriesMap = new HashMap<String,String>(new FlyWeightMap(size));
        list.addAll(countriesMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,String>>() {
            public int compare(Map.Entry<String,String> country1, Map.Entry<String,String> country2) {
                return String.CASE_INSENSITIVE_ORDER.compare(country1.getKey(), country2.getKey());
            }
        });
        System.out.println("Ordered:>>> " + list);
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(list);
            System.out.println("Shuffled:>>>    " + list);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println("ArrayList:  ");
        List<Map.Entry<String,String>> arrayList = new ArrayList<Map.Entry<String,String>>();
        fillCountriesList(arrayList,10);
        System.out.println("LinkedList:  ");
        List<Map.Entry<String,String>> linkedList = new LinkedList<Map.Entry<String,String>>();
        fillCountriesList(linkedList,10);
    }
}
