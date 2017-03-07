/**
 * Exercise 2
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.util.regex.*;

public class Exercise2 {
    /**
     * 简单偷懒的办法
     */
    public static void simpleMethod(String regex) {
        Map<String, String> resultMap = new HashMap<String,String>();
        Matcher m = Pattern.compile(regex).matcher("");
        for (Map.Entry<String,String> country : new FlyWeightMap().entrySet()) {
            m.reset(country.getKey());
            if (m.find()) {
                resultMap.put(country.getKey(),country.getValue());
            }
        }
        System.out.println(resultMap);
        System.out.println(resultMap.entrySet());
    }


    /**
     * 完整健壮的方法
     */
    // read only country info container
    public static class CountryPair implements Map.Entry<String,String> {
        private final String name;
        private final String capital;
        public CountryPair(String key, String value) {
            name = key;
            capital = value;
        }
        public String getKey() {
            return name;
        }
        public String getValue() {
            return capital;
        }
        public String setValue(String vaule) {  // read only, so ignore
            throw new UnsupportedOperationException();
        }
        public boolean equals(Object o) {
            if (o == null || !(o instanceof CountryPair)) {
                return false;
            }
            return name.equals(((CountryPair)o).getKey());
        }
        public int hashCode() {
            return name.hashCode();
        }
        public String toString() {
            return "(" + name + " = " + capital + ")";
        }
    }
    public static List<Map.Entry<String,String>> getSortedCountries(int size) {
        List<Map.Entry<String,String>> countriesList = new ArrayList<Map.Entry<String,String>>();
        for (Map.Entry<String,String> country : new FlyWeightMap(size).entrySet()) {
            countriesList.add(new CountryPair(country.getKey(), country.getValue()));
        }
        Collections.sort(countriesList, new Comparator<Map.Entry<String,String>>() {
            public int compare(Map.Entry<String,String> country1, Map.Entry<String,String> country2) {
                return String.CASE_INSENSITIVE_ORDER.compare(country1.getKey(),country2.getKey());
            }
        });
        return countriesList;
    }
    public static List<Map.Entry<String,String>> getSortedCountries() {
        int countriesSize = FlyWeightMap.dataSize();
        return getSortedCountries(countriesSize);
    }
    public static List<Map.Entry<String,String>> getCountriesByRegex(String regex) {
        List<Map.Entry<String,String>> resultList = new ArrayList<Map.Entry<String,String>>();
        Matcher m = Pattern.compile(regex).matcher("");
        for (Map.Entry<String,String> country : getSortedCountries()) {
            m = m.reset(country.getKey());
            if (m.find()) {
                resultList.add(country);
            }
        }
        return resultList;
    }
    public static <T> Set<T> fillSetByList(List<T> list) {
        Set<T> set = new HashSet<T>();
        set.addAll(list);
        return set;
    }
    public static <K,V> Map<K,V> fillMapByList(List<Map.Entry<K,V>> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<K,V> map = new HashMap<K,V>();
        for (Map.Entry<K,V> ele : list) {
            map.put(ele.getKey(),ele.getValue());
        }
        return map;
    }
    public static void main(String[] args) {
        String regex = "^A";
        // 简单方法
        simpleMethod(regex);
        // 健壮方法
        System.out.println(fillSetByList(getCountriesByRegex(regex)));
        System.out.println(fillMapByList(getCountriesByRegex(regex)));
    }
}
