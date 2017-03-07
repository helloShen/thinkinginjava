/**
 *  Test Lock
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class TestLock{
    private volatile int num=0;
    public void increment(){
        //synchronized(this){   //可以锁这里
            num++; Thread.yield(); num++;
        //}
    }
    public int getNum(){
        //synchronized(this){   //可以锁这里
            return num;
        //}
    }
}