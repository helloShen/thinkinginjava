/**
 *  Traffic light
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

//a enum with static next() method
enum CartoonCharacter2{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    public static Generator<CartoonCharacter2> generator(){
        return new Generator<CartoonCharacter2>(){
            private Random rand=new Random();
            public CartoonCharacter2 next(){
                return CartoonCharacter2.values()[rand.nextInt(values().length)];
            }
        };
    }

    public String toString(){return "CartoonCarracter:  "+this.name();}
}

public class CartoonCharacterGenerator{
    
    //method call Generator
    public static void giveMeNext(Generator<?> g){
        System.out.println(g.next());
    }
    
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            giveMeNext(CartoonCharacter2.generator());
        }
    }
}