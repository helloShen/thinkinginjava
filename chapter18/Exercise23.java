/**
 *  Exercise 23
 *  asCharBuffer()方法，默认以UTF-16BE来解码byteBuffer里的字节。每个字符2字节。
 *  而String # getBytes()使用我系统默认编码方式：而我系统的默认编码方式是：UTF-8。英语字母一个字节。
 *      解决方法一：要么在byte解码到char的时候，找到系统默认的编码标准。
 *      解决方法二：要么在getBytes编码的时候就用asCharSet默认的UTF-16BE标准：getBytes("UTF-16BE")。
 *      解决方法三：要么在写入文件的时候直接用CharSet的视图往里写入，就会直接用UTF-16BE的编码标准。
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class Exercise23{
    private static final int BSIZE=1024;
    private File f;
    
    public Exercise23(String s) throws IOException{
        this(new File(s));
    }
    public Exercise23(File f) throws IOException{
        this.f=f;
        if(!f.exists()){
            f.createNewFile();
        }
    }
    
    public void write(String s) throws IOException{
        FileChannel fc=new FileOutputStream(f).getChannel();
        //method 1 to create and fill a ByteBuffer
        ByteBuffer bf1=ByteBuffer.wrap(s.substring(0,s.length()/2).getBytes());
        //method 2 to create and fill a ByteBuffer
        ByteBuffer bf2=ByteBuffer.allocate(BSIZE);
        bf2.put(s.substring(s.length()/2).getBytes());
        bf2.flip(); //Important!!
        fc.write(bf1);
        fc.write(bf2);
        fc.close();
    }
    
    public byte[] read() throws IOException{
        FileChannel fc=new FileInputStream(f).getChannel();
        ByteBuffer bf=ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        byte[] ba=new byte[bf.limit()];
        int index=0;
        while(bf.hasRemaining()){
            ba[index]=bf.get();
            index++;
        }
        fc.close();
        return ba;
    }
    
    //输出乱码
    public char[] badReadAsChars() throws IOException{
        FileChannel fc=new FileInputStream(f).getChannel();
        ByteBuffer bf=ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        /**
         *  坑在这儿：
         *  asCharBuffer()方法，默认以UTF-16BE来解码byteBuffer里的字节。每个字符2字节。
         *  而String # getBytes()使用我系统默认编码方式：
         *      而我系统的默认编码方式是：UTF-8。英语字母一个字节。
         */
        CharBuffer cf=bf.asCharBuffer();
        char[] ca=new char[cf.limit()];
        int index=0;
        while(cf.hasRemaining()){
            ca[index]=cf.get();
            index++;
        }
        fc.close();
        return ca;
    }
    
    
    //这种解决方案比较好。因为从头到尾使用系统默认的编码标准，系统打开本地写入的文件的时候，不会显示乱码。
    public char[] readAsChars() throws IOException{
        FileChannel fc=new FileInputStream(f).getChannel();
        ByteBuffer bf=ByteBuffer.allocate(BSIZE);
        fc.read(bf);
        bf.flip();
        //解决方法一
        //要么在byte解码到char的时候，找到系统默认的编码标准。
        CharBuffer cf=Charset.forName(System.getProperty("file.encoding")).decode(bf);
        char[] ca=new char[cf.limit()];
        int index=0;
        while(cf.hasRemaining()){
            ca[index]=cf.get();
            index++;
        }
        fc.close();
        return ca;
    }
    
    public static void main(String[] args) throws IOException{
        //系统默认编码是UTF-8
        System.out.println(System.getProperty("file.encoding"));
        
        Exercise23 gc=new Exercise23("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise23.txt");
        
        gc.write("Hello World!");
        byte[] ba=gc.read();
        System.out.println("Bytes   >>> "+Arrays.toString(ba));
        System.out.println("String  >>> "+new String(ba));
        
        char[] ca=gc.readAsChars();
        System.out.println("Chars   >>> "+Arrays.toString(ca));
        System.out.println("String  >>> "+new String(ca));
    }
}