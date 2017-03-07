/**
 * Comparator for EleToCompare
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class EleToCompareComparator implements Comparator<EleToCompare>{
    public int compare(EleToCompare e1, EleToCompare e2){
        return e1.getItem()-e2.getItem();
    }
}