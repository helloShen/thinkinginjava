/**
 *  To test if the non-public-class is package reachable
 *  Call both PublicClass and one PackageReachableClass
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;
import java.util.*;

//Call both PublicClass and one PackageReachableClass from the same package
public class InPackageClass {
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        //pubic class can be reached from anywhere
        PublicClass newPublicClass=new PublicClass();
        //non-public-class should be accessable in the same package
        PackageReachableClass newPackageReachableClass =new PackageReachableClass();
    }

}