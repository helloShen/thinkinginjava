package  com.ciaoshen.thinkinjava.chapter14;
import java.util.*;
import java.lang.reflect.*;

interface Interface{public void foo();}

class A implements Interface{
    public void foo(){System.out.println("Method a of class A!");}
}

/*
class B implements Interface{
    public void foo(){a.foo();}
    public A a=new A();
}
 */

class Consumer{
    public static void consum(Interface i){
        i.foo();
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            return method.invoke(proxied, args);
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}

public class TestDynamicProxy{
    /*
    public void simpleDemo(){
        try{
            Class<?> refB=B.class;
            Method refFoo=refB.getDeclaredMethod("foo");
            Object refObj=refB.newInstance();
            refFoo.invoke(refObj);
        }catch(Exception e){
            System.out.println(e);
        }
    }
     */
    public static void main(String[] args){
        A a=new A();
        // Insert a proxy and call again:
        Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class<?>[]{ Interface.class }, new DynamicProxyHandler(a));
        Consumer.consum(proxy);
    }
}