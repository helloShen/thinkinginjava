/**
 *  Exercise 34 Exchanger
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise34 {
    class ExchangerProducer<T> implements Runnable {
        private Generator<T> generator;
        private Exchanger<List<T>> exchanger;
        private List<T> holder;
        ExchangerProducer(Exchanger<List<T>> exchg,Generator<T> gen, List<T> holder) {
            exchanger = exchg;
            generator = gen;
            this.holder = holder;
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    for(int i = 0; i < Exercise34.size; i++)
                        holder.add(generator.next());
                    // Exchange full for empty:
                    holder = exchanger.exchange(holder);
                }
            } catch(InterruptedException e) {
                System.out.println("Producer Thread interrupted!");
            } finally{
                System.out.println("Producer Thread exit!");
            }
        }
    }
    class ExchangerConsumer<T> implements Runnable {
        private Exchanger<List<T>> exchanger;
        private List<T> holder;
        private volatile T value;
        ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
            exchanger = ex;
            this.holder = holder;
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    holder = exchanger.exchange(holder);
                    for(T x : holder) {
                        value = x; // Fetch out value
                        holder.remove(x); // OK for CopyOnWriteArrayList
                        System.out.println(x+" eaten!");
                    }
                }
            } catch(InterruptedException e) {
                System.out.println("Consumer Thread interrupted!");
            } finally{
                System.out.println("Consumer Thread exit!");
                System.out.println("Final value: " + value);
            }
        }
    }
    static int count=0;
    class Pancake{
        private int id;
        public Pancake(){
            id=++count;
            System.out.println(this+" cooked!");
        }
        public String toString(){return "Pancake#"+id;}
    }
    interface Generator<T>{public T next();}
    class Oven implements Generator<Pancake>{
        public Pancake next(){
            return new Pancake();
        }
    }

    static int size = 10;
    static int delay = 5; // Seconds
    public static void main(String[] args) throws Exception {
        if(args.length > 0){
            size = new Integer(args[0]);
        }
        if(args.length > 1){
            delay = new Integer(args[1]);
        }
        Exercise34 ex=new Exercise34();
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Pancake>> xc = new Exchanger<List<Pancake>>();
        List<Pancake>
        producerPlate = new CopyOnWriteArrayList<Pancake>(),
        consumerPlate = new CopyOnWriteArrayList<Pancake>();
        exec.execute(ex.new ExchangerProducer<Pancake>(xc,ex.new Oven(), producerPlate));
        exec.execute(ex.new ExchangerConsumer<Pancake>(xc,consumerPlate));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}