/**
 * Exercise 15
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise15 {
    private LinkedList<String> list = new LinkedList<String>();
    public boolean empty() {
        return list.size() == 0;
    }
    public String peek() {
        return list.peek();
    }
    public String pop() {
        return list.pop();
    }
    public String push(String item) {
        list.addFirst(item);
        return item;
    }
    @SuppressWarnings("unchecked")
    public int search(Object o) {
        return list.indexOf((String)o);
    }
    public String toString() {
        return list.toString();
    }

    public static interface Generator<T> {
        public T next();
    }
    public class StringGenerator implements Generator<String> {
        private int length = 7;
        private final Random RAND = new Random();
        public StringGenerator(int l) {
            length = l;
        }
        public String next() {
            char[] charArray = new char[length];
            for (int i = 0; i < length; i++) {
                char c = (char)((int)'a' + RAND.nextInt(26));
                charArray[i] = c;
            }
            return new String(charArray);
        }
    }
    public Generator<String> generator(int length) {
        return this.new StringGenerator(length);
    }
    enum ScanStatus {READ, WRITE}
    public class CommentErrorException extends Exception {
        private static final long serialVersionUID = 0;
        public CommentErrorException(String offset) {   //offset is the index where the error occurs
            super(offset);
        }
    }
    public void scanComment(String comment) throws CommentErrorException {
        ScanStatus myStatus = ScanStatus.WRITE;
        List<String> commentList = Arrays.asList(comment.split(""));
        ListIterator<String> commentIte = commentList.listIterator();
        String cursor = ""; //current comment
        int offset = 0; //index of cursor
        while (commentIte.hasNext()) {
            offset = commentIte.nextIndex();
            cursor = commentIte.next();
            if (myStatus == ScanStatus.WRITE) {
                if (cursor.equals("+")) {
                    myStatus = ScanStatus.READ;
                    continue;
                }
                if (cursor.equals("-")) {
                    if (empty()) {
                        throw new CommentErrorException("Position " + Integer.toString(offset) + ": stack is empty! nothing to pop!");
                    }
                    System.out.print(pop());
                    continue;
                }
                throw new CommentErrorException("Got \"" + cursor + "\" at position " + Integer.toString(offset) + ": need +- operation here!");
            }
            if (myStatus == ScanStatus.READ) {
                list.push(cursor);
                myStatus = ScanStatus.WRITE;
                continue;
            }
        }
    }
    public static void main(String[] args) {
        Exercise15 stack = new Exercise15();
        int stackLength = 10;
        for (int i = 0; i < stackLength; i++) {
            stack.push(Integer.toString(i));
        }
        System.out.println(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Stack is empty? " + stack.empty());

        String comment = "+U+n+c-+e+r+t-+a-+i-+n+t+y-+ -+r+u-+l+e+s-";
        try {
            stack.scanComment(comment);
        } catch(CommentErrorException e) {
            e.printStackTrace();
        }
    }
}
