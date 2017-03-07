/**
 *  Exercise 31
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class ChopstickBuck{
    private final int num;
    private volatile int availableNum;
    public ChopstickBuck(int num){
        this.num=num;
        availableNum=num;
    }
    //只要拿两根筷子的动作是原子性的，就不会死锁
    public synchronized void take() throws InterruptedException{
        for(int i=0;i<2;i++){
            while(availableNum==0){
                wait();
            }
            availableNum--;
        }
    }
    //同理
    public synchronized void drop() throws InterruptedException{
        availableNum++;availableNum++;
        notifyAll();
    }
}