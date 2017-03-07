/**
 *  测试枚举型
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class TestEnum{
    public static enum Signal {
        GREEN(1){private String name="Green"; public String toString(){return this.name()+" is "+name;}},
        YELLOW(2),
        RED(3);
        
        private int id;
        Signal(int id){this.id=id;}
        
        public String toString(){return this.name();}
    }
    
    public static void showSignal(){
        for(Signal s:Signal.values()){
            System.out.println(s);
        }
    }
    
    public static void main(String[] args){
        showSignal();
    }
}