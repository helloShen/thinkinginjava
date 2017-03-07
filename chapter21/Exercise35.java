/**
 *  Exercise 35 Web服务器负载测试
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise35 {
    //准备运行测试
    static final int MAX_LINE_SIZE = 100;
    static final int ADJUSTMENT_PERIOD = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // If line is too long, customers will leave:
        WebClient.RequestLine requests = new WebClient.RequestLine(MAX_LINE_SIZE);
        WebClient.RequestGenerator gen=new WebClient.RequestGenerator(requests);
        exec.execute(gen);
        // Manager will add and remove tellers as necessary:
        WebServer.Server server=new WebServer.Server(exec, requests, ADJUSTMENT_PERIOD, 30);
        exec.execute(server);
        // print the result
        exec.execute(new Runnable(){
            public void run(){
                try{
                    while(!Thread.interrupted()){
                        TimeUnit.MILLISECONDS.sleep(20);
                        System.out.println(gen.showBalance()+" ["+requests.size()+"/"+MAX_LINE_SIZE+"]"+server);
                    }
                }catch(InterruptedException ie){
                    System.out.println("Print interrupted!");
                }finally{
                    System.out.println("Printer exit!");
                }
                
            }
        });
        if(args.length > 0){ // Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else {
            System.out.println("Press ‘Enter’ to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}