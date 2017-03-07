/**
 * Exercise 25
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise25 {
    public static class BaseException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static class DerivedException extends BaseException {
        private static final long serialVersionUID = 0;
    }
    public static class DerivedLevelTwoException extends DerivedException {
        private static final long serialVersionUID = 0;
    }

    public static class A {
        public void foo() throws BaseException {
            throw new BaseException();
        }
    }
    public static class B extends A {
        public void foo() throws DerivedException {
            throw new DerivedException();
        }
    }
    public static class C extends B {
        public void foo() throws DerivedLevelTwoException {
            throw new DerivedLevelTwoException();
        }
    }
    public static class D extends C {
        public void foo() {}
    }
    public static void main(String[] args) {
        C myC = new C();
        A myA = (A)myC;
        try {
            myA.foo();
        } catch (BaseException e) { //不能用DerivedLevelTwoException
            e.printStackTrace();
        }
        A myA2 = new C();
        try {
            myA2.foo();
        } catch (BaseException e) { //不能用DerivedLevelTwoException
            e.printStackTrace();
        }
        try {
            myC.foo();
        } catch (DerivedLevelTwoException e) {
            e.printStackTrace();
        }
        D myD = new D();
        myD.foo();
    }
}
