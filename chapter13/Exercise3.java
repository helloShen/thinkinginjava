/**
 * Exercise 3
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.io.*;
import java.util.*;

public class Exercise3{
    private String name;
    private Formatter f;
    public Exercise3(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }
    public static void main(String[] args) {
        PrintStream errAlias= System.err;
        Exercise3 tommy = new Exercise3("Tommy",new Formatter(System.err));
        Exercise3 terry = new Exercise3("Terry",new Formatter(errAlias));
        tommy.move(0,0);
        terry.move(4,8);
        tommy.move(3,4);
        terry.move(2,5);
        tommy.move(3,3);
        terry.move(3,3);
    }
}
