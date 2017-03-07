/**
 *  Exercise 21
 */
package  com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface {
    public void doSomething() { System.out.println("doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
class SimpleProxy implements Interface {
    private static long doSomethingCount=0;
    private static long somethingElseCount=0;
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        doSomethingCount++;
    }
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        somethingElseCount++;
    }
    public static void showCount(){
        System.out.println("Method doSomething() is called: "+doSomethingCount+" times!");
        System.out.println("Method somethingElse() is called: "+somethingElseCount+" times!");
    }
}
public class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
        SimpleProxy.showCount();
    }
}