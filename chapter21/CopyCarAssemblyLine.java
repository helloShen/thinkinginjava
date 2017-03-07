/**
 *  I repeat the CarAssemblyLine.
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class CopyCarAssemblyLine{
    /**
     *  Car
     */
    private int carId=0;
    public class Car{
        private int id;
        private boolean engine=false, drivenTrain=false, wheels=false;
        public Car(int num){id=num;}
        public Car(){id=++carId;}
        public int getId(){return id;}
        public void addEngine(){engine=true;}
        public void addDriveTrain(){drivenTrain=true;}
        public void addWheels(){wheels=true;}
        public String toString(){
            return "[Car #"+id+(engine? " Engine":"")+(drivenTrain? " DrivenTrain":"")+(wheels? " Wheels":"")+"]";
        }
    }

    /**
     * ChassisBuilder
     */
    public class ChassisBuilder implements Runnable{
        //carqueue
        private CarQueue carQueue;
        public ChassisBuilder(CarQueue queue){carQueue=queue;}
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
        public abstract void performService();  //work
        public void run(){
            try{
                while(!Thread.interrupted()){
                    powerDown();
                    performService();
                }
            }catch(InterruptedException ie){
                System.out.println(this+" interrupted!");
            }
            System.out.println(this+" exit!");
        }
    }
    public class EngineRobot extends Robot{
        public EngineRobot(RobotPool r){super(r);}
        public void performService(){
            System.out.println(this+" is installing engine for "+assembler.getCar());
            assembler.getCar().addEngine();
        }
    }
    public class DriveTrainRobot extends Robot{
        public DriveTrainRobot(RobotPool r){super(r);}
        public void performService(){
            System.out.println(this+" is installing Drive Train for "+assembler.getCar());
            assembler.getCar().addDriveTrain();
        }
    }
    public class WheelRobot extends Robot{
        public WheelRobot(RobotPool r){super(r);}
        public void performService(){
            System.out.println(this+" is installing wheel for "+assembler.getCar());
            assembler.getCar().addWheels();
        }
    }

    /**
     *  Assembler
     */
    private int assemblerId=0;
    public class Assembler implements Runnable{
        private int id=++assemblerId;
        private Car car;
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
                    pool.hire(EngineRobot.class,this);  //block
                    pool.hire(DriveTrainRobot.class,this);  //block
                    pool.hire(WheelRobot.class,this);   //block
                    finishQueue.put(car);   //block
                }
            }catch(InterruptedException ie){
                System.out.println("Assembler interrupted!");
            }
            System.out.println("Assembler exit!");
        }
    }

    /**
     *  RobotPool
     */
     public class RobotPool{
         private Set<Robot> pool=new HashSet<Robot>();
         public void hire(Class<? extends Robot> robotType,Assembler a ) throws InterruptedException {  //allow to interrupt the assembler
            for(Robot r:pool){
                if(r.getClass().equals(robotType)){
                    synchronized(r){
                        pool.remove(r);
                        r.assignAssembler(a);
                        r.engage();
                        return;
                    }
                }
            }
            wait();
            hire(robotType,a);
         }
         public void release(Robot r){pool.add(r);}
     }


    /**
     *  MAIN
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Type Entry to stop!");
        CopyCarAssemblyLine test=new CopyCarAssemblyLine();
        ExecutorService exec=Executors.newCachedThreadPool();
        RobotPool pool=test.new RobotPool();
        CarQueue carQueue=test.new CarQueue();
        CarQueue finishQueue=test.new CarQueue();
        for(int i=0;i<5;i++){
            exec.execute(test.new Assembler(pool,carQueue,finishQueue));
        }
        exec.execute(test.new EngineRobot(pool));
        exec.execute(test.new DriveTrainRobot(pool));
        exec.execute(test.new WheelRobot(pool));
        exec.execute(test.new ChassisBuilder(carQueue));
        try{
            System.in.read();
        }catch(IOException ioe){
            System.out.println("Test interrupted!");
        }
        exec.shutdownNow();
    }
}
