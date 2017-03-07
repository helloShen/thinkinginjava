/**
 * Exercise 18
 */
package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Exercise18 {
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


    // erase all annotation
    public static String eraseAnnotation(String path){
        StringBuilder resultBuilder = new StringBuilder();
        String content = readFile(path);
        if (content == null || content.isEmpty()) {
            System.out.println("Method scan() cannot read file " + path);
            return null;
        }
        String noSimpleAnnotation = new String("");
        String noFormalAnnotation = new String("");
        for (String line : content.split(SPLITER)) {
            //main procedure
            noSimpleAnnotation = eraseSimpleAnnotation(line);
            noFormalAnnotation= eraseFormalAnnotation(noSimpleAnnotation);
            if (noFormalAnnotation != null) {
                System.out.println(noFormalAnnotation);
                resultBuilder.append(noFormalAnnotation + SPLITER);
            }
        }
        return resultBuilder.toString();
    }

    // box-1.
    // input:   string line,
    // output:  erase simple annotation.
    private static String eraseSimpleAnnotation(String line) {
        String simpleAnnotationRegex = "\\s//";
        Matcher simpleAnnotationMatcher = Pattern.compile(simpleAnnotationRegex).matcher(line);
        while (simpleAnnotationMatcher.find()) {
            if (!isInStringQuote(line.substring(0, simpleAnnotationMatcher.start()))) {
                return line.substring(0, simpleAnnotationMatcher.start());
            }
        }
        return line;
    }

    // box-2.
    // input: string line,
    // output: erase the formal annotation.
    private static String eraseFormalAnnotation(String line) {
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
                        return line.replace(subLine.substring(0,formalEndMatcher.end()),"");
                    }
                    return line.replace(subLine,"");
                }
            }
        } else {
            Matcher formalEndMatcher = Pattern.compile(formalEndRegex).matcher(line);
            if (formalEndMatcher.find()) {
                isInFormalAnnotation = false;
            }
            return null;
        }
        return line;
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

    // box-4
    // input: entire text file
    // output: erase all literal string in double quote
    private static String filterLiteralString(String content) {
        StringBuilder resultBuilder = new StringBuilder();
        for (String line : content.split(SPLITER)) {
            resultBuilder.append(eraseLiteralString(line) + SPLITER);
        }
        return resultBuilder.toString();
    }

    // box-5
    // input: line string
    // output: erase literal string in double quote
    private static String eraseLiteralString(String line) {
        String doubleQuoteRegex = "(^|\\s*)\".*?[^\\\\]\"|\"\"";
        return line.replaceAll(doubleQuoteRegex,"");
    }

    private static void start(String path) {
        String noAnnotation = eraseAnnotation(path);
        String noLiteral = filterLiteralString(noAnnotation);
        System.out.println(noLiteral);
    }

    private static void testUnitEraseAnnotation() {
        String wrongPath = "/Users/helloKitty/java/com/ciaoshen/thinkinjava/chapter13/Exercise18.java";
        String rightPath = "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise18.java";
        Exercise18.eraseAnnotation(rightPath);
        Exercise18.eraseAnnotation(wrongPath);
    }

    private static void testIsInStringQuote(String prefix) {
        System.out.println(isInStringQuote(prefix));
    }
    private static void testUnitEraseLiteralString(String phrase) {
        System.out.println(eraseLiteralString(phrase));
    }
    private static void testUnitFilterLiteralString(String content) {
        System.out.println(filterLiteralString(content));
    }
    private static void testUnitStart() {
        String wrongPath = "/Users/helloKitty/java/com/ciaoshen/thinkinjava/chapter13/Exercise18.java";
        String rightPath= "/Users/Wei/java/com/ciaoshen/thinkinjava/chapter13/Exercise18.java";
        Exercise18.start(rightPath);
        Exercise18.start(wrongPath);
    }
    public static void main(String[] args) {
        String testPatternString = "a" + "b //假注释" + "c" + "d";   /*给注释匹配模式出个难题*/
        String testPatternString2 = "\"a\" + \"b //假注释";
        //Exercise18.testUnitEraseAnnotation();
        //Exercise18.testIsInStringQuote(testPatternString);
        //Exercise18.testIsInStringQuote(testPatternString2);
        //Exercise18.testUnitEraseLiteralString(testPatternString);
        //Exercise18.testUnitEraseLiteralString(testPatternString2);
        Exercise18.testUnitStart();
    }
}
