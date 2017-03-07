/**
 * Exercise 30
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise30 {
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
        private int cursor = 0;
        public CommandSequence(int size) {
            program = LinuxCommand.randomProgram(size);
        }
        public boolean add(LinuxCommand c) {    //数组如果满了，循环从头插入
            if (c == null) {
                return false;
            }
            program[cursor++] = c;
            if (cursor == program.length) {
                cursor = 0;
            }
            return true;
        }
        public boolean addAll(Collection<? extends LinuxCommand> c) {
            if (c == null || c.isEmpty()) {
                return false;
            }
            for (LinuxCommand command : c) {
                if (!add(command)) {
                    return false;
                }
            }
            return true;
        }
        public void clear() {
            program = new LinuxCommand[program.length];
        }
        public boolean contains(Object o) {
            LinuxCommand c = (LinuxCommand)o;
            for (LinuxCommand ele : program) {
                if (ele == c) {
                    return true;
                }
            }
            return false;
        }
        public boolean containsAll(Collection<?> c) {
            if (c == null || c.isEmpty()) {
                return false;
            }
            for (Object o : c) {
                if (! contains(o)) {
                    return false;
                }
            }
            return true;
        }
        public boolean isEmpty() {
            return size() == 0;
        }
        public boolean remove(Object o) {
            if (!(o instanceof LinuxCommand)) {
                return false;
            }
            for (int i = 0; i < program.length; i++) {
                if (program[i] == (LinuxCommand)o) {
                    program[i] = null;
                    return true;
                }
            }
            return false;
        }
        public boolean removeAll(Collection<?> c) {
            boolean changed = false;
            if (c == null || c.isEmpty()) {
                return changed;
            }
            for (Object o : c) {
                if (remove(o)) {
                    changed = true;
                }
            }
            return changed;
        }
        public boolean retainAll(Collection<?> c) {
            boolean changed = false;
            if (c == null || c.isEmpty()) {
                return changed;
            }
            for (Object o : this) {
                if (!c.contains(o)) {
                    if(remove(o)) {
                        changed = true;
                    }
                }
            }
            return changed;
        }
        public Object[] toArray() {
            Object[] result = new Object[program.length];
            for (int i = 0; i < program.length; i++) {
                result[i] = program[i];
            }
            return result;
        }
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] array) {
            Object[] result = new Object[program.length];
            for (int i = 0; i < program.length; i++) {
                result[i] = program[i];
            }
            return (T[])result;
        }
        public int size() { return program.length; }
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
