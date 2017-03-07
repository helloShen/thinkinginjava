/**
 *  Traffic light
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;
import static com.ciaoshen.thinkinjava.chapter19.Signal.*;

public class TrafficLight{
    private static Signal color=RED;
    
    public static void change(){
        switch(color){
            case RED:
                color=GREEN;
                break;
            case YELLOW:
                color=RED;
                break;
            case GREEN:
                color=YELLOW;
                break;
        }
    }
    public static void look(){System.out.println(color);}
    
    public static void main(String[] args){
        for(Signal s:values()){
            System.out.println(s+": "+s.getDescription());
        }
        for(int i=0;i<10;i++){
            change();
            look();
        }
    }
}