/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Chef36 implements Runnable{
    private static int count=0;
    private final int id=++count;
    private final String name="Chef";
    public String toString(){return name+" #"+id;}
    
    private Restaurant36 restaurant;
    private BlockingQueue<OrderTicket36> orders;
    private BlockingQueue<Plate36> plates;
    public Chef36(Restaurant36 r){
        restaurant=r;
        orders=restaurant.getOrderQueue();
        plates=restaurant.getPlateQueue();
    }
    
    public void run(){
        try{
            while(!Thread.interrupted()){
                OrderTicket36 ticket=orders.take(); //阻塞
                List<Order36> list=ticket.getOrders();
                for(Order36 order:list){
                    Plate36 plate=new Plate36(order,this,ticket.getTable());
                    plates.put(plate);   //无界队列，不阻塞
                    TimeUnit.MILLISECONDS.sleep(1);
                    System.out.println(plate+" for "+ticket.getClient()+"at "+ticket.getTable()+" prepared!");
                }
            }
        }catch(InterruptedException ie){
            System.out.println(this+" interrupted!");
        }
    }
}