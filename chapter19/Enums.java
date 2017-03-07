/**
 *  Enum工具包
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Enums{
    private static Random rand=new Random();
    
    public static <T extends Enum<T>> T random(Class<T> c ){
        return random(c.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
    public static void main(String[] args){
        //System.out.println(random(CartoonCharacter2.class));
    }
}