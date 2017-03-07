/**
 *  测试主进程结束后，守护进程的行为。
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

class Daemon implements Runnable {
    private Thread[] t = new Thread[100];
    public void run() {
        for(int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.print("DaemonSpawn " + i + " started, ");
        }
        for(int i = 0; i < t.length; i++)
            System.out.print("t[" + i + "].isDaemon() = " +
                    t[i].isDaemon() + ", ");
        while(true)
            Thread.yield();
    }
}
class DaemonSpawn implements Runnable {
    public void run() {
        while(true){
            Thread.yield();
        }
    }
}
public class Exercise7{
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        //System.out.print("d.isDaemon() = " + d.isDaemon() + ", ");
        //TimeUnit.NANOSECONDS.sleep(1);
        //TimeUnit.MILLISECONDS.sleep(1);
        //TimeUnit.MICROSECONDS.sleep(1);
        //TimeUnit.SECONDS.sleep(1);
    }
}