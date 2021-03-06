/**
 *  GreenHouseScheduler with DelayQueue
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class Exercise33 {

    /**
     *  传统任务
     */
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    public synchronized String getThermostat() {
        return thermostat;
    }
    public synchronized void setThermostat(String value) {
        thermostat = value;
    }
    //delayed task
    private static class DelayedTask implements Delayed{
        private long trigger;
        public DelayedTask(long time){trigger=time;}
        public long getDelay(TimeUnit unit){
            return unit.convert(trigger-System.nanoTime(),unit);
        }
        public int compareTo(Delayed arg){
            DelayedTask dt=(DelayedTask)arg;
            if(trigger<dt.trigger){return -1;}
            if(trigger>dt.trigger){return 1;}
            return 0;
        }
        public void reset(long nanoTime){
            trigger=System.nanoTime()+nanoTime;
        }
    }
    //delayed events
    class LightOn extends DelayedTask implements Runnable{
        public LightOn(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }
    }
    class LightOff extends DelayedTask implements Runnable{
        public LightOff(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }
    }
    class WaterOn extends DelayedTask implements Runnable{
        public WaterOn(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }
    class WaterOff extends DelayedTask implements Runnable{
        public WaterOff(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }
    class ThermostatNight extends DelayedTask implements Runnable{
        public ThermostatNight(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }
    class ThermostatDay extends DelayedTask implements Runnable{
        public ThermostatDay(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }
    class Bell extends DelayedTask implements Runnable{
        public Bell(long delay){
            super(delay);
        }
        public void run() { System.out.println("Bing!"); }
    }
    class Terminate extends DelayedTask implements Runnable{
        public Terminate(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Terminating");
            es.shutdownNow();
            System.out.println("Executor shutdown!");
            new Thread() {
                public void run() {
                    for(DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }
    //delay Queue
    private DelayQueue<DelayedTask> dq=new DelayQueue<DelayedTask>();
    private ExecutorService es=Executors.newCachedThreadPool();
    public ExecutorService getExecutor(){return es;}
    public void setTask(DelayedTask dt){
        dq.put(dt);
    }
    public void scheduled(){
        try{
            int num=1;
            while(dq.size()>0){
                synchronized(this){
                    es.execute((Runnable)dq.take());
                    System.out.println("Thread#"+num);
                    TimeUnit.SECONDS.sleep(1);
                    num++;
                }
            }
            es.shutdownNow();
        }catch(InterruptedException ie){
            System.out.println("Executor interrupted!");
        }finally{
            System.out.println("Executor exit!");
        }
    }
    public void repeat(int times){
        Random rand=new Random();
        try{
            for(int i=1;i<=times;i++){
                synchronized(this){
                    DelayedTask task=dq.take();
                    es.execute((Runnable)task);
                    System.out.println("Thread#"+i);
                    task.reset((long)(rand.nextInt(5000)));
                    dq.put(task);
                    TimeUnit.SECONDS.sleep(1);
                }
            }
            es.shutdownNow();
        }catch(InterruptedException ie){
            System.out.println("Executor interrupted!");
        }finally{
            System.out.println("Executor exit!");
        }
    }
    
    /**
     *  新功能：数据收集
     */
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;
        public DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }
        public String toString() {
            return time.getTime() +
            String.format(" temperature: %1$.1f humidity: %2$.2f",temperature, humidity);
        }
    }
    private Calendar lastTime = Calendar.getInstance();
    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());
    class CollectData extends DelayedTask implements Runnable {
        public CollectData(long delay){
            super(delay);
        }
        public void run() {
            System.out.println("Collecting data");
            synchronized(Exercise33.this) {
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE) + 30);
                if(rand.nextInt(5) == 4){
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if(rand.nextInt(5) == 4){
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                data.add(new DataPoint((Calendar)lastTime.clone(),lastTemp, lastHumidity));
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        Exercise33 ex=new Exercise33();
        //ex.setTask(ex.new Terminate(5000));
        ex.setTask(ex.new Bell(1000));
        ex.setTask(ex.new ThermostatNight(2000));
        ex.setTask(ex.new LightOn(200));
        ex.setTask(ex.new LightOff(400));
        ex.setTask(ex.new WaterOn(600));
        ex.setTask(ex.new WaterOff(800));
        ex.setTask(ex.new ThermostatDay(1400));
        ex.setTask(ex.new CollectData(500));
        ex.scheduled();
        //ex.repeat(20);
    }
}