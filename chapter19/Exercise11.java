/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise11 {
    public static void main(String[] args) {
        VendingMachine11 vm=new VendingMachine11("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter19/product.txt");
        Generator<Input11> gen=new RandomInputGenerator11();
        vm.run(gen);
    }
}