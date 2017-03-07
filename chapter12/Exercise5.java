/**
 * Exercise 5
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise5 {
    public static void main(String[] args) {
        int offset= 10;
        while (true) {  //try to read the last element in the array
            try {
                int[] arrayToOverflow = {1,2,3,4,5};
                System.out.println("The last element (" + "index=" + offset + ") in the array is: " + arrayToOverflow[offset]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(offset + " is too big!");
                offset--;
            }
        }
    }
}
