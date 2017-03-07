/**
 *  Exercise 8
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Mail {
    // The NO’s lower the probability of random selection:
    enum GeneralDelivery {YES,NO1,NO2,NO3,NO4,NO5}
    enum Scannability {UNSCANNABLE,YES1,YES2,YES3,YES4}
    enum Readability {ILLEGIBLE,YES1,YES2,YES3,YES4}
    enum Address {INCORRECT,OK1,OK2,OK3,OK4,OK5,OK6}
    enum Forward {YES,NO}
    enum ForwardAddress {INCORRECT,OK1,OK2,OK3,OK4,OK5}
    enum ReturnAddress {MISSING,OK1,OK2,OK3,OK4,OK5}
    
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    Forward forward;
    ForwardAddress forwardAddress;
    ReturnAddress returnAddress;
    
    static long counter = 0;
    long id = counter++;
    public String toString() { return "Mail " + id; }
    public String details() {
        return toString() +
        ", General Delivery: " + generalDelivery +
        ", Address Scanability: " + scannability +
        ", Address Readability: " + readability +
        ", Address Address: " + address +
        ", Forward: " + forward +
        ", Forward Address: " + forwardAddress +
        ", Return address: " + returnAddress;
    }
    // Generate test Mail:
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery= Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.forward = Enums.random(Forward.class);
        m.forwardAddress = Enums.random(ForwardAddress.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }
    public static Iterable<Mail> generator(final int count) {
        return new Iterable<Mail>() {
            int n = count;
            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    public boolean hasNext() { return n-- > 0; }
                    public Mail next() { return randomMail(); }
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}