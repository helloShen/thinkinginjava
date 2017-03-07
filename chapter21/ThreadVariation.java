/**
 *  Thread的一些变体
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class ThreadVariation {
    // Using a named inner class:
    class InnerThread1 {
        private int countDown = 5;
        private Inner inner;
        private class Inner extends Thread {
            Inner(String name) {
                super(name);
                start();
            }
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        sleep(10);
                    }
                } catch(InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            public String toString() {
                return getName() + ": " + countDown;
            }
        }
        public InnerThread1(String name) {
            inner = new Inner(name);
        }
    }

    // Using an anonymous inner class:
    class InnerThread2 {
        private int countDown = 5;
        private Thread t;
        public InnerThread2(String name) {
            t = new Thread(name) {
                public void run() {
                    try {
                        while(true) {
                            System.out.println(this);
                            if(--countDown == 0) return;
                            sleep(10);
                        }
                    } catch(InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }
                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
            t.start();
        }
    }
    // Using a named Runnable implementation:
    class InnerRunnable1 {
        private int countDown = 5;
        private Inner inner;
        private class Inner implements Runnable {
            Thread t;
            Inner(String name) {
                t = new Thread(this, name);
                t.start();
            }
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch(InterruptedException e) {
                    System.out.println("sleep() interrupted");
                }
            }
            public String toString() {
                return t.getName() + ": " + countDown;
            }
        }
        public InnerRunnable1(String name) {
            inner = new Inner(name);
        }
    }
    // Using an anonymous Runnable implementation:
    class InnerRunnable2 {
        private int countDown = 5;
        private Thread t;
        public InnerRunnable2(String name) {
            t = new Thread(new Runnable() {
                public void run() {
                    try {
                        while(true) {
                            System.out.println(this);
                            if(--countDown == 0) return;
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch(InterruptedException e) {
                        System.out.println("sleep() interrupted");
                    }
                }
                public String toString() {
                    return Thread.currentThread().getName() +
                    ": " + countDown;
                }
            }, name);
            t.start();
        }
    }
    // A separate method to run some code as a task:
    class ThreadMethod {
        private int countDown = 5;
        private Thread t;
        private String name;
        public ThreadMethod(String name) { this.name = name; }
        public void runTask() {
            if(t == null) {
                t = new Thread(name) {
                    public void run() {
                        try {
                            while(true) {
                                System.out.println(this);
                                if(--countDown == 0) return;
                                sleep(10);
                            }
                        } catch(InterruptedException e) {
                            System.out.println("sleep() interrupted");
                        }
                    }
                    public String toString() {
                        return getName() + ": " + countDown;
                    }
                };
                t.start();
            }
        }
    }

    public static void main(String[] args) {
        ThreadVariation thread=new ThreadVariation();
        thread.new InnerThread1("InnerThread1");
        thread.new InnerThread2("InnerThread2");
        thread.new InnerRunnable1("InnerRunnable1");
        thread.new InnerRunnable2("InnerRunnable2");
        thread.new ThreadMethod("ThreadMethod").runTask();
    }
}
