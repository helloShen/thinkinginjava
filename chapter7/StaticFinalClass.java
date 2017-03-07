/**
 *  讨论Final字段的初始化
 *  证明static final和final的区别
 *  成员按初始化顺序排列。没有按常规的访问权限排序。
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;

/**
 *  The only public class
 */
public class StaticFinalClass {
    
    /**************************
     * Final常量只能被赋值一次：
     *   1. 要么在声明的时候
     *   2. 要么在构造函数里
     *   3. 要么在block里
     *
     * !!注意：所以Final基本型字段声明的时候系统不会给默认值。
              因为系统给了默认值的话，我们无法再赋值了。
     *************************/
    
    //FINALFINAL 1号赋值点：声明的时候
    final public int FINALFINAL;
    
    //FINALFINAL 2号赋值点：构造函数
    public StaticFinalClass() {
        this.FINALFINAL=101;
        //this.FINALFINAL=102;  //一次赋值以后，不能再重新赋值
        //this.FINALFINAL=103;  // 这就是Final的意义。
        //StaticFinalClass.FINALSTATIC=1001;
    }
    
    //FINALFINAL 3号赋值点：block
    {
        //this.FINALFINAL=104;  //一次赋值以后，不能再重新赋值
                                // 这就是Final的意义。
    }
    
    /**************************
     * ！！！注意：Final static全局静态常量，不能在构造函数里声明。
     * 因为，static意味着构造函数每创建一个实例都会为其赋值。 
     * 但final意味着它只能被赋值一次，所以矛盾。
     *************************/
    
    //FINALSTATIC 1号赋值点：声明的时候
    final public static int FINALSTATIC;
    
    //FINALSTATIC 2号赋值点：static block
    static {
        FINALSTATIC=1000;
    }
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args) {
        StaticFinalClass newTest=new StaticFinalClass();
        System.out.println(newTest.FINALFINAL);
        System.out.println(StaticFinalClass.FINALSTATIC);
    }
}
