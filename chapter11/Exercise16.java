/**
 * Exercise 16
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Exercise16 {
    private static final String SPLITER = "\n";
    //read file
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            try {
                String line = new String("");
                while (true) {
                    line = br.readLine();
                    if (line == null) {break;}
                    sb.append(line + SPLITER);
                }
            } finally {
                br.close();
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    //word segment
    public static Map<String,Integer> segmentWords(String content) {
        if (content == null || content.isEmpty()) {
            throw new RuntimeException("Content for segmentWords() method is null or empty!");
        }
        Map<String,Integer> freqMap = new HashMap<String,Integer>();
        Pattern wordP = Pattern.compile("\\w+");
        Matcher wordM = wordP.matcher(content);
        String word = "";
        while (wordM.find()) {
            word = wordM.group();
            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word)+1);
                continue;
            }
            freqMap.put(word, 1);
        }
        return freqMap;
    }

    //count vowels
    public static void countVowels(Map<String, Integer> wordsMap) {
        int totalVowelNum = 0;
        int wordVowelCount = 0;
        Pattern vowelP = Pattern.compile("[aeiouAEIOU]");
        Matcher vowelM = vowelP.matcher("");
        if (wordsMap == null || wordsMap.isEmpty()) {
            throw new RuntimeException("The wordsMap for countVowels() method is null or empty!");
        }
        Formatter f = new Formatter(System.out);
        f.format("%-20.20s | %5s %5.5s \n", "WORD", "VOWEL", "FQ");
        f.format("%-35.35s \n", "----------------------------------------------");
        for (Map.Entry<String,Integer> record : wordsMap.entrySet()) {
            wordVowelCount = 0;
            vowelM = vowelM.reset(record.getKey());
            while (vowelM.find()) {
                wordVowelCount++;
            }
            f.format("%-20.20s | %5d %5.5s \n", record.getKey(), wordVowelCount, "*" + Integer.toString(record.getValue()));
            totalVowelNum += wordVowelCount * record.getValue();
        }
        f.format("%-35.35s \n", "---------------------------------------------");
        f.format("%-20.20s | %5.5s \n", "Total Vowel:", Integer.toString(totalVowelNum));
    }

    //test Unit
    private static class UnitTest {
        private static final String WRONGPATH = "/Users/HelloKitty/hello.java";
        private static final String RIGHTPATH = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/Exercise16.java";
        private static void testReadFile() {
            System.out.println(readFile(WRONGPATH));
            System.out.println(readFile(RIGHTPATH));
        }
        private static void testSegmentWords() {
            System.out.println(segmentWords(readFile(RIGHTPATH)));
        }
        private static void testCountVowels() {
            countVowels(segmentWords(readFile(RIGHTPATH)));
        }
    }
    public static void main(String[] args) {
        //UnitTest.testReadFile();
        //UnitTest.testSegmentWords();
        UnitTest.testCountVowels();
    }
}
