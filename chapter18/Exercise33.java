/**
 *  Exercise 33
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.util.prefs.*;

public class Exercise33 {
    public static void main(String[] args) throws BackingStoreException{
        Preferences root=Preferences.userRoot();
        root.clear();   //remove the previous enregistrer
        byte[] info=root.getByteArray("base directory","/Users".getBytes());
        System.out.println(new String(info));
        info="/Users/Wei".getBytes();
        root.putByteArray("base directory",info);
        System.out.println(new String(root.getByteArray("base directory","/Users".getBytes())));
    }
}