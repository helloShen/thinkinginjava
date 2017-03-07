/**
 *  Exercise 29 -chapter 12
 *  RuntimeException don't need try{}catch{}block
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

//Inning的3个异常
class NewBaseballException extends RuntimeException {private static final long serialVersionUID=0;}
class NewFoul extends NewBaseballException {private static final long serialVersionUID=0;}
class NewStrike extends NewBaseballException {private static final long serialVersionUID=0;}

//Inning
abstract class NewInning {
    public NewInning() throws NewBaseballException {
        //throw new BaseballException();
    }
    public void event() throws NewBaseballException {
        // Doesn’t actually have to throw anything
    }
    public abstract void atBat() throws NewStrike, NewFoul;
    public void walk() throws NewUmpireArgumentException {} // Throws no checked exceptions
}

//Storm的3个异常
class NewStormException extends RuntimeException {private static final long serialVersionUID=0;}
class NewRainedOut extends NewStormException {private static final long serialVersionUID=0;}
class NewPopFoul extends NewFoul {private static final long serialVersionUID=0;}

//Storm
interface NewStorm {
    public void event() throws NewRainedOut;
    public void rainHard() throws NewRainedOut;
}

//我加的UmpireArgument Exception
//可以加在两个地方：
//  1) 可以直接加在派生类的构造函数的异常声明里
//  2) 想加在派生类普通方法的异常声明里，必须先在基类同方法的异常声明里加上这个异常类型
class NewUmpireArgumentException extends RuntimeException {private static final long serialVersionUID=0;}

//Inning是爹，Storm是娘
public class NewStormInning extends NewInning implements NewStorm {
    //只有构造函数可以在基类异常声明基础上加新异常
    public NewStormInning() throws NewRainedOut, NewBaseballException, NewUmpireArgumentException {throw new NewUmpireArgumentException();}
    //只有构造函数可以在基类异常声明基础上加新异常
    public NewStormInning(String s) throws NewFoul, NewBaseballException {}
    // 子类派生方法的异常是基类声明异常的子集
    //! void walk() throws PopFoul {} //Compile error
    public void walk() throws NewUmpireArgumentException {}   //想这么加，必须在基类的walk()里也加一个UmpireArgumentException声明
    // 接口声明的异常，在基类里没有的时候，听基类的
    //! public void event() throws RainedOut {}
    // 基类中没有的方法，派生类可以加异常
    public void rainHard() throws NewRainedOut {}
    // 派生类的异常可以比基类少，但不能多
    public void event() {}
    // 基类声明异常的派生异常可以在派生类出现
    public void atBat() throws NewPopFoul {}
    public static void main(String[] args) {
        NewStormInning si = new NewStormInning();
        si.atBat();
        
        //向上转型
        NewInning i = new NewStormInning();
        i.atBat();
    }
}