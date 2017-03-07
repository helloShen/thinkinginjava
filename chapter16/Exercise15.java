/**
 *  Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

class ContainerComparison {
    public static class SphereGenerator implements Generator<Sphere>{
        public Sphere next(){
            return new Sphere();
        }
    }
}

public class Exercise15{
    public static void main(String[] args){
        ContainerComparison.SphereGenerator sg=new ContainerComparison.SphereGenerator();
        Sphere[] ss=Generated.array(Sphere.class,sg,10);
        for(Sphere s:ss){
            System.out.println(s);
        }
    }
}