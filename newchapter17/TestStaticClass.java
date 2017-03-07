/**
 * Test static class
 */
package com.ciaoshen.thinkinjava.newchapter17;

final class TestStaticClass  {
    static class A {
        private void foo() {
            System.out.println("Method in Class B cannot visit me!");
        }
    }
    static class B {
        private static void staticVisitFooOfA() {
            System.out.print("Static method of Class B visit: ");
            A a = new A();
            a.foo();
        }
        private void visitFooOfA() {
            System.out.print("Instance of Class B visit: ");
            A a = new A();
            a.foo();
        }
    }
    public static void main(String[] args) {
        B.staticVisitFooOfA();
        B b = new B();
        b.visitFooOfA();
    }
}
