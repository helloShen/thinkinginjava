/**
 *  Exercise 19
 */

package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

class Toy2 {
    public Toy2() {}
    public Toy2(int i) {System.out.println("Toy "+i+" created!");}
}


public class ToyTest2 {
    static void printInfo(Class<?> cc) {
        System.out.println("Class name: " + cc.getName() +
                           " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Constructor<?>[] cs=Toy2.class.getConstructors();
        for(Constructor<?> c : cs){
            if(c.getParameterTypes().length==1){
                Class<?>[] paraType=c.getParameterTypes();
                if(paraType[0]==int.class){
                    try{
                        Object o=c.newInstance(1);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
}