/**
 *  Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Exercise30 {
    
    public abstract static class Shape implements Serializable {
        protected static final long serialVersionUID=1L;
        public static final int RED = 1, BLUE = 2, GREEN = 3;
        public static int color=0;
        private int xPos, yPos, dimension;
        private static Random rand = new Random(47);
        private static int counter = 0;
        public abstract void setColor(int newColor);
        public abstract int getColor();
        public Shape(int xVal, int yVal, int dim) {
            xPos = xVal;
            yPos = yVal;
            dimension = dim;
        }
        public String toString() {
            return getClass() +
            "color[" + getColor() + "] xPos[" + xPos +
            "] yPos[" + yPos + "] dim[" + dimension + "]\n";
        }
        public static Shape randomFactory() {
            int xVal = rand.nextInt(100);
            int yVal = rand.nextInt(100);
            int dim = rand.nextInt(100);
            switch(counter++ % 3) {
                default:
                case 0: return new Circle(xVal, yVal, dim);
                case 1: return new Square(xVal, yVal, dim);
                case 2: return new Line(xVal, yVal, dim);
            }
        }
        public static void serializeStaticState(ObjectOutputStream os) throws IOException { os.writeInt(color); }
        public static void deserializeStaticState(ObjectInputStream os) throws IOException { color = os.readInt(); }
    }
    public static class Circle extends Shape {
        protected static final long serialVersionUID=1L;
        public Circle(int xVal, int yVal, int dim) {
            super(xVal, yVal, dim);
            color=RED;
        }
        public void setColor(int newColor) { color = newColor; }
        public int getColor() { return color; }
    }
    public static class Square extends Shape {
        protected static final long serialVersionUID=1L;
        public Square(int xVal, int yVal, int dim) {
            super(xVal, yVal, dim);
            color = RED;
        }
        public void setColor(int newColor) { color = newColor; }
        public int getColor() { return color; }
    }
    public static class Line extends Shape {
        protected static final long serialVersionUID=1L;
        public Line(int xVal, int yVal, int dim) {
            super(xVal, yVal, dim);
            color=RED;
        }
        public void setColor(int newColor) { color = newColor; }
        public int getColor() { return color; }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/CADState.txt"));
        // Read in the same order they were written:
        List<Class<? extends Exercise30.Shape>> shapeTypes = (List<Class<? extends Exercise30.Shape>>)in.readObject();
        Exercise30.Line.deserializeStaticState(in);
        List<Exercise30.Shape> shapes = (List<Exercise30.Shape>)in.readObject();
        System.out.println(shapes);
    }
}