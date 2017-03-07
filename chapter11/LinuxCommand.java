/**
 * Exercise 32
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public enum LinuxCommand {
    CD,LS,GREP,FIND,CP,MV,RM,PS,KILL,FILE,TAR,CAT;
    public String toString() {
        int id = ordinal() + 1;
        String name = name().toLowerCase();
        return "Command#" + id + ": " + name;
    }
    public static LinuxCommand random() {
        Random rand = new Random();
        LinuxCommand[] values = LinuxCommand.class.getEnumConstants();
        return values[rand.nextInt(values.length)];
    }
    public static LinuxCommand orderGet(int index) {
        LinuxCommand[] values = LinuxCommand.class.getEnumConstants();
        return values[(index % values.length)];
    }
    public static LinuxCommand[] randomProgram(int size) {
        LinuxCommand[] program = new LinuxCommand[size];
        for (int i = 0; i < size; i++) {
            program[i] = random();
        }
        return program;
    }
    public static LinuxCommand[] orderProgram(int size) {
        LinuxCommand[] program = new LinuxCommand[size];
        for (int i = 0; i < size; i++) {
            program[i] = orderGet(i);
        }
        return program;
    }
}
