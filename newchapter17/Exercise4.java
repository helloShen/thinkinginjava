/**
 * Exercise 4
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

public class Exercise4 {
    public static void printWordFreq(Map<String,String> wordsMap) {
        if (wordsMap == null || wordsMap.isEmpty()) {
            System.out.println("Check your words frequence map!");
            throw new RuntimeException();
        }
        Formatter f = new Formatter(System.out);
        for(Map.Entry<String,String> entry : wordsMap.entrySet()) {
            f.format("Word: %1$-20.20s Frequence: %2$-20.20s \n", entry.getKey(), entry.getValue());
        }
    }
    public static void main(String[] arga) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/Exercise4.java";
        String[][] wordsFrequence = MyReader.calculWordFreq(MyReader.readFile(path));
        Map<String,String> frequenceMap = new FlyWeightMapScaffold(wordsFrequence);
        printWordFreq(frequenceMap);
    }
}
