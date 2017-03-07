/**
 *  Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise15 {
    
    public static void write(String file) throws IOException{
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
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
    
    public static void read(String file) throws IOException{
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
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
    
    public static void main(String[] args) throws IOException{
        String file="/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Data.txt";
        write(file);
        read(file);
    }
}