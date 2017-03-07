/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;

public enum Course36 {
    /**
     *  枚举工厂：两层枚举的第二层
     */
    APPETIZER(Food36.Appetizer.class),
    MAINCOURSE(Food36.MainCourse.class),
    DESSERT(Food36.Dessert.class),
    COFFEE(Food36.Coffee.class);
    /**
     *  抽象构造
     */
    private static final Random rand=new Random();
    private Food36[] values;
    private Course36(Class<? extends Food36> kind) {
        values = kind.getEnumConstants();
    }
    public Food36 randomFood() {
        return values[rand.nextInt(values.length)];
    }
    /**
     *  对象管理
     */
    public static Course36 randomType(){
        return values()[rand.nextInt(values().length)];
    }
    public static Food36 random(){
        return randomType().randomFood();
    }
    public static Food36 randomAppet(){
        return APPETIZER.randomFood();
    }
    public static Food36 randomMain(){
        return MAINCOURSE.randomFood();
    }
    public static Food36 randomDessert(){
        return DESSERT.randomFood();
    }
    public static Food36 randomCoffee(){
        return COFFEE.randomFood();
    }

    public static void main(String[] args){
        Food36 food=Course36.random();
        System.out.println(food);
    }
}