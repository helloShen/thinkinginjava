/**
 *  Exercise 7 - Chapter 13
 */

package com.ciaoshen.thinkinjava.chapter13;
import java.util.*;
import java.util.regex.*;


class UseRegex {
    
    /**
     *  PUBLIC STATIC FIELDS
     */
    public static String knights =
    "Then, when you have found the shrubbery, you must " +
    "cut down the mightiest tree in the forest... " +
    "with... a herring!";
    
    /**
     *  PUBLIC METHOD
     */
    //Exercise 7：句子是否以大写字母开头，以句号结尾
    public static void checkPhrase(String phrase){
        System.out.println(phrase.matches("\\p{Upper}(\\w| )+\\."));
    }
    
    //Exercise 8: 以"the"或"you."为标志切割
    public static void split(String phrase){
        String[] strList=phrase.split("(the)|(you\\.)");
        for(String s : strList){
            System.out.println(s);
        }
    }
    
    //Exercise 9: 以下划线"_"替代元音字母
    public static void replaceVowels(String phrase){
        System.out.println(phrase.replaceAll("a|e|i|o|u","_"));
    }
    
    //For Exercise 10: Matcher#matches()方法用正则表达式去匹配这个phrase。
    public static boolean matcherMatches(String regex, String phrase){
        //先构造一个Pattern
        Pattern p=Pattern.compile(regex);
        //给p一个String参数，获得一个Matcher
        Matcher m=p.matcher(phrase);
        //用Matcher#matches()方法判断String参数里有没有有没有匹配到正则表达式。
        return m.matches();
    }
    
    //For Exercise 10: Matcher#lookingAt()方法从phrase的开头开始匹配正则表达式。
    public static boolean matcherLookingAt(String regex, String phrase){
        //先构造一个Pattern
        Pattern p=Pattern.compile(regex);
        //给p一个String参数，获得一个Matcher
        Matcher m=p.matcher(phrase);
        //用Matcher#matches()方法判断String参数里有没有有没有匹配到正则表达式。
        return m.lookingAt();
    }
    
    //For Exercise 10: Matcher#find()方法判断当前phrase里能不能有子字符串匹配到正则表达式。
    public static boolean matcherFind(String regex, String phrase){
        //先构造一个Pattern
        Pattern p=Pattern.compile(regex);
        //给p一个String参数，获得一个Matcher
        Matcher m=p.matcher(phrase);
        //用Matcher#matches()方法判断String参数里有没有有没有匹配到正则表达式。
        return m.find();
    }
    
    //For Exercise 10: Matcher#find()方法判断当前phrase里能不能有子字符串匹配到正则表达式。然后打印匹配到的子字符串。
    public static void matcherFindPrint(String regex, String phrase){
        //先构造一个Pattern
        Pattern p=Pattern.compile(regex);
        //给p一个String参数，获得一个Matcher
        Matcher m=p.matcher(phrase);
        //用Matcher#matches()方法判断String参数里有没有有没有匹配到正则表达式。
        while(m.find()){
            System.out.println(m.group());
        }
    }

    //Exercise 10: 通过Pattern#matcher()构造一个Matcher，然后检查能不能匹配
    //"^Java":开头四个字符是"Java".    //true
    //"\\Breg.*":不是一个单词开头的reg以及它的后续 //false
    //"n.w\\s+h(a|i)s": n + 任何字符 + w + 一个或多个空白符 + h + a或者i + s  //匹配到的是now has
    //"s?":有一个或没有s
    //"s*":有一个或多个或没有s
    //"s+":一个或多个s
    //"s{4}":4个连续的s
    //"s{1}.":一个s加上任意一个字符（不在末尾的s加上后续一位字符）
    //"s{0,3}":没有或一个或两个s
    public static void exercise10(){
        String phrase="Java now has regular expressions";
        String[] patterns={"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","s{1}.","s{0,3}"};
        for(String s : patterns){
            //System.out.println(matcherMatches(s,phrase));
            //System.out.println(matcherLookingAt(s,phrase));
            //System.out.println(matcherFind(s,phrase));
            matcherFindPrint(s,phrase);
        }
    }
    
    //Excercise 11
    //用"(?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"
    //来匹配"Arline ate eight apples and one orange while Anita hadn’t any"
    //"(?i)"是一个模式标记。表示忽略大小写
    //后面的"((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b"表示一个以元音开头，元音结尾的单词
    public static void exercise11(){
        String phrase="(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String pattern="Arline ate eight apples and one orange while Anita hadn’t any";
        //匹配整个phrase
        System.out.println(UseRegex.matcherMatches(pattern,phrase));
        //phrase的某个子字符串符合pattern就行
        System.out.println(UseRegex.matcherFind(pattern,phrase));
    }
    
    /**
     *  MAIN
     */
    public static void main (String[] args){
        String phr1="This is well witten phrase.";
        String phr2="this is not.";
        String phr3="Neither do this!";
        String phr4="The.forth.is.bad.";
        String testPoint="one.two.three.four";
        
        
        //UseRegex.checkPhrase(phr1);
        //UseRegex.checkPhrase(phr2);
        //UseRegex.checkPhrase(phr3);
        //UseRegex.checkPhrase(phr4);
        //UseRegex.split(testPoint);
        //UseRegex.split(UseRegex.knights);
        //UseRegex.replaceVowels(UseRegex.knights);
        //UseRegex.exercise10();
        UseRegex.exercise11();
        
    }

}