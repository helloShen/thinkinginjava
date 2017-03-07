/**
 *  Exercise 20 -chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

//Inning的3个异常
class BaseballException extends Exception {private static final long serialVersionUID=0;}
class Foul extends BaseballException {private static final long serialVersionUID=0;}
class Strike extends BaseballException {private static final long serialVersionUID=0;}

//Inning
abstract class Inning {
    public Inning() throws BaseballException {
        //throw new BaseballException();
    }
    public void event() throws BaseballException {
        // Doesn’t actually have to throw anything
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() throws UmpireArgumentException {} // Throws no checked exceptions
}

//Storm的3个异常
class StormException extends Exception {private static final long serialVersionUID=0;}
class RainedOut extends StormException {private static final long serialVersionUID=0;}
class PopFoul extends Foul {private static final long serialVersionUID=0;}

//Storm
interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

//我加的UmpireArgument Exception
//可以加在两个地方：
//  1) 可以直接加在派生类的构造函数的异常声明里
//  2) 想加在派生类普通方法的异常声明里，必须先在基类同方法的异常声明里加上这个异常类型
class UmpireArgumentException extends Exception {private static final long serialVersionUID=0;}

//Inning是爹，Storm是娘
public class StormyInning extends Inning implements Storm {
    //只有构造函数可以在基类异常声明基础上加新异常
    public StormyInning() throws RainedOut, BaseballException, UmpireArgumentException {throw new UmpireArgumentException();}
    //只有构造函数可以在基类异常声明基础上加新异常
    public StormyInning(String s) throws Foul, BaseballException {}
    // 子类派生方法的异常是基类声明异常的子集
    //! void walk() throws PopFoul {} //Compile error
    public void walk() throws UmpireArgumentException {}   //想这么加，必须在基类的walk()里也加一个UmpireArgumentException声明
    // 接口声明的异常，在基类里没有的时候，听基类的
    //! public void event() throws RainedOut {}
    // 基类中没有的方法，派生类可以加异常
    public void rainHard() throws RainedOut {}
    // 派生类的异常可以比基类少，但不能多
    public void event() {}
    // 基类声明异常的派生异常可以在派生类出现
    public void atBat() throws PopFoul {}
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        } catch(UmpireArgumentException e) {
            System.out.println("Umpire argument exception");
        }
        
        try {
            //向上转型
            Inning i = new StormyInning();
            i.atBat();
            // 基类和接口声明的异常必须被处理，没有声明的Strike和Foul就不需要处理
        //} catch(Strike e) {
        //    System.out.println("Strike");
        //} catch(Foul e) {
        //    System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        } catch(UmpireArgumentException e) {
            System.out.println("Umpire argument exception");
        }
    }
}