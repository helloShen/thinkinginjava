/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.*;

public class Order36 extends Thing36{
    private static int count=0;
    private final int id=++count;
    private final String name="Order";
    public String toString(){return name+" #"+id+" "+food;}
    
    private final Food36 food;
    private final OrderTicket36 ticket;
    public Order36(Food36 f, OrderTicket36 t){
        food=f;
        ticket=t;
    }
    public Food36 getFood(){return food;}
    public OrderTicket36 getTicket(){return ticket;}
    public float getPrice(){return food.getPrice();}
}