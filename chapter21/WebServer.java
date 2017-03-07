/**
 *  Exercise 35 Web服务器负载测试
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class WebServer{
    private static int handlerCounter = 0;
    //银行出纳，web请求处理器
    static class RequestHandler implements Runnable, Comparable<RequestHandler> {
        private final int id = handlerCounter++;
        private int requestServed = 0;
        private WebClient.RequestLine requests;
        private boolean servingRequestLine = true;
        public RequestHandler(WebClient.RequestLine rq) { requests = rq; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    WebClient.Request r = requests.take();
                    TimeUnit.MILLISECONDS.sleep(r.getServiceTime());
                    synchronized(this) {
                        requestServed++;
                        while(!servingRequestLine){
                            wait();
                        }
                    }
                }
            } catch(InterruptedException e) {
                System.out.println(this + "interrupted");
            }
            System.out.println(this + "terminating");
        }
        public synchronized void hangs() {
            requestServed = 0;
            servingRequestLine = false;
        }
        public synchronized void serveRequestLine() {
            assert !servingRequestLine:"already serving: " + this;
            servingRequestLine = true;
            notifyAll();
        }
        public String toString() { return "Request Handler  " + id + " "; }
        public String shortString() { return "H" + id; }
        // Used by priority queue:
        public synchronized int compareTo(RequestHandler other) {
            return requestServed < other.requestServed ? -1 : (requestServed == other.requestServed ? 0 : 1);
        }
    }
    //银行经理控制出纳数量，服务器大脑负载调节器
    static class Server implements Runnable {
        private ExecutorService exec;
        private WebClient.RequestLine requests;
        private PriorityQueue<RequestHandler> workingHandlers = new PriorityQueue<RequestHandler>();
        private Queue<RequestHandler> handlersDoingOtherThings = new LinkedList<RequestHandler>();
        private int adjustmentPeriod;
        private int maxHandler;
        
        public Server(ExecutorService e, WebClient.RequestLine requests, int adjustmentPeriod, int maxHandler) {
            exec = e;
            this.requests = requests;
            this.adjustmentPeriod = adjustmentPeriod;
            this.maxHandler=maxHandler;
            // Start with a single handler:
            RequestHandler handler= new RequestHandler(requests);
            exec.execute(handler);
            workingHandlers.add(handler);
        }
        public int getHandlerNumber(){return workingHandlers.size()+handlersDoingOtherThings.size();}
        public void adjustHandlerNumber() {
            // This is actually a control system. By adjusting
            // the numbers, you can reveal stability issues in
            // the control mechanism.
            // If line is too long, add another handler:
            if(requests.size() / (float)requests.getMax() > 0.5f) {
                // If handlers are on break or doing
                // another job, bring one back:
                if(handlersDoingOtherThings.size() > 0) {
                    RequestHandler handler = handlersDoingOtherThings.remove();
                    handler.serveRequestLine();
                    workingHandlers.offer(handler);
                    return;
                }
                // Else start a new request handler
                if(workingHandlers.size()<maxHandler){
                    RequestHandler handler = new RequestHandler(requests);
                    exec.execute(handler);
                    workingHandlers.add(handler);
                    return;
                }
            }
            // If line is short enough, remove a handler:
            if(workingHandlers.size() > 1 && requests.size() / (float)requests.getMax() < 0.5f){
                reassignOneHandler();
            }
            // If there is no line, we only need one handler:
            if(requests.size() == 0){
                while(workingHandlers.size() > 1){
                    reassignOneHandler();
                }
            }
        }
        // Give a request handler a different job or a break:
        private void reassignOneHandler() {
            RequestHandler handler = workingHandlers.poll();
            handler.hangs();
            handlersDoingOtherThings.offer(handler);
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                    adjustHandlerNumber();
                    /**
                    System.out.print(requests + " { ");
                    for(RequestHandler handler : workingHandlers)
                        System.out.print(handler.shortString() + " ");
                    System.out.println("}");
                     */
                }
            } catch(InterruptedException e) {
                System.out.println(this + "interrupted");
            }
            System.out.println(this + "terminating");
        }
        public String toString() { return "["+workingHandlers.size()+"/"+handlersDoingOtherThings.size()+"/"+maxHandler+"]"; }
    }
}

