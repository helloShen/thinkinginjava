/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class OrderTicket36 {
    private static final Random rand=new Random();
    private static int count=0;
    private final int id=++count;
    private final String name="Order ticket";
    public String toString(){return name+" #"+id;}
    
    private List<Order36> orders=new ArrayList<Order36>();
    private final Table36 table;
    private final Client36 client;
    private final WaitPerson36 waiter;
    private float totalPrice=0.0f;
    public OrderTicket36(Table36 t, Client36 c, WaitPerson36 w){
        table=t;
        client=c;
        waiter=w;
    }
    public OrderTicket36(Client36 c, WaitPerson36 w){
        table=c.getTable();
        client=c;
        waiter=w;
    }
    public Table36 getTable(){return table;}
    public Client36 getClient(){return client;}
    public float getTotalPrice(){return totalPrice;}
    public WaitPerson36 getWaiter(){return waiter;}
    public void addOrder(Order36 order){
        orders.add(order);
        totalPrice+=order.getPrice();
    }
    public List<Order36> getOrders(){return orders;}
    public String readTicket(){
        StringBuilder sb=new StringBuilder();
        sb.append(client+" wants to eat: ");
        for(Order36 order:orders){
            sb.append(order.toString()+"; ");
        }
        return sb.toString();
    }
}
    