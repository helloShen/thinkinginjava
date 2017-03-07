/**
 *  Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class SphereGenerator implements Generator<Sphere>{
    public Sphere next(){
        return new Sphere();
    }
}