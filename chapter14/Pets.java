package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

class PetsCreator{
    private static List<Class<? extends Pets>> facList=new ArrayList<Class<? extends Pets>>();
    static{
        facList.add(Pets.class);
    }
    
    public static Pets creat(){
        try{
            return facList.get(0).newInstance();
        }catch(InstantiationException ie){
            System.out.println(facList.get(0)+" cannot be initialized!");
            return null;
        }catch(IllegalAccessException iae){
            System.out.println("Check the access level of "+facList.get(0)+" class!");
            return null;
        }
    }
}

public class Pets {
    public Pets(){count++;id=count;}
    public String toString(){return "Pet No."+id;}
    private long id=0l;
    private static long count=0l;
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            System.out.println(PetsCreator.creat());
        }
    }
}