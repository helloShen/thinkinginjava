/**
 *  I repeat the CarAssemblyLine.
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class Exercise37{
    /**
     *  Car
     */
    private int carId=0;
    public class Car{
        private int id;
        private boolean engine=false, drivenTrain=false, wheels=false, exhaust=false, body=false, fender=false;
        public Car(int num){id=num;}
        public Car(){id=++carId;}
        public int getId(){return id;}
        public void addEngine(){engine=true;}
        public void addDriveTrain(){drivenTrain=true;}
        public void addWheels(){wheels=true;}
        public void addExhaust(){exhaust=true;}
        public void addBody(){body=true;}
        public void addFender(){fender=true;}
        public String toString(){
            return "[Car #"+id+(engine? " Engine":"")+(drivenTrain? " DrivenTrain":"")+(wheels? " Wheels":"")+(exhaust? " Exhaust":"")+(body? " Body":"")+(fender? " Fender":"")+"]";
        }
    }

    /**
     * ChassisBuilder
     */
    public class ChassisBuilder implements Runnable{
        //carqueue
        private CarQueue carQueue;
        public ChassisBuilder(CarQueue queue){
            carQueue=queue;
        }

        //Thread
        public void run(){
            try{
                while(!Thread.interrupted()){
                    Car car=new Car();
                    System.out.println(car+" created!");
                    carQueue.put(car);    //blocked
                    System.out.println(car+" into the car queue.");
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                System.out.println("CharssisBuilder exit correctly!");
            }catch(InterruptedException ie){
                System.out.println("CharssisBuilder is interrupted!");
            }
        }
    }

    /**
     * CarQueue
     */
     public class CarQueue extends LinkedBlockingQueue<Car>{
         private static final long serialVersionUID=0l;
     }

    /**
     * Robot
     */
    private int robotId=0;
    public abstract class Robot implements Runnable{
        protected int id=++robotId;
        private RobotPool pool;
        public Robot(RobotPool p){pool=p;}
        public String toString(){return "Robot #"+id+": "+getClass().getSimpleName();}
        public synchronized void powerDown() throws InterruptedException{   //ready to work
            engage=false;
            assembler=null;
            pool.release(this);
            System.out.println(this+" is ready to work!");
            while(engage==false){
                wait();
            }
        }
        protected Assembler assembler;
        public Robot assignAssembler(Assembler a){
            assembler=a;
            System.out.println(this+" binding with "+a);
            return this;
        }
        protected boolean engage=false;
        public synchronized void engage(){engage=true;notifyAll();} //finish powerdown
        public abstract void performService() throws InterruptedException;  //work
        public void run(){
            try{
                while(!Thread.interrupted()){
                    powerDown();
                    performService();
                    assembler.getBarrier().await();
                }
            }catch(InterruptedException ie){
                System.out.println(this+" interrupted!");
            }catch(BrokenBarrierException bbe){
                System.out.println(this+" barrier broken!");
            }
            System.out.println(this+" exit!");
        }
    }
    public class EngineRobot extends Robot{
        public EngineRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing engine for "+assembler.getCar());
            assembler.getCar().addEngine();
        }
    }
    public class DriveTrainRobot extends Robot{
        public DriveTrainRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing Drive Train for "+assembler.getCar());
            assembler.getCar().addDriveTrain();
        }
    }
    public class WheelRobot extends Robot{
        public WheelRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing wheel for "+assembler.getCar());
            assembler.getCar().addWheels();
        }
    }
    public class ExhaustRobot extends Robot{
        public ExhaustRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing exhaust system for "+assembler.getCar());
            assembler.getCar().addExhaust();
        }
    }
    public class BodyRobot extends Robot{
        public BodyRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing body of car for "+assembler.getCar());
            assembler.getCar().addBody();
        }
    }
    public class FenderRobot extends Robot{
        public FenderRobot(RobotPool r){super(r);}
        public void performService() throws InterruptedException{
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this+" is installing fenders for "+assembler.getCar());
            assembler.getCar().addFender();
        }
    }

    /**
     *  Assembler
     */
    private int assemblerId=0;
    public class Assembler implements Runnable{
        private int id=++assemblerId;
        private Car car;
        private CyclicBarrier barrier=new CyclicBarrier(7);
        public CyclicBarrier getBarrier(){return barrier;}
        private RobotPool pool;
        private CarQueue carQueue, finishQueue;
        public Assembler(RobotPool p, CarQueue c, CarQueue f){
            pool=p;
            carQueue=c;
            finishQueue=f;
        }
        public String toString(){return "Assembler #"+id;}
        public Car getCar(){return car;}
        public void run(){
            try{
                while(!Thread.interrupted()){
                    car=carQueue.take();    //block
                    pool.hire(ExhaustRobot.class, this);    //block
                    pool.hire(BodyRobot.class,this);    //block
                    pool.hire(FenderRobot.class,this);  //block
                    pool.hire(EngineRobot.class,this);  //block
                    pool.hire(DriveTrainRobot.class,this);  //block
                    pool.hire(WheelRobot.class,this);   //block
                    barrier.await();
                    finishQueue.put(car);   //block
                }
            }catch(InterruptedException ie){
                System.out.println(this+" interrupted!");
            }catch(BrokenBarrierException bbe){
                System.out.println("Barrier brocken!");
            }
            System.out.println(this+" exit!");
        }
    }

    /**
     *  RobotPool
     */
     public class RobotPool{
         private Set<Robot> pool=new HashSet<Robot>();
         public synchronized void hire(Class<? extends Robot> robotType,Assembler a ) throws InterruptedException {  //allow to interrupt the assembler
            for(Robot r:pool){
                if(r.getClass().equals(robotType)){
                        pool.remove(r);
                        r.assignAssembler(a);
                        r.engage();
                        return;
                }
            }
            wait();
            hire(robotType,a);
         }
         public void release(Robot r){pool.add(r);}
     }

    /**
     * Finally
     */
    public class Reporter implements Runnable{
        private CarQueue cars;
        public Reporter(CarQueue queue){cars=queue;}
        public void run(){
            try{
                while(!Thread.interrupted()){
                    Car car=cars.take();
                    System.out.println(car+" finished!");
                }
            }catch(InterruptedException ie){
                System.out.println("Reporter interrupted!");
            }
            System.out.println("Reporter exit!");
        }
    }

    /**
     *  MAIN
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Type Entry to stop!");
        Exercise37 ex=new Exercise37();
        ExecutorService exec=Executors.newCachedThreadPool();
        RobotPool pool=ex.new RobotPool();
        CarQueue carQueue=ex.new CarQueue();
        CarQueue finishQueue=ex.new CarQueue();
        for(int i=0;i<5;i++){
            exec.execute(ex.new Assembler(pool,carQueue,finishQueue));
        }
        exec.execute(ex.new EngineRobot(pool));
        exec.execute(ex.new DriveTrainRobot(pool));
        exec.execute(ex.new WheelRobot(pool));
        exec.execute(ex.new ExhaustRobot(pool));
        exec.execute(ex.new BodyRobot(pool));
        exec.execute(ex.new FenderRobot(pool));
        exec.execute(ex.new ChassisBuilder(carQueue));
        exec.execute(ex.new Reporter(finishQueue));
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println("Test interrupted!");
        }
        exec.shutdownNow();
    }
}
