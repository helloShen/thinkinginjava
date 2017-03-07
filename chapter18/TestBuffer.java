package com.ciaoshen.thinkinjava.chapter18;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class TestBuffer {
    public static void main(String args[]) throws IOException {
        FileOutputStream unbufStream;
        BufferedOutputStream bufStream;
        unbufStream = new FileOutputStream("test.one");
        bufStream = new BufferedOutputStream(new FileOutputStream("test.two"));
        System.out.println("Write file unbuffered: " + time(unbufStream) + "ms");
        System.out.println("Write file  buffered: " + time(bufStream) + "ms");
    }
    
    static int time(OutputStream os) throws IOException {
        Date then = new Date();
        for (int i = 0; i < 500000; i++) {
            os.write(1);
        }
        os.close();
        return (int) ((new Date()).getTime() - then.getTime());
    }
}