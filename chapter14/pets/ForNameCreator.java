/**
 * Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter14.pets;
import java.util.*;
import java.lang.reflect.*;

public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types=new ArrayList<Class<? extends Pet>>();
    private static final String[] petsName={
        "com.ciaoshen.thinkinjava.chapter14.pets.Mutt",
        "com.ciaoshen.thinkinjava.chapter14.pets.Pug",
        "com.ciaoshen.thinkinjava.chapter14.pets.EgyptianMau",
        "com.ciaoshen.thinkinjava.chapter14.pets.Manx",
        "com.ciaoshen.thinkinjava.chapter14.pets.Cymric",
        "com.ciaoshen.thinkinjava.chapter14.pets.Rat",
        "com.ciaoshen.thinkinjava.chapter14.pets.Mouse",
        "com.ciaoshen.thinkinjava.chapter14.pets.Hamster",
        "com.ciaoshen.thinkinjava.chapter14.pets.Gerbil"
    };
    @SuppressWarnings("unchecked")
    private static void load(){
        try{
            for(String name:petsName){
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch(ClassNotFoundException cnfe){
            throw new RuntimeException(cnfe);
        }
    }

    static { load(); }

    public List<Class<? extends Pet>> types(){
        return types;
    }
    public static void main(String[] args){
        ForNameCreator myCreator=new ForNameCreator();
        List<Class<? extends Pet>> types=myCreator.types();
        for(Class<? extends Pet> classObject:types){
            System.out.println(classObject.getSimpleName());
        }
        List<Pet> list=myCreator.arrayList(10);
        for(Pet pet:list){
            System.out.print("["+pet+"]");
        }
    }
}
