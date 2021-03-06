/**
 *  Exercise 3-5
 */

package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

/**
 *  Base Class
 */
abstract class Shape {
    public void draw() { System.out.println(this + ".draw()"); }
    public void rotate(){System.out.println(this + ".rotate()");}
    public void highlight(){flag=true;}
    public void highlightOff(){flag=false;}
    public boolean isHighlighted(){return flag;}
    abstract public String toString();
    private boolean flag=false;
}

/**
 *  Derived Class
 */
class Circle extends Shape {
    public String toString() {
        return (isHighlighted()? "H":"UnH")+"ighlited "+"Circle";
    }
}
class Oval extends Circle {
    public String toString() {
        return (isHighlighted()? "H":"UnH")+"ighlited "+"Oval";
    }
}
class Square extends Shape {
    public String toString() {
        return (isHighlighted()? "H":"UnH")+"ighlited "+"Square";
    }
}
class Triangle extends Shape {
    public String toString() {
        return (isHighlighted()? "H":"UnH")+"ighlited "+"Triangle";
    }
}
class Rhomboid extends Shape {
    public String toString() {
        return (isHighlighted()? "H":"UnH")+"ighlited "+"Rhomboid";
    }
}

/**
 *  Processing Class
 */
public class Shapes {
    public static void rotate(Shape s){
        if(!(s instanceof Circle)){
            s.rotate();
        }
    }
    public static void highlight(Shape s){
        s.highlight();
        System.out.println(s);
    }
    public static void highlightOff(Shape s){
        s.highlightOff();
        System.out.println(s);
    }
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for(Shape shape : shapeList){
            shape.draw();
            System.out.println(shape.getClass().getSimpleName());
            if(shape instanceof Rhomboid){
                Rhomboid r=(Rhomboid)shape;
            }else{
                //Circle c=(Circle)shape;   //不能把不是圆形的形状向下转型成圆形
            }
            Shapes.rotate(shape);
            Shapes.highlight(shape);
        }
        
    }
}