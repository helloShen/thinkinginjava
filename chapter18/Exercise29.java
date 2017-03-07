/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Exercise29 {
    public static class Blip3 implements Externalizable {
        private static final long serialVersionUID=1L;
        private int i;
        private String s; // No initialization
        public Blip3() {
            System.out.println("Blip3 Constructor");
            // s, i not initialized
        }
        public Blip3(String x, int a) {
            System.out.println("Blip3(String x, int a)");
            s = x;
            i = a;
            // s & i initialized only in non-default constructor.
        }
        public String toString() { return s + i; }
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("Blip3.writeExternal");
            // You must do this:
            //out.writeObject(s);
            //out.writeInt(i);
        }
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("Blip3.readExternal");
            // You must do this:
            s = (String)in.readObject();
            i = in.readInt();
        }
    }
    
    /**
     *  运行的结果会抛出OptionalDataException
     *  异常的原因是实现Externalizable接口的可序列化类，在序列化和反序列化的时候，都只调用默认的构造器。而这里Blip3的默认构造器没有初始化s和i的值。而在writeExternal和readExternal方法里又没有把s和i补偿序列化。反序列化的结果不完整。s和i始终没有初始化。
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Exercise29.Blip3 b3 = new Exercise29.Blip3("A String ", 47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise29.txt"));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise29.txt"));
        System.out.println("Recovering b3:");
        b3 = (Blip3)in.readObject();
        // System.out.println(b3);  //!!OptionalDataException
    }
}