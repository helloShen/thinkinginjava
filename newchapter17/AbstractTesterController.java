/**
 * Exercise29
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 使用了模板模式的骨架实现
abstract class AbstractTesterController<C> {
    /**
     * 抽象primitive method
     * 以下的骨架实现大部分依赖于testRegistry()方法返回的测试策略对象的注册表。
     */
    public abstract Map<String,Test<C>> testRegistry();
    /**
     * 向用户开放待测试容器类Class对象的注册
     * 所以ListTesterInBook不是不可变类
     */
    private final Set<String> containers = new LinkedHashSet<>(Arrays.asList(new String[]{"java.util.ArrayList","java.util.LinkedList"}));
    public Set<String> containerRegistry() { // 向用户暴露私有域对象的引用。不安全，但测试框架不是API的一部分，仅供包内使用。
        return containers;
    }
    /**
     * 主方法
     * 根据所有注册对象进行测试
     */
    public void run() {
        for (String name : containers) {
            C container = classForName(name);
            System.out.println(">>>>>>>>>>> " + name + " <<<<<<<<<<<");
            TesterInBook.run(container,testRegistry());
        }
    }
    public void run(int[] paramList) {
        for (String name : containers) {
            C container = classForName(name);
            System.out.println(">>>>>>>>>>> " + name + " <<<<<<<<<<<");
            TesterInBook.run(container,testRegistry(),paramList);
        }
    }
    public void run(C container) { // test the given container
        System.out.println(">>>>>>>>>>> " + container.getClass().getSimpleName() + " <<<<<<<<<<<");
        TesterInBook.run(container,testRegistry());
    }
    /**
     * 利用反射，根据类型名称，构造容器实例。
     * 前提是容器基本都有无参数的构造函数。
     */
    @SuppressWarnings("unchecked")
    private C classForName(String name) {
        Class<?> klass = null;
        try {
            klass = Class.forName(name); // 获取Class对象
        } catch(ClassNotFoundException e) {
            System.err.println(name + " Class not found.");
            System.exit(1);
        }

        C object = null;
        try {
            object = (C) klass.newInstance(); //用newInstance()构造实例，赋值给接口
        } catch (IllegalAccessException e) {
            System.err.println(klass.getSimpleName() + " Class not accessible.");
            System.exit(1);
        } catch (InstantiationException e) {
            System.err.println(klass.getSimpleName() + " Class not instantiable.");
            System.exit(1);
        }
        return object;
    }
}
