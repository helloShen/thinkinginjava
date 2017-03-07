/**
 * Exercise17
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;
import java.math.*;

class BigDecimalGenerator implements Generator<BigDecimal>{
    BigDecimal bd=new BigDecimal(0);
    public BigDecimal next(){
        bd=bd.add(BigDecimal.ONE);
        return bd;
    }
}

public class Exercise17 {
    public static void main(String[] args) {
        BigDecimal[] bda=Generated.array(BigDecimal.class,new BigDecimalGenerator(),10);
        System.out.println(Arrays.toString(bda));
    }
}