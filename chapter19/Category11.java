/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;
import static com.ciaoshen.thinkinjava.chapter19.Input11.*;

public enum Category11 {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(PRODUCT),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private static EnumMap<Input11,Category11> categories = new EnumMap<Input11,Category11>(Input11.class);

    static {
        for(Category11 c : Category11.class.getEnumConstants()) {
            for(Input11 type : c.values){
                categories.put(type, c);
            }
        }
    }

    public static Category11 categorize(Input11 input) {
        return categories.get(input);
    }

    private Input11[] values;
    Category11(Input11... types) { values = types; }

    public static void main(String[] args){
        System.out.println(Category11.MONEY);
        System.out.println(Category11.categories);
    }
}