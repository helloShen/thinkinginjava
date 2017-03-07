/**
 *  测试枚举型
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public enum Light {
    GREEN(1){public void show(){System.out.println("Green");}},
    YELLOW(2){public void show(){System.out.println("Yellow");}},
    RED(3){public void show(){System.out.println("Red");}};

    private int id;
    private Light(int id){this.id=id;}
    public abstract void show();
}