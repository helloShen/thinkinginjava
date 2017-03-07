/**
 *  Exercise 7
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

class Candy {
    static { System.out.println("Loading Candy"); }
}
class Gum {
    static { System.out.println("Loading Gum"); }
}
class Cookie {
    static { System.out.println("Loading Cookie"); }
}

public class SweetShop {
    public static void main(String[] args) {
        try {
            Class<?> c=Class.forName(args[0]);
            Object o=c.newInstance();
        } catch(ClassNotFoundException cne) {
            System.out.println("Couldn’t find this Class! Please check your name!");
        } catch(InstantiationException ie) {
            System.out.println("Error during init of object! Must have a default constructor!");
        } catch(IllegalAccessException iae){
            System.out.println("Error during init of object! Please check the accessibility of constructor!");
        }
    }
}