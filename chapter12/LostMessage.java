/**
 *  Exercise 18-19 -chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;

//important
class VeryImportantException extends Exception {
    private static final long serialVersionUID=0;
    public String toString() {
        return "A very important exception!";
    }
}
//useless
class HoHumException extends Exception {
    private static final long serialVersionUID=0;
    public String toString() {
        return "A trivial exception";
    }
}
//main class
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    void thirdMethod() throws AutoLogException {
        throw new AutoLogException();
    }
    //main
    public static void main(String[] args) {
        try{
            LostMessage lm = new LostMessage();
            try {
                try {
                    lm.f();
                }catch(Exception e){
                    e.printStackTrace(System.err);
                } finally {
                    lm.dispose();
                }
            } catch(Exception e){
                e.printStackTrace(System.err);
            }finally {
                lm.thirdMethod();
            }
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}