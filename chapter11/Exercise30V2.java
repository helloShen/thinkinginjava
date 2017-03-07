/**
 * Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise30V2 {
    private static enum LinuxCommand {
        CD,LS,GREP,FIND,CP,MV,RM,PS,KILL,FILE,TAR,CAT;
        public String toString() {
            return name().toLowerCase();
        }
        private static LinuxCommand random() {
            Random rand = new Random();
            LinuxCommand[] values = LinuxCommand.class.getEnumConstants();
            return values[rand.nextInt(values.length)];
        }
        private static LinuxCommand[] randomProgram(int size) {
            LinuxCommand[] program = new LinuxCommand[size];
            for (int i = 0; i < size; i++) {
                program[i] = random();
            }
            return program;
        }
    }
    public static class CommandSequence implements Collection<LinuxCommand> {
        // object array
        private LinuxCommand[] program;
        private int cursor = 0; //current pointer
        public CommandSequence(int size) {
            program = LinuxCommand.randomProgram(size);
        }
        public boolean add(LinuxCommand c) {    //数组如果满了，循环从头插入
            throw new UnsupportedOperationException();
        }
        public boolean addAll(Collection<? extends LinuxCommand> c) {
            throw new UnsupportedOperationException();
        }
        public void clear() {
            throw new UnsupportedOperationException();
        }
        public boolean contains(Object o) {
            throw new UnsupportedOperationException();
        }
        public boolean containsAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }
        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }
        public boolean remove(Object o) {
            throw new UnsupportedOperationException();
        }
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }
        public <T> T[] toArray(T[] array) {
            throw new UnsupportedOperationException();
        }
        public int size() {
            throw new UnsupportedOperationException();
        }
        public Iterator<LinuxCommand> iterator() {
            return new Iterator<LinuxCommand>() {
                private int index = 0;
                public boolean hasNext() {
                    return index < program.length;
                }
                public LinuxCommand next() { return program[index++]; }
                public void remove() { // Not implemented
                    throw new UnsupportedOperationException();
                }
            };
        }
    }
    public static class InterfaceVsIterator {
        public static <T> void display(Collection<T> c) {
            for (T ele : c) {
                System.out.println(ele);
            }
        }
        public static <T> void display(Iterator<T> ite) {
            while (ite.hasNext()) {
                System.out.println(ite.next());
            }
        }
    }
    public static void main(String[] args) {
        CommandSequence c = new CommandSequence(10);
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
