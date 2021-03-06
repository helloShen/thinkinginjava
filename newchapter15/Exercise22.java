/**
 * Exercise 22
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;
import java.lang.reflect.*;

public class Exercise22 {
    private static class Point {
        private static int count = 0;
        private final int ID = ++count;
        private int x;
        private int y;
        public Point(Integer inX, Integer inY) {
            x = inX;
            y = inY;
        }
        public String toString() {
            return "Point#" + ID + " is: " + "[" + x + "," + y + "]";
        }
    }
    private static interface Factory<T> {
        public T create();
    }
    public static class PointFactory implements Factory<Point> {
        private static final Class<Point> POINT = Point.class;
        private static final Class<Integer> INTEGER = Integer.class;
        private int maxX;
        private int maxY;
        public PointFactory(int x, int y) {
            maxX = x;
            maxY = y;
        }

        public Point create() {
            Random r = new Random();
            try {
                return POINT.getDeclaredConstructor(INTEGER,INTEGER).newInstance(r.nextInt(maxX),r.nextInt(maxY));
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        PointFactory pf = new PointFactory(100,100);
        for(int i = 0; i < 10; i++) {
            System.out.println(pf.create());
        }
    }
}
