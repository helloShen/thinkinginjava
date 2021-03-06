package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;


class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}

class CoffeeFactory{
    public static Coffee creat(){
        int r=rand.nextInt(5);
        try{
            return facList.get(r).newInstance();
        }catch(InstantiationException ie){
            System.out.println(facList.get(r)+" cannot be initialized!");
            return null;
        }catch(IllegalAccessException iae){
            System.out.println("Check the access level of "+facList.get(r)+" class!");
            return null;
        }
    }
    
    private static Random rand=new Random();
    private static List<Class<? extends Coffee>> facList=new ArrayList<Class<? extends Coffee>>();
    static{
        facList.add(Latte.class);
        facList.add(Mocha.class);
        facList.add(Cappuccino.class);
        facList.add(Americano.class);
        facList.add(Breve.class);
    }
}

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
    
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            System.out.println(CoffeeFactory.creat());
        }
    }
}
