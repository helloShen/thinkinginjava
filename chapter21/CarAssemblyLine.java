/**
 *  Exercise 37
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

class CarAssemblyLine{
    class Car {
        private final int id;
        private boolean
        engine = false, driveTrain = false, wheels = false;
        public Car(int idn) { id = idn; }
        // Empty Car object:
        public Car() { id = -1; }
        public synchronized int getId() { return id; }
        public synchronized void addEngine() { engine = true; }
        public synchronized void addDriveTrain() {
            driveTrain = true;
        }
        public synchronized void addWheels() { wheels = true; }
        public synchronized String toString() {
            return "Car " + id + " [" + " engine: " + engine
            + " driveTrain: " + driveTrain
            + " wheels: " + wheels + " ]";
        }
    }
    class CarQueue extends LinkedBlockingQueue<Car> {
        private static final long serialVersionUID=0;
    }
    class ChassisBuilder implements Runnable {
        private CarQueue carQueue;
        private int counter = 0;
        public ChassisBuilder(CarQueue cq) { carQueue = cq; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(500);
                    // Make chassis:
                    Car c = new Car(counter++);
                    System.out.println("ChassisBuilder created " + c);
                    // Insert into queue
                    carQueue.put(c);
                }
            } catch(InterruptedException e) {
                System.out.println("Interrupted: ChassisBuilder");
            }
            System.out.println("ChassisBuilder off");
        }
    }
    class Assembler implements Runnable {
        private CarQueue chassisQueue, finishingQueue;
        private Car car;
        private CyclicBarrier barrier = new CyclicBarrier(4);   //最多3种Robot在栅栏处等
        private RobotPool robotPool;
        public Assembler(CarQueue cq, CarQueue fq, RobotPool rp){
            chassisQueue = cq;
            finishingQueue = fq;
            robotPool = rp;
        }
        public Car car() { return car; }
        public CyclicBarrier barrier() { return barrier; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    // Blocks until chassis is available:
                    car = chassisQueue.take();
                    // Hire robots to perform work:
                    robotPool.hire(EngineRobot.class, this);
                    robotPool.hire(DriveTrainRobot.class, this);
                    robotPool.hire(WheelRobot.class, this);
                    barrier.await(); // Until the robots finish
                    // Put car into finishingQueue for further work
                    finishingQueue.put(car);
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting Assembler via interrupt");
            } catch(BrokenBarrierException e) {
                // This one we want to know about
                throw new RuntimeException(e);
            }
            System.out.println("Assembler off");
        }
    }
    class Reporter implements Runnable {    //汽车加工完从finishQueue里把汽车拿出来，报告一声。
        private CarQueue carQueue;
        public Reporter(CarQueue cq) { carQueue = cq; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    System.out.println(carQueue.take());
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting Reporter via interrupt");
            }
            System.out.println("Reporter off");
        }
    }
    abstract class Robot implements Runnable {
        private RobotPool pool;
        public Robot(RobotPool p) { pool = p; }
        protected Assembler assembler;
        public Robot assignAssembler(Assembler assembler) { //绑定某个Assembler
            this.assembler = assembler;
            return this;
        }
        private boolean engage = false;
        public synchronized void engage() { //让其他线程（比如Assembler）获得自己的锁，在自己的锁上叫醒自己的run()线程。
            engage = true;
            notifyAll();
        }
        // The part of run() that’s different for each robot:
        abstract protected void performService();
        public void run() {
            try {
                //做了两件事：第一，release()方法把Robot插入到RobotPool。
                //第二，wait()方法在Robot对象自己的锁上，大声说：我准备就绪。我让出自己的锁，其他线程可以在需要的时候叫醒我。
                powerDown(); // Wait until needed。
                while(!Thread.interrupted()) {
                    performService();
                    assembler.barrier().await(); // Synchronize
                    // We’re done with that job... 继续为下一次任务准备就绪
                    powerDown();
                }
            } catch(InterruptedException e) {
                System.out.println("Exiting " + this + " via interrupt");
            } catch(BrokenBarrierException e) {
                // This one we want to know about
                throw new RuntimeException(e);
            }
            System.out.println(this + " off");
        }
        /**
         *  很美，很重要
         */
        private synchronized void powerDown() throws InterruptedException { //每个Robot的run()以powerDown动作开始，把自己插入到RobotPool里去。其他的清理工作也不影响，反而保证每次开始运行前Robot都正确归位。最后让出自己的锁，声明自己“准备就绪”。
            engage = false;
            assembler = null; // Disconnect from the Assembler
            // Put ourselves back in the available pool:
            pool.release(this);
            while(engage == false){ // Power down   让出自己的锁。等待Assembler调用engage()方法叫醒自己。其实就是声明自己“准备就绪”。
                wait();
            }
        }
        public String toString() { return getClass().getName(); }
    }
    class EngineRobot extends Robot {
        public EngineRobot(RobotPool pool) { super(pool); }
        protected void performService() {
            System.out.println(this + " installing engine");
            assembler.car().addEngine();
        }
    }
    class DriveTrainRobot extends Robot {
        public DriveTrainRobot(RobotPool pool) { super(pool); }
        protected void performService() {
            System.out.println(this + " installing DriveTrain");
            assembler.car().addDriveTrain();
        }
    }
    class WheelRobot extends Robot {
        public WheelRobot(RobotPool pool) { super(pool); }
        protected void performService() {
            System.out.println(this + " installing Wheels");
            assembler.car().addWheels();
        }
    }
    class RobotPool {
        // Quietly prevents identical entries:
        private Set<Robot> pool = new HashSet<Robot>();
        public synchronized void add(Robot r) {
            pool.add(r);
            notifyAll();
        }
        //需要和Assembler的run()配合起来看。这里的反向控制很复杂。
        //Assembler在自己的run()里注入对RobotPool的依赖，调用RobotPool的hire()方法。但是在hire()方法里，反过来注入对Assembler的依赖，让Assembler调用engage()方法。而engage()方法是接过powerDown()方法让出的Robot对象自己的互斥锁，然后唤醒Robot对象。
        //这样做的目的是既然engage()要获取Robot的互斥锁，就索性封装到Robot的一个方法里，然后在方法上整个套上互斥锁。
        //就像书里说的，这个hire()方法上整个套互斥锁不是必须的。因为有BlockingQueue的串行化保证，程序是线程安全的。但这样的互斥锁主要是起到一个警示的作用。意思说，虽然不是必须，但保持此处的“原子性”总是更保险的。虽然作死未必会死，但不作死多好呢。
        public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
            for(Robot r : pool)
                if(r.getClass().equals(robotType)) {
                    pool.remove(r);
                    r.assignAssembler(d);
                    r.engage(); // Power it up to do the task
                    return;
                }
            wait(); // None available
            hire(robotType, d); // Try again, recursively
        }
        public synchronized void release(Robot r) { add(r); }   //负责把Robot插入RobotPool的函数
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CarAssemblyLine fac=new CarAssemblyLine();
        CarQueue chassisQueue = fac.new CarQueue(),
        finishingQueue = fac.new CarQueue();
        RobotPool robotPool = fac.new RobotPool();
        exec.execute(fac.new EngineRobot(robotPool));
        exec.execute(fac.new DriveTrainRobot(robotPool));
        exec.execute(fac.new WheelRobot(robotPool));
        exec.execute(fac.new Assembler(chassisQueue, finishingQueue, robotPool));
        exec.execute(fac.new Reporter(finishingQueue));
        // Start everything running by producing chassis:
        exec.execute(fac.new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        exec.shutdownNow();
    }
}
