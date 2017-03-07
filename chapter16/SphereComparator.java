/**
 * Used to comapre spheres
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class SphereComparator implements Comparator<Sphere>{
    
    public int compare(Sphere s1, Sphere s2){
        return s1.getId()-s2.getId();
    }
    
    public static void main(String[] args) {
        
    }
}