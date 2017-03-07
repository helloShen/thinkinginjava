/**
 * Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter14.pets;
import java.util.*;
import java.lang.reflect.*;

public class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual(String name) { this.name = name; }
    // ‘name’ is optional:
    public Individual() {}
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);   //use reflect
    }
    public long id() { return id; }
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual)o).id;
    }
    public int hashCode() {
        int result = 17;
        if(name != null){
            result = 37 * result + name.hashCode();
            result = 37 * result + (int)id;
        }
        return result;
    }
    public int compareTo(Individual arg) {
        // Compare by class name first:
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare != 0){
            return firstCompare;
        }
        if(name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if(secondCompare != 0){
                return secondCompare;
            }
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
    public static void main(String[] args){
        Individual peter=new Individual("Peter");
        Individual mary=new Individual("Mary");
        System.out.println(peter);
        System.out.println(mary);
        System.out.println("Peter compare to Mary = "+ peter.compareTo(mary));
    }
}
