/**
 *  To test if the non-public-class is package reachable
 *  I have one PublicClass and one PackageReachableClass in this package.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;

//My public class
public class PublicClass {
    //default constructor
    public PublicClass(){
        System.out.println("Hello, I am PublicClass.");
    }
}

