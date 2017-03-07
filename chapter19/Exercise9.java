/**
 *  Exercise 9
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Exercise9 {
    public static void main(String[] args) {
        for(Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            PostOffice9.handle(mail);
            System.out.println("*****");
        }
    }
}