/**
 * Exercise 7
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise7 {
    public static class Table {
        private static int count = 0;
        private final int ID = ++count;
        public String toString() {
            return "Table#" + ID;
        }
    }
    public static void main(String[] args) {
        int arrayLength = 10;
        Table[] tableArray = new Table[10];
                for (int i = 0; i < tableArray.length; i++) {
            tableArray[i] = new Table();
        }
        System.out.println("Table Array >>>");
        System.out.println(Arrays.toString(tableArray));
        List<Table> tableList = Arrays.asList(tableArray);
        System.out.println("Table list >>>");
        System.out.println(tableList);
        List<Table> subTableList = tableList.subList(0,tableList.size()/2);
        System.out.println("Table sub list >>>");
        System.out.println(subTableList);
    }
}
