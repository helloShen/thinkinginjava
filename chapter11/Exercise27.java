/**
 * Exercise 27
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.lang.reflect.*;

public class Exercise27 {
    private static enum LinuxCommand {
        CD,LS,GREP,FIND,CP,MV,RM,PS,KILL,FILE,TAR,CAT;
        public String toString() {
            return name().toLowerCase();
        }
        public static LinuxCommand random() {
            Random rand = new Random();
            LinuxCommand[] values = LinuxCommand.class.getEnumConstants();
            return values[rand.nextInt(values.length)];
        }
    }
    public static class Command {
        private static int count = 0;
        private final int ID = ++count;
        private final String COMMAND;
        public Command(String str) {
            COMMAND = str;
        }
        public void operation() {
            System.out.println(this);
        }
        public String toString() {
            return "Command#" + ID + ": " + COMMAND;
        }
    }
    public static Queue<Command> fillCommandQueue(int size) {
        Queue<Command> queue = new LinkedList<Command>();
        for (int i = 0; i < size; i++) {
            queue.add(new Command(LinuxCommand.random().toString()));
        }
        return queue;
    }
    public static void printCommands(Queue<Command> commands) {
        for (Command command : commands) {
            command.operation();
        }
    }
    public static void main(String[] args) {
        //System.out.println(fillCommandQueue(20));
        printCommands(fillCommandQueue(20));
    }
}
