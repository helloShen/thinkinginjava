package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    public static Part createRandom(){
        int n = rand.nextInt(partFactories.size());
        try{
            return partFactories.get(n).newInstance();
        }catch(InstantiationException ie){
            System.out.println(partFactories.get(n)+" cannot be initialized!");
            return null;
        }catch(IllegalAccessException iae){
            System.out.println("Check the access level of "+partFactories.get(n)+" class!");
            return null;
        }
    }
    private static List<Class<? extends Part>> partFactories = new ArrayList<Class<? extends Part>>();
    private static Random rand = new Random();
    //NULL Singleton is here
    public static final Part NULL=new Part();
    static {
        partFactories.add(FuelFilter.class);
        partFactories.add(AirFilter.class);
        partFactories.add(CabinAirFilter.class);
        partFactories.add(OilFilter.class);
        partFactories.add(FanBelt.class);
        partFactories.add(PowerSteeringBelt.class);
        partFactories.add(GeneratorBelt.class);
    }    
}

class Filter extends Part {}
class FuelFilter extends Filter {}
class AirFilter extends Filter {}
class CabinAirFilter extends Filter {}
class OilFilter extends Filter {}
class Belt extends Part {}
class FanBelt extends Belt {}
class GeneratorBelt extends Belt {}
class PowerSteeringBelt extends Belt {}

public class RegisteredFactories {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(Part.createRandom());
        }
        //print the NULL Singleton
        System.out.println(Part.NULL);
    }
}
