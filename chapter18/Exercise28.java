/**
 *  Exercise 28
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Exercise28 {
    
    public static class BlipCheck implements Externalizable {
        private static final long serialVersionUID=1L;
        //这里默认构造器会被外部调用，所以必须是public的。
        //注释掉之后系统会自动创建一个默认构造器，默认是public的。
        /*
        BlipCheck() {
            System.out.println("Blip2 Constructor");
        }
         */
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("Blip2.writeExternal");
        }
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("Blip2.readExternal");
        }
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Exercise28.BlipCheck bc = new Exercise28.BlipCheck();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise28.txt"));
        System.out.println("Saving objects:");
        o.writeObject(bc);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise28.txt"));
        System.out.println("Recovering BlipCheck:");
        bc = (BlipCheck)in.readObject();
    }
}