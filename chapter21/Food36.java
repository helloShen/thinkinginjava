/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;

public interface Food36 {   //两层枚举的第一层
    public float getPrice();
    enum Appetizer implements Food36 {
        SALAD(15.5f), SOUP(10.8f), SPRING_ROLLS(8.8f);
        private float price=0.0f;
        private Appetizer(float p){price=p;}
        public String toString(){return EnumPrinter.getText(this)+"("+price+")";}
        public float getPrice(){return price;}
    }
    enum MainCourse implements Food36 {
        LASAGNE(28.5f), BURRITO(35.9f), PAD_THAI(16.9f),
        LENTILS(21.0f), HUMMOUS(12.5f), VINDALOO(39.9f);
        private float price=0.0f;
        private MainCourse(float p){price=p;}
        public String toString(){return EnumPrinter.getText(this)+"("+price+")";}
        public float getPrice(){return price;}
    }
    enum Dessert implements Food36 {
        TIRAMISU(9.9f), GELATO(5.6f), BLACK_FOREST_CAKE(8.7f),
        FRUIT(15.5f), CREME_CARAMEL(5.5f);
        private float price=0.0f;
        private Dessert(float p){price=p;}
        public String toString(){return EnumPrinter.getText(this)+"("+price+")";}
        public float getPrice(){return price;}
    }
    enum Coffee implements Food36 {
        BLACK_COFFEE(6.5f), DECAF_COFFEE(4.3f), ESPRESSO(5.0f),
        LATTE(3.1f), CAPPUCCINO(4.3f), TEA(2.8f), HERB_TEA(3.0f);
        private float price=0.0f;
        private Coffee(float p){price=p;}
        public String toString(){return EnumPrinter.getText(this)+"("+price+")";}
        public float getPrice(){return price;}
    }
    public class EnumPrinter{   //依赖注入
        public static String getText(Enum<?> e){return "["+e.getClass().getSimpleName()+"-"+e.name()+"]";}
    }

    public static void main(String[] args){
        System.out.println(Appetizer.SALAD);
    }
}
