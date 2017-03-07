/**
 *  Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;

public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/CADState.txt"));
        // Read in the same order they were written:
        List<Class<? extends StoreCADState.Shape>> shapeTypes = (List<Class<? extends StoreCADState.Shape>>)in.readObject();
        StoreCADState.Line.deserializeStaticState(in);
        List<StoreCADState.Shape> shapes = (List<StoreCADState.Shape>)in.readObject();
        System.out.println(shapes);
    }
}