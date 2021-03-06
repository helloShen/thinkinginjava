/**
 * Exercise 32
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise32 {
    public static class CommandSequence {
        protected final LinuxCommand[] commands;
        public CommandSequence(int size) {
            commands = LinuxCommand.orderProgram(size);
        }
    }
    public static class NonCollectionCommandSequence extends CommandSequence implements Iterable<LinuxCommand> {
        public NonCollectionCommandSequence(int size) {
            super(size);
        }
        public Iterator<LinuxCommand> iterator() {
            return new Iterator<LinuxCommand>() {
                private int index = 0;
                public boolean hasNext() {
                    return index < commands.length;
                }
                public LinuxCommand next() {
                    return commands[index++];
                }
            };
        }
    }
    public static class MultiIterableCommandSequence extends NonCollectionCommandSequence {
        public MultiIterableCommandSequence(int size) {
            super(size);
        }
        public Iterable<LinuxCommand> reverse() {
            return new Iterable<LinuxCommand>() {
                public Iterator<LinuxCommand> iterator() {
                    return new Iterator<LinuxCommand>() {
                        private int index = commands.length-1;  //begin from the last element
                        public boolean hasNext() {
                            return index >= 0;
                        }
                        public LinuxCommand next() {
                            return commands[index--];
                        }
                    };
                }
            };
        }
        public Iterable<LinuxCommand> shuffle() {
            return new Iterable<LinuxCommand>() {
                public Iterator<LinuxCommand> iterator() {
                    ArrayList<LinuxCommand> commandsCopyList = new ArrayList<LinuxCommand>(Arrays.asList(commands));
                    Collections.shuffle(commandsCopyList);
                    return commandsCopyList.iterator();
                }
            };
        }
    }
    public static void main(String[] args) {
        MultiIterableCommandSequence commands = new MultiIterableCommandSequence(10);
        System.out.println("NORMAL ORDER >>>");
        for (LinuxCommand command : commands) {
            System.out.println(command);
        }
        System.out.println("REVERSE ORDER >>>");
        for (LinuxCommand command : commands.reverse()) {
            System.out.println(command);
        }
        System.out.println("SHUFFLE ORDER >>>");
        for (LinuxCommand command : commands.shuffle()) {
            System.out.println(command);
        }
    }
}
