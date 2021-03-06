/**
 * Exercise 39
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;
import java.lang.reflect.*;

public class Exercise39 {
    /**
     *  tuple容器
     */
    private static class TwoTuple<A,B> {
        public final A first;
        public final B second;
        public TwoTuple(A a, B b) { first = a; second = b; }
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
        public static <A,B> TwoTuple<A,B> tuple(A a, B b) {
            return new TwoTuple<A,B>(a, b);
        }
    }
    private static interface Basic {
        public void set(String val);
        public String get();
    }
    private static class BasicImp implements Basic {
        private String value;
        public void set(String val) { value = val; }
        public String get() { return value; }
    }
    /**
     *  时间戳系统
     */
    private static interface TimeStamped { long getStamp(); }

    private static class TimeStampedImp implements TimeStamped {
        private final long timeStamp;
        public TimeStampedImp() {
            timeStamp = new Date().getTime();
        }
        public long getStamp() { return timeStamp; }
    }
    /**
     *  序列号系统
     */
    private static interface SerialNumbered { long getSerialNumber(); }

    private static class SerialNumberedImp implements SerialNumbered {
        private static long counter = 1;
        private final long serialNumber = counter++;
        public long getSerialNumber() { return serialNumber; }
    }
    /**
     *  新加的Colored系统
     */
    private static interface Colored {public boolean isColored();}

    private static class ColoredImp implements Colored {
        private boolean colored;
        public ColoredImp(boolean c){colored=c;}
        public void makeColor(){colored=true;}
        public void removeColor(){colored=false;}
        public boolean isColored(){return colored;}
    }
    /**
     *  动态代理
     */
    private static class MixinProxy implements InvocationHandler {
        Map<String,Object> delegatesByMethod;
        public MixinProxy(TwoTuple<Object,Class<?>>... pairs) {
            delegatesByMethod = new HashMap<String,Object>();
            for(TwoTuple<Object,Class<?>> pair : pairs) {
                for(Method method : pair.second.getMethods()) {
                    String methodName = method.getName();
                    // The first interface in the map
                    // implements the method.
                    if (!delegatesByMethod.containsKey(methodName))
                        delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            Object delegate = delegatesByMethod.get(methodName);
            return method.invoke(delegate, args);
        }

        @SuppressWarnings("unchecked")
        public static Object newInstance(TwoTuple... pairs) {
            Class[] interfaces = new Class[pairs.length];
            for(int i = 0; i < pairs.length; i++) {
                interfaces[i] = (Class)pairs[i].second;
            }
            ClassLoader cl = pairs[0].first.getClass().getClassLoader();
            return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
        }
    }
    /**
     *  测试
     */
    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(TwoTuple.tuple(new BasicImp(), Basic.class),
                                              TwoTuple.tuple(new TimeStampedImp(), TimeStamped.class),
                                              TwoTuple.tuple(new SerialNumberedImp(),SerialNumbered.class),
                                              TwoTuple.tuple(new ColoredImp(false),Colored.class));
        Basic b = (Basic)mixin;
        TimeStamped t = (TimeStamped)mixin;
        SerialNumbered s = (SerialNumbered)mixin;
        Colored c=(Colored)mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        System.out.println(c.isColored());
    }
}
