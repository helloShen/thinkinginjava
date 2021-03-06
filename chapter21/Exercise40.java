/**
 * Exercise40
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.locks.*;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class Exercise40<K,V>{
    //ReadWriteMap
    public class ReadWriteMap<K,V>{
        private Map<K,V> lockedMap=new HashMap<K,V>();
        private ReentrantReadWriteLock lock=new ReentrantReadWriteLock(true);   //fair lock
        private Random rand=new Random();
        public ReadWriteMap(Collection<K> c1, Collection<V> c2){
            if(c1.size()!=c2.size()){System.out.println("Check your collections!");return;}
            Iterator<K> iteKey=c1.iterator();
            Iterator<V> iteValue=c2.iterator();
            for(int i=0;i<c1.size();i++){
                lockedMap.put(iteKey.next(),iteValue.next());
            }
        }
        public String toString(){
            StringBuilder sb=new StringBuilder();
            for(Map.Entry<K,V> entry:lockedMap.entrySet()){
                sb.append("["+entry.getKey()+","+entry.getValue()+"] ");
            }
            return sb.toString();
        }
        public V read(K key){
            Lock readLock=lock.readLock();
            readLock.lock();
            try{
                return lockedMap.get(key);
            }finally{
                readLock.unlock();
            }
        }
        public void write(K key, V value){
            Lock writeLock=lock.writeLock();
            writeLock.lock();
            try{
                lockedMap.put(key,value);
            }finally{
                writeLock.unlock();
            }
        }
        public Set<Map.Entry<K,V>> entrySet(){return lockedMap.entrySet();}
        public ReentrantReadWriteLock getLock(){return lock;}
    }

    //Reader
    public class Reader implements Runnable{
        public void run(){
            //try{
                for(Map.Entry<Integer,String> entry:map.entrySet()){
                    String value=map.read(entry.getKey());
                    System.out.println(value+" is readed!");
                    if(map.getLock().getReadLockCount()>0){
                        System.out.println("   >>>"+map.getLock().getReadLockCount()+" threads is on Read Lock!");
                    }
                    //TimeUnit.MILLISECONDS.sleep(0);
                }
            //}catch(InterruptedException ie){
            //    System.out.println("Reader interrupted!");
            //}
            //System.out.println("Reader exit!");
        }
    }

    //Writer
    public class Writer implements Runnable{
        public void run(){
            //try{
                for(Map.Entry<Integer,String> entry:map.entrySet()){
                    char rc=(char)(((int)'a')+rand.nextInt(26));
                    String str=Character.toString(rc);
                    map.write(entry.getKey(),str);
                    System.out.println(entry.getValue()+" is changed to "+str+"!");
                    if(map.getLock().getWriteHoldCount()>0){
                        System.out.println("   >>>"+map.getLock().getWriteHoldCount()+" threads is on Write Lock!");
                    }
                    //TimeUnit.MILLISECONDS.sleep(0);
                }
            //}catch(InterruptedException ie){
            //    System.out.println("Writer interrupted!");
            //}
            //System.out.println("Writer exit!");
        }
    }

    //fields
    private ExecutorService exec=Executors.newCachedThreadPool();
    private Random rand=new Random();
    private ReadWriteMap<Integer,String> map;
    private final int SIZE;
    private final int readTime;
    private final int writeTime;
    private Exercise40(int size, int rt, int wt){
        SIZE=size;
        List<Integer> keys=new ArrayList<Integer>();
        List<String> values=new ArrayList<String>();
        for(int i=0;i<SIZE;i++){
            keys.add(rand.nextInt(1000));
            char rc=(char)(((int)'a')+rand.nextInt(26));
            values.add(Character.toString(rc));
        }
        map=new ReadWriteMap<Integer,String>(keys,values);
        readTime=rt;
        writeTime=wt;
        for(int i=0;i<readTime;i++){
            exec.execute(new Reader());
        }
        for(int i=0;i<writeTime;i++){
            exec.execute(new Writer());
        }
        try{
            TimeUnit.MILLISECONDS.sleep(5);
        }catch(InterruptedException ie){
            System.out.println("Test interrupted!");
        }
        exec.shutdownNow();
        System.out.println("Test exit!");
    }

    public static void main(String[] args){
        Exercise40 test=new Exercise40(50,100,2);
    }
}
