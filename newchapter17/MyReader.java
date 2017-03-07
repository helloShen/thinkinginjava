/**
 * Exercise 21
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyReader {
    private static String spliter = "\n";
    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            try {
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line + spliter);
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
    public static List<String> segmentWords(String content) {
        String wordRegex = "\\w+";
        Matcher matcher = Pattern.compile(wordRegex).matcher(content);
        List<String> wordsList = new ArrayList<String>();
        while (matcher.find()) {
            wordsList.add(matcher.group());
        }
        return wordsList;
    }
    public static String[][] calculWordFreq(String content) {
        String wordRegex = "\\w+";
        Matcher matcher = Pattern.compile(wordRegex).matcher(content);
        Map<String,Integer> wordsFreq = new HashMap<String,Integer>();
        while (matcher.find()) {
            String word = matcher.group();
            if (wordsFreq.containsKey(word)) {
                wordsFreq.put(word,wordsFreq.get(word)+1);
            } else {
                wordsFreq.put(word,1);
            }
        }
        String[][] freqArray = new String[wordsFreq.size()][2];
        int index =0;
        for (Map.Entry<String,Integer> entry : wordsFreq.entrySet()) {
            freqArray[index][0] = entry.getKey();
            freqArray[index][1] = String.valueOf(entry.getValue());
            index++;
        }
        return freqArray;
    }
    private static class TestUnit {
        private final String WRONGPATH = "/Users/HelloKitty/hello.java";
        private final String RIGHTPATH = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/MyReader.java";
        private void testReadFile() {
            System.out.println(readFile(RIGHTPATH));
            System.out.println(readFile(WRONGPATH));
        }
        private void testSegmentWords() {
            System.out.println(segmentWords(readFile(RIGHTPATH)));
        }
        private void testCalculWordFreq() {
            String[][] wordsFreq = calculWordFreq(readFile(RIGHTPATH));
            for (String[] record : wordsFreq) {
                System.out.println(record[0] + ": " + record[1]);
            }
        }
    }
    public static void main(String[] args) {
        TestUnit test = new MyReader.TestUnit();
        //test.testReadFile();
        //test.testSegmentWords();
        test.testCalculWordFreq();
    }
}
