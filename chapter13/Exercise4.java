/**
 * Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;

public class Exercise4 {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int[] columnsWidth={15,5,10};
    public Exercise4(){}
    public Exercise4(int[] width){columnsWidth=width;}

    public void printTitle() {
        f.format("%-"+columnsWidth[0]+"s %"+columnsWidth[1]+"s %"+columnsWidth[2]+"s\n", "Item", "Qty", "Price");
        f.format("%-"+columnsWidth[0]+"s %"+columnsWidth[1]+"s %"+columnsWidth[2]+"s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format("%-"+columnsWidth[0]+".15s %"+columnsWidth[1]+"d %"+columnsWidth[2]+".2f\n", name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format("%-"+columnsWidth[0]+"s %"+columnsWidth[1]+"s %"+columnsWidth[2]+".2f\n", "Tax", "", total*0.06);
        f.format("%-"+columnsWidth[0]+"s %"+columnsWidth[1]+"s %"+columnsWidth[2]+"s\n", "", "", "-----");
        f.format("%-"+columnsWidth[0]+"s %"+columnsWidth[1]+"s %"+columnsWidth[2]+".2f\n", "Total", "", total * 1.06);
    }
    public static void main(String[] args) {
        int[] width={30,10,20};
        Exercise4 receipt = new Exercise4(width);
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}
