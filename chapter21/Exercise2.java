/**
 *  Exercise 2
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Exercise2 {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(new Fibonacci(i+1)).start();
        }
    }
}