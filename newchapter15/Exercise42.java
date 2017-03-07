/**
 * Exercise 42
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;
import java.lang.Math.*;

public class Exercise42 {
    // in space
    private static interface InDistance<T extends InDistance<? super T>> { // 自限定泛型
        public double distance(T t);
    }
    private static class OneDPoint implements InDistance<OneDPoint> {
        private static final String TYPENAME = "1D Point";
        private static int count = 0;
        private final int ID = ++count;
        private final String NAME = TYPENAME + "#" + ID;
        protected int x;
        public OneDPoint(int num) {
            x = num;
        }
        public String toString() {
            return NAME + ": [" + x + "]";
        }
        public int getX() {
            return x;
        }
        public int setX(int position) {
            int old = x;
            x = position;
            return old;
        }
        public double distance(OneDPoint p) {
            return (double) Math.abs(getX() - p.getX());
        }
    }
    private static class TwoDPoint extends OneDPoint implements InDistance<OneDPoint> {
        private static final String TYPENAME = "2D Point";
        private static int count = 0;
        private final int ID = ++count;
        private final String NAME = TYPENAME + "#" + ID;
        protected int y;
        public TwoDPoint(int numX) {
            super(numX);
        }
        public TwoDPoint(int numX, int numY) {
            super(numX);
            y = numY;
        }
        public String toString() {
            return NAME + ": [" + x + "," + y + "]";
        }
        public int getY() {
            return y;
        }
        public int setY(int positionX, int positionY) {
            int old = positionX;
            y = positionY;
            return old;
        }
        public double distance(OneDPoint p) {
            if (p instanceof TwoDPoint) {
                @SuppressWarnings("unchecked")
                TwoDPoint twoDp = (TwoDPoint)p;
                return Math.sqrt( Math.pow( ( this.getX() - twoDp.getX() ), 2 ) + Math.pow( ( this.getY() - twoDp.getY() ), 2 ) );
            }
            return super.distance(p);
        }
    }

    private static class Function {
        private static <T extends InDistance<? super T>> double totalDistance(Collection<T> c) {
            double totalDistance = 0.0;
            if (c.size() < 2) {
                return totalDistance;
            }
            Iterator<T> ite = c.iterator();
            T previousPoint = ite.next(); // length > 2, must have point
            while (ite.hasNext()) {
                T currentPoint = ite.next();
                totalDistance += currentPoint.distance(previousPoint);
            }
            return totalDistance;
        }
    }
    private static class TestUnit {
        private static Random r = new Random();
        private static final int MAX = 100;
        private static int random() {
            return r.nextInt(MAX);
        }
        private static OneDPoint createOneD() {
            return new OneDPoint(random());
        }
        private static TwoDPoint createTwoD() {
            return new TwoDPoint(random(),random());
        }
        private static List<OneDPoint> oneDList(int size) {
            List<OneDPoint> result = new ArrayList<OneDPoint>();
            for ( int i = 0; i < size; i++) {
                result.add(createOneD());
            }
            return result;
        }
        private static List<TwoDPoint> twoDList(int size) {
            List<TwoDPoint> result = new ArrayList<TwoDPoint>();
            for ( int i = 0; i < size; i++) {
                result.add(createTwoD());
            }
            return result;
        }
        private static List<OneDPoint> mixList(int size) {
            boolean typeFlag = true;
            List<OneDPoint> result = new ArrayList<OneDPoint>();
            for ( int i = 0; i < size; i++) {
                if (typeFlag) {
                    result.add(createOneD());
                } else {
                    result.add(createTwoD());
                }
                typeFlag = !typeFlag;
            }
            return result;
        }
        private static void testPoint() {
            OneDPoint onePa = createOneD();
            OneDPoint onePb = createOneD();
            System.out.println("Distance of " + onePa + " AND " + onePb + " is: " + onePa.distance(onePb));
            TwoDPoint twoPa = createTwoD();
            TwoDPoint twoPb = createTwoD();
            System.out.println("Distance of " + twoPa + " AND " + twoPb + " is: " + twoPa.distance(twoPb));
            System.out.println("Distance of " + twoPa + " AND " + onePa + " is: " + twoPa.distance(onePa));
        }
        private static void testFunction() {
            int size = 10;
            List<OneDPoint> oneDList = oneDList(size);
            List<TwoDPoint> twoDList = twoDList(size);
            List<OneDPoint> mixList = mixList(size);
            System.out.println("Total Distance:     " + Function.totalDistance(oneDList));
            System.out.println("Total Distance:     " + Function.totalDistance(twoDList));
            System.out.println("Total Distance:     " + Function.totalDistance(mixList));
        }
    }
    public static void main(String[] args) {
        TestUnit.testPoint();
        TestUnit.testFunction();
    }
}
