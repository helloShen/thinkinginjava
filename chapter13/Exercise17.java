/**
 * Exercise 17
 * 不可能写出十全十美的能找出所有注释的正则表达式。这个版本只能匹配几种最常见的情况。仅适用于遵守Google推荐编程风格的代码。
 *      1. //注释
 *      2. / * 单行正式注释 * /
 *      3. / * 多行注释 * /
 *      4. 如果注释在双引号""里，就不是注释。
 *      5. 如果引号前面是\反斜杠，就不是引号。
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Exercise17 {
    private static final String SPLITER = "\n";
    private static boolean isInFormalAnnotation = false;
    // open a file, return a string, return null otherwise
    public static String readFile(String path) {
        File inFile = new File(path);
        if( !inFile.exists() || !inFile.isFile() ) {
            System.out.println("Path ERROR! Check your path " + path);
            return null;
        }
        StringBuilder resultString = new StringBuilder();
        try {
            BufferedReader buffReader = new BufferedReader( new FileReader( inFile) );
            try {
                String textLine = new String("");
                while (true) {
                    textLine = buffReader.readLine();
                    if (textLine == null) {
                        break;
                    }
                    resultString.append(textLine + SPLITER);
                }
            } finally {
                buffReader.close();
            }
        } catch (IOException ioe) {
            System.out.println( "ERROR when reading the file " + inFile.getName() );
        }
        return resultString.toString();
    }
    // print all annotation
    public static void scanAnnotation(String path){
        String content = readFile(path);
        if (content == null || content.isEmpty()) {
            System.out.println("Method scan() cannot read file " + path);
            return;
        }
        String simpleAnnotation = new String("");
        String formalAnnotation = new String("");
        for (String line : content.split(SPLITER)) {
            //main procedure
            simpleAnnotation = getSimpleAnnotation(line);
            if(simpleAnnotation != null) {
                System.out.println(simpleAnnotation);
            }
            formalAnnotation = getFormalAnnotation(line);
            if(formalAnnotation != null) {
                System.out.println(formalAnnotation);
            }
        }
    }

    // box-1.
    // input:   string line,
    // output:  return simple annotation. otherwise return null
    private static String getSimpleAnnotation(String line) {
        String simpleAnnotationRegex = "\\s//";
        Matcher simpleAnnotationMatcher = Pattern.compile(simpleAnnotationRegex).matcher(line);
        while (simpleAnnotationMatcher.find()) {
            if (!isInStringQuote(line.substring(0, simpleAnnotationMatcher.start()))) {
                return line.substring(simpleAnnotationMatcher.start());
            }
        }
        return null;
    }

    // box-2.
    // input: string line,
    // output: return formal annotation. otherwise return null
    private static String getFormalAnnotation(String line) {
        String formalBeginRegex = "/\\*";
        String formalEndRegex = "\\*/";
        if (!isInFormalAnnotation) {
            Matcher formalBeginMatcher = Pattern.compile(formalBeginRegex).matcher(line);
            while (formalBeginMatcher.find()) {
                if (!isInStringQuote(line.substring(0,formalBeginMatcher.start()))) {
                    isInFormalAnnotation = true;
                    String subLine = line.substring(formalBeginMatcher.start());
                    Matcher formalEndMatcher = Pattern.compile(formalEndRegex).matcher(subLine);
                    if (formalEndMatcher.find()) {
                        isInFormalAnnotation = false;
                        return subLine.substring(0,formalEndMatcher.end());
                    }
                    return subLine;
                }
            }
        } else {
            Matcher formalEndMatcher = Pattern.compile(formalEndRegex).matcher(line);
            if (formalEndMatcher.find()) {
                isInFormalAnnotation = false;
            }
            return line;
        }
        return null;
    }

    /*
     * box-3
     * input: prefix of annotation line
     * output: boolean. if this prefix text is in string quote.
     */
    private static boolean isInStringQuote(String prefix) {
        String doubleQuoteRegex = "(^|\\s*)\".*?[^\\\\]\"|\"\"";
        Matcher doubleQuoteMatcher = Pattern.compile(doubleQuoteRegex).matcher(prefix);
        if(! doubleQuoteMatcher.find()) {
            String singleQuoteRegex = "[^\\\\]\"";
            Matcher singleQuoteMatcher = Pattern.compile(singleQuoteRegex).matcher(prefix);
            return singleQuoteMatcher.find();
        } else {
            return isInStringQuote(prefix.replaceFirst(doubleQuoteRegex, ""));
        }
    }

    private static void testUnitScanAnnotation() {
        String wrongPath = "/Users/helloKitty/java/com/ciaoshen/thinkinjava/chapter13/Exercise17.java";
        String rightPath= "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise17.java";
        Exercise17.scanAnnotation(rightPath);
        Exercise17.scanAnnotation(wrongPath);
    }
    private static void testIsInStringQuote(String prefix) {
        System.out.println(isInStringQuote(prefix));
    }
    public static void main(String[] args) {
        String testPatternString = "a" + "b //假注释" + "c" + "d";   /*给注释匹配模式出个难题*/
        String testPatternString2 = "\"a\" + \"b //假注释";
        Exercise17.testUnitScanAnnotation();
        //Exercise17.testIsInStringQuote(testPatternString);
        //Exercise17.testIsInStringQuote(testPatternString2);
    }
}
