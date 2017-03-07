package  com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

interface Interface{public void foo();}

class A implements Interface{
    public void foo(){System.out.println("Method a of class A!");}
}

class B implements Interface{
    public void foo(){a.foo();}
    public A a=new A();
}

class Consumer{
    public static void consum(Interface i){
        i.foo();
    }
}

public class TestProxy{
    public static void main(String[] args){
        Interface i=new B();
        Consumer.consum(i);
    }
}


