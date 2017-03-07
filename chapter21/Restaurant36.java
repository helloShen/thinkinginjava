/**
 *  Exercise 36
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Restaurant36 implements Runnable{
    private static final Random rand=new Random();
    private static int count=0;
    private final int id=++count;
    private final String name="Restaurant";
    public String toString(){return name+" #"+id;}
    private int tableNum;
    private int tableSize;
    private BlockingQueue<Table36> tables;
    private BlockingQueue<Client36> serviceQueue;
    private BlockingQueue<OrderTicket36> orderQueue;
    private BlockingQueue<Plate36> plateQueue;
    public Restaurant36(int tableNum, int tableSize){
        this.tableNum=tableNum;
        this.tableSize=tableSize;
        tables=new ArrayBlockingQueue<Table36>(tableNum);
        serviceQueue=new LinkedBlockingQueue<Client36>();
        orderQueue=new LinkedBlockingQueue<OrderTicket36>();
        plateQueue=new LinkedBlockingQueue<Plate36>();
    }
    public BlockingQueue<Table36> getTables(){return tables;}
    public BlockingQueue<Client36> getServiceQueue(){return serviceQueue;}
    public BlockingQueue<OrderTicket36> getOrderQueue(){return orderQueue;}
    public BlockingQueue<Plate36> getPlateQueue(){return plateQueue;}

    public void moreTable(Table36 table){
        try{
            tables.put(table);   //访问同步阻塞队列
        }catch(InterruptedException ie){
            System.out.println("Table Insertion interrupted!");
        }
    }
    public void run(){
        for(int i=0;i<tableNum;i++){
            moreTable(new Table36(rand.nextInt(tableSize)+1,this));
            if(Thread.interrupted()){
                System.out.println("Restaurant initialization interrupted!");
                break;
            }
        }
    }
}
