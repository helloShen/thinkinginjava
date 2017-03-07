/**
 *  Exercise 16
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise16 {
    static String file = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Data2.txt";
    
    static void display() throws IOException {
        RandomAccessFile in = new RandomAccessFile(file, "r");
        for(int i = 0; i < 7; i++){
            System.out.println("Value " + i + ": " + in.readDouble());
        }
        System.out.println(in.readUTF());
        boolean b=in.readBoolean();
        byte bt=in.readByte();
        char c=in.readChar();
        int i=in.readInt();
        long l=in.readLong();
        short s=in.readShort();
        float f=in.readFloat();
        double d=in.readDouble();
        String str=in.readUTF();
        in.close();
        System.out.println("["+b+"],"+"["+bt+"],"+"["+c+"],"+"["+i+"],"+"["+l+"],"+"["+s+"],"+"["+f+"],"+"["+d+"],"+"["+str+"]");
    }
    
    static void write() throws IOException {
        RandomAccessFile out = new RandomAccessFile(file, "rw");
        for(int i = 0; i < 7; i++){
            out.writeDouble(i*1.414);
        }
        out.writeUTF("The end of the file");
        out.writeBoolean(true);
        out.writeByte(56);
        out.writeChar('a');
        out.writeInt(56);
        out.writeLong(56l);
        out.writeShort(56);
        out.writeFloat(56f);
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.close();
    }
    public static void main(String[] args) throws IOException {
        write();
        display();
    }
}