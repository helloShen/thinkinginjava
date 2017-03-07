/**
 *  Simple inner class
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;
import com.ciaoshen.thinkinjava.chapter10.*;

class TestInner {
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        Outer testOuter=new Outer("Inner class haven't visited me!");
        testOuter.callPrivateInner();
    }
    
}