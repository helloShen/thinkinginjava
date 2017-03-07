/**
 *  Exercise Chapter 10 Hold yr objects
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class UniqueWords {
    //constante Vowel string
    public final static Set<String> VOWEL=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    static{
        VOWEL.addAll(Arrays.asList("auieoAUIEO".split("")));
    }
    
    //constante vowel char
    public final static Set<Character> VOWELCHAR=new TreeSet<Character>();
    //public final static ArrayList<Character> VOWELCHAR=new ArrayList<Character>();
    static{
        Collections.addAll(VOWELCHAR,
                           'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
    }
    
    //16
    public static void exercise16(String address){
        //calculate the time
        long start_time = System.nanoTime();
        //my action
        countVowels(toWords(getStream(address)));
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }
    
    //20
    public static void exercise20(String address){
        //calculate the time
        long start_time = System.nanoTime();
        //my action
        countEachVowels(toWords(getStream(address)));
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }
    
    //21
    public static void exercise21(String address){
        //calculate the time
        long start_time = System.nanoTime();
        //my action
        countWordsOccurence(toWords(getStream(address)));
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }
    
    //22
    public static void exercise22(String address){
        //calculate the time
        long start_time = System.nanoTime();
        //my action
        countWordsOccurenceWithStrEntry(toWords(getStream(address)));
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);
    }
    
    //read the text into a string from a text file
    public static String getStream(String address){
        try(BufferedReader br=new BufferedReader(new FileReader(address))){
            StringBuilder sb=new StringBuilder();
            String line=br.readLine();
            
            //read file line by line and add them to te StringBuilder
            while(line!=null){
                sb.append(line+System.lineSeparator());
                line=br.readLine();
            }
            //just for test
            //System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e){
            // insert code to run when exception occurs
            System.out.println("We cannot find your file! Please check and try again!");
            return new String();
        }
    }
    
    //segement the string stream to a list of words
    public static List<String> toWords(String inStream){
        List<String> linesList=new ArrayList<String>();
        List<String> wordsList=new ArrayList<String>();
        
        //cut line by line
        linesList.addAll(Arrays.asList(inStream.split(System.lineSeparator())));
        
        //split each line into list of words
        for(String line : linesList){
            wordsList.addAll(Arrays.asList(line.split(" ")));
        }
        //just for test
        //System.out.println(wordsList.toString());
        return wordsList;
    }
    
    //optional step: I had hoped to optimize the effectiveness
    //sort each words in the word list
    public static List<String> sortWords(List<String> wordsList){
        //output sorted words list
        List<String> sortedWords=new ArrayList<String>();
        //store the words already sorted
        Map<String,String> sortedMap=new HashMap<String,String>();
        
        //sort only one time for each word
        for(String word : wordsList){
            if(sortedMap.containsKey(word)){
                sortedWords.add(sortedMap.get(word));
            } else {
                char[] wordChars=word.toCharArray();
                Arrays.sort(wordChars);
                String sorted=String.valueOf(wordChars);
                sortedWords.add(sorted);
                sortedMap.put(word,sorted);
            }
        }
        //just for test
        //System.out.println(sortedWords.toString());
        return sortedWords;
    }
    
    //count and display the number of vowels in each word
    //count and display the total number of vowels in the input file
    public static void countVowels(List<String> wordsList){
        int totalVowelNum=0;
        List<Integer> numList=new ArrayList<Integer>();
        for(String word : wordsList){
            //call countVowelsForEachWord()
            int vowelNum=countVowelsForEachCharWord(word);
            numList.add(new Integer(vowelNum));
            //calculate the total num
            totalVowelNum+=vowelNum;
        }
        //print
        //System.out.println(">>> Number of vowel in each word:   ");
        //System.out.println(numList.toString());
        System.out.println(">>> Total number of vowel in this file:   ");
        System.out.println(totalVowelNum);
    }
    
    //calculate the number of vowel of a given word
    //V1.0: String + split()
    public static int countVowelsForEachWord(String inWord){
        int vowelNum=0;
        String[] wordChars=inWord.split("");
        for(String s : wordChars){
            if(VOWEL.contains(s)){
                vowelNum++;
            }
        }
        return vowelNum;
    }
    
    //calculate the number of vowel of a given word
    //V2.0: Char + toCharArray()
    //5 times faster than countVowelsForEachWord(String inWord)
    //compare the value of String takes much more time than char
    public static int countVowelsForEachCharWord(String inWord){
        int vowelNum=0;
        char[] wordChars=inWord.toCharArray();
        for(char c : wordChars){
            if(VOWELCHAR.contains(c)){
                vowelNum++;
            }
        }
        return vowelNum;
    }
    
    //count and display the total number of each vowels in the input file
    public static void countEachVowels(List<String> wordsList){
        //initialize the result container
        Map<Character,Integer> resultMap=new HashMap<Character,Integer>();
        //count for each word
        for(String word : wordsList){
            //call method countEachVowelsForEachCharWord()
            countEachVowelsForEachCharWord(word, resultMap);
        }
        //print
        System.out.println(">>> Total number of each vowel in this file:   ");
        System.out.println(resultMap.toString());
        
    }
    
    //calculate the number of each vowel of a given word
    public static void countEachVowelsForEachCharWord(String inWord, Map<Character,Integer> resultMap){
        //cut words into char[]
        for(Character c : inWord.toCharArray()){
            if(VOWELCHAR.contains(c)){
                for(Character ch : VOWELCHAR){
                    if(ch.equals(c)){
                        Integer i=resultMap.get(ch);
                        resultMap.put(ch,i==null ? 1 : i+1);
                    }
                }
            }
        }
    }
    
    //counts the occurrence of words in a file
    public static void countWordsOccurence(List<String> wordsList){
        Map<String, Integer> wordsMap=new HashMap<String,Integer>();
        for(String word : wordsList){
            Integer i=wordsMap.get(word);
            wordsMap.put(word, i==null? 1:i+1);
        }
        
        //sort key of the wordsMap
        List<String> keyList=new ArrayList<String>();
        keyList.addAll(wordsMap.keySet());
        Collections.sort(keyList,String.CASE_INSENSITIVE_ORDER);
        
        //print
        for(String s : keyList){
            Integer i=wordsMap.get(s);
            System.out.println(s+":     "+(i==null? 0:i));
        }
    }
    
    //counts the occurrence of words in a file
    //use Set<StrEntry> as the result container
    public static void countWordsOccurenceWithStrEntry(List<String> wordsList){
        //initialize Set<StrEntry>
        Set<StrEntry> resultSet=new HashSet<StrEntry>();
        
        for(String word : wordsList){
            Iterator<StrEntry> it = resultSet.iterator();
            while(it.hasNext()){
                StrEntry se=it.next();
                if(se.getWord().equals(word)){
                    se.set(word, se.getOccurence()+1);
                    break;
                }
            }
            resultSet.add(new StrEntry(word,1));
        }
        System.out.println(resultSet.toString());
    }
    
    public static void main(String[] args){
        //test countVowelsForEachWord
        //System.out.println(UniqueWords.countVowelsForEachWord("helloWorld"));
        
        //test countVowels
        //List<String> testWordsList=new ArrayList<String>();
        //testWordsList.addAll(Arrays.asList("hello world".split(" ")));
        //UniqueWords.countVowels(testWordsList);
        
        //test countVowels
        //List<String> testWordsList=new ArrayList<String>();
        //testWordsList.addAll(Arrays.asList("hello world".split(" ")));
        //List<String> sortedList=UniqueWords.sortWords(testWordsList);
        //UniqueWords.countVowels(sortedList);
        
        //test toWords
        //UniqueWords.toWords("Hello world !");
        
        //test getStream
        //UniqueWords.getStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java");
        
        //Exercise 16
        //UniqueWords.exercise16("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java");
        
        //Exercise 20
        //UniqueWords.exercise20("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java");
        
        //Exercise 21
        //UniqueWords.exercise21("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java");
        
        //Exercise 22
        UniqueWords.exercise22("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java");
        
    }
    
}