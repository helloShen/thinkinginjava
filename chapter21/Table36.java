/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Table36 {
    private static int count=0;
    private final int id=++count;
    private final String name="Table";
    public String toString(){return name+" #"+id;}
    private final int MAX_CLIENT;
    private volatile int available;
    private BlockingQueue<Order36> orderTicket;
    private Restaurant36 restaurant;    //反向依赖注入
    public Table36(int size,Restaurant36 restaurant){
        MAX_CLIENT=size;
        available=size;
        orderTicket=new LinkedBlockingQueue<Order36>();
        this.restaurant=restaurant;
        System.out.println(this+" created! "+left()+" seats in total!");
    }
    public boolean available(){return available>0;}
    public int left(){return available;}
    public synchronized void oneSit(Client36 client){
        if(!available()){System.out.println("Error, "+this+" not available for "+client);return;}
        --available;
        if(available()){
            restaurant.moreTable(this);
        }
    }
    public synchronized void oneLeave(Client36 client){
        if(available>=MAX_CLIENT){System.out.println("Error, no client on "+this+"!");return;}
        ++available;
        if(available==1){
            restaurant.moreTable(this);
        }
    }
    public static void main(String[] args){
        Table36 table=new Table36(3,new Restaurant36(5,5));
    }
}