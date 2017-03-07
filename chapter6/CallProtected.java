/**
 *  try to prove that protected is accessable in the package
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter6;

import java.util.*;
import com.ciaoshen.thinkinjava.chapter6.debug.DebugClass;

/**
 *  I can call protected method in SameNameClass but not in DebugClass
 */
public class CallProtected{
    
    protected static String protectedValue = "Protected Value";
    
    /**
     *  Main method
     *  @param args void
     */
    public static void main(String[] args){
        //exercise 4
        //in another package
        //DebugClass.protectedDebug();
        //in the same package
        //SameNameClass.protectedDebug();
        
        //exercise 5
        //in the same package
        //SameNameClass.publicDebug();
        //in the same package
        //SameNameClass.protectedDebug();
        //in the same package
        //SameNameClass.privateDebug();
        
        //exercise 6
        //System.out.println(CallProtected.protectedValue + " is visited!");
        
        //ProtectedClass myProtected = new ProtectedClass();
        //System.out.println(myProtected.publicI);
        //myProtected.publicPrint();
        
        System.out.println(ProtectedClass.staticI);
        ProtectedClass.staticPrint();
        
    }
}