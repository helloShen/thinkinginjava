/**
 *  Exercise 35 Web服务器负载测试
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;

public class WebClient{
    private static Random rand = new Random();
    //web请求
    static class Request {
        private final int serviceTime;
        public Request(int tm) { serviceTime = tm; }
        public int getServiceTime() { return serviceTime; }
        public String toString() {
            return "[" + serviceTime + "]";
        }
    }
    //web请求队列
    static class RequestLine extends ArrayBlockingQueue<Request> {
        private static final long serialVersionUID=0l;    
        private int maxSize;
        public RequestLine(int maxLineSize) {
            super(maxLineSize);
            maxSize=maxLineSize;
        }
        public int getMax(){return maxSize;}
        public String toString() {
            if(this.size() == 0){
                return "[Empty]";
            }
            StringBuilder result = new StringBuilder();
            for(Request r : this){
                result.append(r);
            }
            return result.toString();
        }
    }
    //web请求生成器，自动根据服务器吞吐量调节生成频率。
    static class RequestGenerator implements Runnable {
        private int period=100;    //初始频率，每秒一个请求
        private RequestLine requests;
        public RequestGenerator(RequestLine rq) {
            requests = rq;
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(period));
                    try{
                        requests.add(new Request(rand.nextInt(1000)));
                        if(period>1){
                            period-=1;
                        }
                    }catch(IllegalStateException  ise){    //队列满了
                        period+=1;
                    }
                }
            } catch(InterruptedException e) {
                System.out.println("CustomerGenerator interrupted");
            }
            System.out.println("CustomerGenerator terminating");
        }
        public String showBalance(){
            StringBuilder sb=new StringBuilder();
            float freq=1000/(float)period;
            String str=String.format("%.2f",freq);
            for(int i=0;i<(int)(freq);i++){
                sb=sb.append("+");
            }
            return sb.append(" "+str).toString();
        }
    }
}
