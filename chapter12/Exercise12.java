/**
 * Exercise 12
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise12 {
    public static class Sequence {
        private Object[] items;
        private int next = 0;
        public Sequence(int size) { items = new Object[size]; }
        public void add(Object x) throws  SequenceOutOfBoundsException{
            if(next < items.length) {
                items[next++] = x;
            } else {
                throw new SequenceOutOfBoundsException("Sequence#add() method add too much elements!");
            }
        }
        private static class SequenceOutOfBoundsException extends Exception {
            private static final long serialVersionUID = 0;
            public SequenceOutOfBoundsException() {
                super();
            }
            public SequenceOutOfBoundsException(String msg) {
                super(msg);
            }
        }
        private static class SequenceEmptyException extends Exception {
            private static final long serialVersionUID = 0;
            public SequenceEmptyException() {
                super();
            }
            public SequenceEmptyException(String msg) {
                super(msg);
            }
        }
        private class SequenceSelector implements Selector {
            private int i = 0;
            public boolean end() { return i == items.length; }
            public Object current() { return items[i]; }
            public void next() {
                if (i < items.length-1) {
                    i++;
                } else {
                    throw new RuntimeException(new SequenceEmptyException(this + " #next() reach the end of sequence!"));
                }
            }
        }
        public Selector selector() {
            return new SequenceSelector();
        }
    }
    public static void main(String[] args) {
        int sequenceLength = 10;
        int loopTimes = sequenceLength * 2;
        boolean loopFinish = false;
        boolean sequenceIsFull = false;
        boolean sequenceIsEmpty = false;
        Exercise12.Sequence sequence = new Exercise12.Sequence(sequenceLength);
        while (!loopFinish) {
            try {
                if (! sequenceIsFull) {
                    for (int i = 0; i < loopTimes; i++) {
                        sequence.add(Integer.toString(i));
                    }
                }
                if (! sequenceIsEmpty) {
                    Selector selector = sequence.selector();
                    for (int i = 0; i< loopTimes; i++) {
                        System.out.println(selector.current() + " ");
                        selector.next();
                    }
                }
                System.out.println("Congratulation! Procedure finished!");
                loopFinish = true;
            } catch (Exercise12.Sequence.SequenceOutOfBoundsException fullException) {
                System.out.println(fullException);
                sequenceIsFull = true;
            } catch (RuntimeException emptyException) {
                emptyException.printStackTrace(System.out);
                sequenceIsEmpty = true;
            }
        }
    }
}
