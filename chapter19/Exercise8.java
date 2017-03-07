/**
 *  Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise8 {
    public static void main(String[] args) {
        for(Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            PostOffice8.handle(mail);
            System.out.println("*****");
        }
    }
}