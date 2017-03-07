/**
 *  测试枚举
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public enum Light{
    GREEN{public void show(){System.out.println("Green");}},
    YELLOW{public void show(){System.out.println("Yellow");}},
    RED{public void show(){System.out.println("Red");}};
}

