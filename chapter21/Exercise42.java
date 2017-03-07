/**
 * Exercise 42: rebuild WaxOMatic using Active Object
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise42{
    private static int carCount=0;
    private static int robotCount=0;
    private static List<ActiveCarRobot> robots=new ArrayList<ActiveCarRobot>();

    public class Car{
        private final int id=++carCount;
        private boolean waxOn=false;
        public void waxOn(){
            if(waxOn){System.out.println("Error, the wax already on!");return;}
            waxOn=true;
        }
        public void waxOff(){
            if(!waxOn){System.out.println("Error, should waxOn before waxOff!");return;}
            waxOn=false;
        }
        public String toString(){return "Car#"+id;}
    }

    public class ActiveCarRobot implements Runnable{
        private final int id=++robotCount;
        private final ExecutorService exec=Executors.newSingleThreadExecutor();
        private List<Future<String>> results=new CopyOnWriteArrayList<Future<String>>();
        private Car car;
        public ActiveCarRobot(Car c){car=c;robots.add(this);}
        public String toString(){return "Robot#"+id;}

        public void run(){
            for(int i=0;i<10;i++){
                results.add(waxOn());
                sleep(10);
                results.add(waxOff());
            }
            showResults();
            shutdown();
        }
        public Future<String> waxOn(){
            return exec.submit(new Callable<String>(){
                public String call(){
                    sleep(10);
                    car.waxOn();
                    return "    "+car+" wax on by "+ActiveCarRobot.this;
                }
            });
        }
        public Future<String> waxOff(){
            return exec.submit(new Callable<String>(){
                public String call(){
                    sleep(10);
                    car.waxOff();
                    return "    "+car+" wax off by "+ActiveCarRobot.this;
                }
            });
        }
        public void sleep(int time){
            try{
                TimeUnit.MILLISECONDS.sleep(time);
            }catch(InterruptedException ie){
                System.out.println(this+" interrupted!");
            }
        }
        public void shutdown(){exec.shutdownNow();}
        public void showResults(){
            long endAt=System.currentTimeMillis()+5000;
            while(true){
                for(Future<String> f:results){
                    if(f.isDone()){
                        try{
                            System.out.println(f.get());
                        }catch(Exception e){
                            System.out.println("Error when reading the results!");
                        }
                    }
                    results.remove(f);
                }
                if(System.currentTimeMillis()>=endAt){break;}
            }
        }
    }

    public static void main(String[] args){
        Exercise42 test=new Exercise42();
        ExecutorService exec=Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            exec.execute(test.new ActiveCarRobot(test.new Car()));
        }
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(InterruptedException ie){
            System.out.println("Test interrupted!");
        }
        exec.shutdownNow();
    }
}
