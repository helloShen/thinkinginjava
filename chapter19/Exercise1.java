/**
 *  Traffic light
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;
import static com.ciaoshen.thinkinjava.chapter19.Signal.*;
import static com.ciaoshen.thinkinjava.chapter19.TrafficLight.*;

public class Exercise1{
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