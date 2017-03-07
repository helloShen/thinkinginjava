/**
 *
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class ListFeature {
    public static void main(String[] args) {
        Random rand = new Random(47);
        //container
        List<Integer> intList = new ArrayList<Integer>();
        System.out.println("1: " + intList);
        Integer one = new Integer(1);
        intList.add(one); // Automatically resizes
        System.out.println("2: " + intList);
        System.out.println("3: " + intList.contains(one));
        intList.remove(one); // Remove by object
        Integer two = new Integer(2);
        intList.add(two);
        System.out.println("4: " + two + " " + intList.indexOf(two));
        Integer three = new Integer(3);
        intList.add(three);
        System.out.println("5: " + intList.indexOf(three));
        System.out.println("6: " + intList.remove(three));
        // Must be the exact object:
        System.out.println("7: " + intList.remove(three));
        System.out.println("8: " + intList);
        //intList.add(3, new Integer(4)); // Insert at an index. 无法在超出size的位置插入
        System.out.println("9: " + intList);
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(new Integer(4));
        sub.add(new Integer(5));
        sub.add(new Integer(6));
        System.out.println("subList: " + sub);
        System.out.println("10: " + intList.containsAll(sub));
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        System.out.println("11: " + intList.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + intList.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(intList);
        //sub = Arrays.asList(intList.get(1), intList.get(4));  //超出范围
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<Integer>(intList); // Get a fresh copy
        //copy.remove(2); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(0, new Integer(7)); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(1, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + intList.isEmpty());
        intList.clear(); // Remove all elements
        System.out.println("19: " + intList);
        System.out.println("20: " + intList.isEmpty());
        intList.addAll(Arrays.asList(new Integer(8)));
        System.out.println("21: " + intList);
        //Object[] o = intList.toArray();
        //System.out.println("22: " + o[2]);
        
        String[] iniArray={"a","b","c","d","e","f","g"};
        List<String> strList=new ArrayList<String>();
        strList.addAll(Arrays.asList(iniArray));
        System.out.println(strList);
        List<String> subList=strList.subList(2,3);
        System.out.println(subList);
        strList.removeAll(subList);
        System.out.println(strList);
    }
}