/**
 *  Exercise 22
 */
package  com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

interface Interface{
    public void doSomething();
    public void somethingElse(String s);
}
class RealObject implements Interface{
    public void doSomething(){System.out.println("RealObject is doing something!");}
    public void somethingElse(String s){System.out.println("RealObject is doing something else called "+s+" !");}
}

class DynamicProxyHandler implements InvocationHandler {
    //counter here
    private static long count=0;
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null){
            for(Object arg : args){
                System.out.println(" " + arg);
            }
        }
        try{
            Object o=method.invoke(proxied, args);
            count++;
            return o;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    //add a method in the handler to show the count
    public static void showCount(){System.out.println("Proxy is invoked "+count+" times!");}
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class<?>[]{ Interface.class }, new DynamicProxyHandler(real));
        consumer(proxy);
        consumer(proxy);
        consumer(proxy);
        //show count here
        DynamicProxyHandler.showCount();
    }
}