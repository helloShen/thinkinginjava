/**
 *  Exercise 26
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

abstract class Instrument{
    public void play(){System.out.println(this.getClass().getSimpleName()+" is playing!");}
}

class Percussion extends Instrument{}

class Stringed extends Instrument{}

class Wind extends Instrument{
    public void cleanSpitValve(){System.out.println(this.getClass().getSimpleName()+" is cleaning the spit valve!");}
}

public class SpitValve{
    public static void main(String[] args){
        Instrument ip=new Percussion();
        Instrument is=new Stringed();
        Instrument iw=new Wind();
        
        ip.play();
        is.play();
        iw.play();
        
        try{
            Class<?> c=iw.getClass();
            Method m=c.getMethod("cleanSpitValve");
            m.invoke(iw);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
