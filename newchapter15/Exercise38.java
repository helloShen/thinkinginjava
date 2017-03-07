/**
 * Exercise38
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class Exercise38 {
    private enum CoffeeType {
        MOCHA, CAPPUCCINO, LATTE, MOKA;
        public String toString() {
            return name().toLowerCase();
        }
    }
    private static class Coffee {
        private CoffeeType type;
        private String name;
        public Coffee(CoffeeType type) {
            this.type = type;
            name = this.type.toString();
        }
        public CoffeeType getType() {
            return type;
        }
        public String changeName(String prefix) {
            String old = name;
            name = prefix + " " + name;
            return old;
        }
        public void drink() {
            System.out.println(name + " Yammy!");
        }
    }
    /**
     * 注意CoffeeDecorator虽然也是Coffee，但没有继承Coffee基类的成员字段。反而是把所有的操作都转到内部的被装饰组件上。
     * 类似封装了新的一层外部环境。Coffee还是有Coffee的所有函数，但是环境多了新的字段信息，以及新的方法。
     */
    private static class CoffeeDecorator extends Coffee {
        protected Coffee myCoffee;
        public CoffeeDecorator(Coffee c) {
            super(c.getType());
            myCoffee = c;
        }
        public String changeName(String prefix) {
            return myCoffee.changeName(prefix);
        }
        public void drink() {
            myCoffee.drink();
        }
    }
    private static class CoffeeDecoratorMilk extends CoffeeDecorator {
        private static final String NAME = "Milk";
        protected final String INGREDIENT = NAME;
        public CoffeeDecoratorMilk(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT); // 可以调用Coffee原有的方法，用新环境的信息。
        }
    }
    private static class CoffeeDecoratorFoam extends CoffeeDecorator {
        private static final String NAME = "Foam";
        protected final String INGREDIENT = NAME;
        public CoffeeDecoratorFoam(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }
    private static class CoffeeDecoratorChocolate extends CoffeeDecorator {
        private static final String NAME = "Chocolate";
        protected final String INGREDIENT = NAME;
        public CoffeeDecoratorChocolate(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }
    private static class CoffeeDecoratorCaramel extends CoffeeDecorator {
        private static final String NAME = "Caramel";
        protected final String INGREDIENT = NAME;
        public CoffeeDecoratorCaramel(Coffee c) {
            super(c);
            myCoffee.changeName(INGREDIENT);
        }
    }
    private static class CoffeeDecoratorCream extends CoffeeDecorator { // only cream decorator can draw
        private static final String NAME = "Cream";
        protected final String INGREDIENT = NAME;
        protected final String SHAPE;
        public CoffeeDecoratorCream(String shape, Coffee c) {
            super(c);
            SHAPE = shape;
            myCoffee.changeName(INGREDIENT);
        }
        public void draw() { // 也可以定义新的方法
            myCoffee.changeName(SHAPE);
        }
    }
    public static void main(String[] args) {
        CoffeeDecoratorCream myCoffee = new CoffeeDecoratorCream("HEART", new CoffeeDecoratorCaramel(new CoffeeDecoratorChocolate(new CoffeeDecoratorFoam(new CoffeeDecoratorMilk(new Coffee(CoffeeType.CAPPUCCINO))))));
        myCoffee.draw();
        myCoffee.drink();
    }
}
