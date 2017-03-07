/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class WaitPerson36 implements Runnable{
    private static final Random rand=new Random();
    private static int count=0;
    private final int id=++count;
    private final String name="Wait Person";
    public String toString(){return name+" #"+id;}

    private Restaurant36 restaurant;    //反向依赖注入
    private BlockingQueue<Client36> serviceQueue;    //反向依赖注入
    private BlockingQueue<OrderTicket36> orderQueue;    //反向依赖注入
    private BlockingQueue<Plate36> plateQueue;  //反向依赖注入
    public WaitPerson36(Restaurant36 r){
        restaurant=r;
        serviceQueue=restaurant.getServiceQueue();
        orderQueue=restaurant.getOrderQueue();
        plateQueue=restaurant.getPlateQueue();
    }
    
    public void run(){
        try{
            while(!Thread.interrupted()){
                //点菜
                Client36 client=serviceQueue.poll(1,TimeUnit.MILLISECONDS);    //不阻塞，等1微秒(否则没新客人的时候服务员死等，会死锁，永远不上菜。)
                if(client!=null){
                    OrderTicket36 ticket=new OrderTicket36(client,this);
                    ticket.addOrder(new Order36(Course36.randomAppet(),ticket));
                    ticket.addOrder(new Order36(Course36.randomMain(),ticket));
                    ticket.addOrder(new Order36(Course36.randomDessert(),ticket));
                    ticket.addOrder(new Order36(Course36.randomCoffee(),ticket));
                    System.out.println(ticket.readTicket());
                    orderQueue.put(ticket); //无界队列，不阻塞
                    client.keepTicket(ticket);
                }
                TimeUnit.MILLISECONDS.sleep(1);
                
                //上菜
                Plate36 plate=plateQueue.poll(1,TimeUnit.MILLISECONDS); //不阻塞，等1微秒（否则，新客人都在排队，厨师就没菜做，服务员等厨师就是死锁。）
                if(plate!=null){
                    Client36 client2=plate.getOrder().getTicket().getClient();
                    client2.getSpace().put(plate);    //阻塞。不会死锁。
                }
            }
        }catch(InterruptedException ie){
            System.out.println(this+" Service Interrupted!");
        }
    }
}