/**
 * Test inherit
 */
package com.ciaoshen.thinkinjava.newchapter17;

final class TestInherit {
    private static class BaseClass {
        private String privateField = "I am privateField in BaseClass!";
        public String getPrivateField() {
            return privateField;
        }
        public static void staticMethod() {
            System.out.println("I am static method in BaseClass!");
        }
        private static void privateStaticMethod() {
            System.out.println("I am private static method in BaseClass!");
        }
    }
    private static class DerivedClass extends BaseClass {
        public void visitPrivateFieldInBaseClass() {
            System.out.println("DerivedClass Visit private field in BaseClass: " + getPrivateField());
        }
    }
    public static void main(String[] args) {
        DerivedClass dc = new DerivedClass();
        dc.visitPrivateFieldInBaseClass();
        DerivedClass.staticMethod();
        // DerivedClass.privateStaticMethod(); // ERROR: can not inherit private method from BaseClass!
    }
}
