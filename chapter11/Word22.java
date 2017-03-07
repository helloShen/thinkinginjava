// holding/UniqueWords22.java
// TIJ4 Chapter Holding, Exercise 22, page422
/* Modify the previous exercise so that it uses a class containing a String and
 * a count field to store each different word, and a Set of these objects to
 * maintain the list of words.
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;


class Word {
    static int totalWords = 0;
    String s;
    int count;
    Word(String s, int count) {
        this.s = s;
        this.count = count;
        totalWords++;
    }
    public String toString() { return s + ": " + count; }
}

public class Word22 {
    public static void main(String[] args) {
        //calculate the time
        long start_time = System.nanoTime();
        //action
        List<String> words = new ArrayList<String>(UniqueWords.toWords(UniqueWords.getStream("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter11/UniqueWords.java")));
        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Words to count, sorted: " + words);
        Set<Word> wordObjects = new HashSet<Word>();
        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            String s = it.next();
            int count = 0;
            for(int i = 0; i < words.size(); i++) {
                if(s.equals(words.get(i))) count++;
            }
            Word w = new Word(s, count);
            wordObjects.add(w);
        }		
        System.out.println("Word count: " + wordObjects);
        System.out.println("Total words: " + Word.totalWords);
        //calculate time
        long end_time = System.nanoTime();
        double difference = (end_time - start_time)/1e6;
        System.out.println(difference);

    }		
}
