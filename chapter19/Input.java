/**
 *  Exercise 10
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public enum Input {

    /**
     *  枚举成员
     */
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    /**
     *  其他成员
     */
    int value; // In cents
    Input(int value) { this.value = value; }
    Input() {}
    int amount() { return value; }; // In cents
    static Random rand = new Random();
    public static Input randomSelection() {
        // Don’t include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}