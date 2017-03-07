/**
 *  Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise10 {
    public static void main(String[] args) {
        VendingMachine vm1=new VendingMachine();
        Generator<Input> gen=new RandomInputGenerator();
        vm1.run(gen);
        vm1.reset();
        vm1.run(gen);
        
        VendingMachine vm2=new VendingMachine();
        vm2.run(gen);
    }
}