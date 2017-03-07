/**
 * Exercise 16
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise16 {
    public static class Shape {
        Shape(int i) { System.out.println("Shape constructor"); }
        void dispose() { System.out.println("Shape dispose"); }
    }
    public static class Circle extends Shape {
        Circle(int i) {
            super(i);
            System.out.println("Drawing Circle");
        }
        void dispose() {
            System.out.println("Erasing Circle");
            super.dispose();
        }
    }
    public static class Triangle extends Shape {
        Triangle(int i) {
            super(i);
            System.out.println("Drawing Triangle");
        }
        void dispose() {
            System.out.println("Erasing Triangle");
            super.dispose();
        }
    }
    public static class Line extends Shape {
        private int start, end;
        Line(int start, int end) {
            super(start);
            this.start = start;
            this.end = end;
            System.out.println("Drawing Line: " + start + ", " + end);
        }
        void dispose() {
            System.out.println("Erasing Line: " + start + ", " + end);
            super.dispose();
        }
    }
    public static class CADSystem extends Shape {
        private Circle c;
        private Triangle t;
        private Line[] lines = new Line[3];
        public CADSystem(int i) {
            super(i + 1);
            for(int j = 0; j < lines.length; j++) {
                lines[j] = new Line(j, j*j);
            }
            c = new Circle(1);
            t = new Triangle(1);
            System.out.println("Combined constructor");
        }
        public void dispose() {
            System.out.println("CADSystem.dispose()");
            // The order of cleanup is the reverse
            // of the order of initialization:
            t.dispose();
            c.dispose();
            for(int i = lines.length - 1; i >= 0; i--) {
                lines[i].dispose();
            }
            super.dispose();
        }
    }
    public static void main(String[] args) {
        Exercise16.CADSystem x = new Exercise16.CADSystem(47);
        try {
            // Code and exception handling...
            return;
        } finally {
            x.dispose();
        }
    }
}
