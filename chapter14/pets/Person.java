package com.ciaoshen.thinkinjava.chapter14.pets;
import java.util.*;
import java.lang.reflect.*;

public class Person extends Individual {
    public Person(String name) {super(name);}

    public static void main(String[] args){
        Person p=new Person("Peter");
        System.out.println(p.toString());
    }
}
