/**
 * ReaderWriterList使用ReadLock和WriteLock
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;


public class ReaderWriterList<T> {
    private ArrayList<T> lockedList;    //main data structure
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    public ReaderWriterList(int size, T initialValue) {
        lockedList = new ArrayList<T>(Collections.nCopies(size, initialValue));
    }

    public T set(int index, T element) {
        Lock wlock = lock.writeLock();  //only 1 thread allowed to write
        wlock.lock();
        try {
            if(index<0 || index>=lockedList.size()){return null;}
            T oldValue=get(index);
            System.out.println(oldValue+" is changed to "+element+".   >>>"+lock.getWriteHoldCount()+" threads are waiting on the write lock!");
            return lockedList.set(index, element);
        } finally {
            wlock.unlock();
        }
    }

    public T get(int index) {
        Lock rlock = lock.readLock();   //multiple threads can read at the same time
        rlock.lock();
        try {
            if(index<0 || index>=lockedList.size()){return null;}
            System.out.println("The number is "+lockedList.get(index)+" and  >>>"+lock.getReadLockCount()+" threads is acquiring the read lock!");
            return lockedList.get(index);
        } finally {
            rlock.unlock();
        }
    }

    public String toString(){
        return lockedList.toString();
    }
    public static void main(String[] args) throws Exception {
        ReaderWriterList<Integer> test=new ReaderWriterList<Integer>(30, 1);
        System.out.println(test);
        test.set(10,100);
        test.get(10);
    }
}
