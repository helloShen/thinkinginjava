/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise21 {
    public static class BaseException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static class BaseClass {
        public BaseClass() throws BaseException {
            System.out.println("I am Constructor of BaseClass!");
        }
    }
    public static class DerivedClass extends BaseClass {
        public DerivedClass() {
            try {
                //super();  //ERROR: super() must be the first statement in constructor
            } catch (BaseException e) {
                System.out.println("Exception in BaseClass captured!");
            }
        }
    }
    public static void main(String[] args) {
        DerivedClass derived = new DerivedClass();
    }
}
