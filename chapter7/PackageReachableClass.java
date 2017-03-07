/**
 *  一个java文件里塞多个非公开类，叫Auxiliary Class（辅助类），虽然包内也能调用，但这不是一个好的编程风格。最好为每个类都创建一个单独的java文件。
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;

//Non public class
//It should be package reachable
class PackageReachableClass {
    //default constructor
    PackageReachableClass(){
        System.out.println("Hi, I am PackageReachableClass.");
    }
}