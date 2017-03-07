/**
 * Exercise 4
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise4 {
    public static interface Generator<T> {
        public T next();
    }
    public static class FilmGenerator implements Generator<String> {
        private static final String[] FILMNAME={"肖申克的救赎", "这个杀手不太冷", "阿甘正传", "霸王别姬", "美丽人生",
            "千与千寻", "辛德勒的名单", "海上钢琴师", "机器人总动员", "盗梦空间", "泰坦尼克号",
            "三傻大闹宝莱坞", "放牛班的春天", "忠犬八公的故事", "大话西游", "龙猫", "教父",
            "乱世佳人", "天堂电影院", "当幸福来敲门", "搏击俱乐部", "楚门的世界", "触不可及",
            "指环王3","罗马假日"};
        private static final int LENGTH = FILMNAME.length;
        private static int count = 0;

        private final int id = ++count;
        private int cursor = 0;
        public String next() {
            if (cursor == LENGTH) {
                cursor =  0;
            }
            return FILMNAME[cursor++];
        }
    }
    public static Generator<String> getFilmGenerator(){
        return new FilmGenerator();
    }
    public static String[] getFilms(String[] array) {
        Generator<String> gen = getFilmGenerator();
        for (int i = 0; i < array.length; i++) {
            array[i] = gen.next();
        }
        return array;
    }
    public static Collection<String> getFilms(Collection<String> c, int filmNum) {
        Generator<String> gen = getFilmGenerator();
        for (int i = 0; i < filmNum; i++) {
            c.add(gen.next());
        }
        return c;
    }

    @SuppressWarnings({"unchecked","rawtypes"})
    public static void main(String[] args){
        int size = 10;
        //fil array
        System.out.println(">>>Array:  ");
        System.out.println(Arrays.toString(getFilms(new String[size])));
        //fil arraylist
        System.out.println(">>>ArrayList:  ");
        System.out.println(getFilms(new ArrayList(),size));
        //fil lindelist
        System.out.println(">>>LinkedList:  ");
        System.out.println(getFilms(new LinkedList(),size));
        //fil hashset
        System.out.println(">>>HashSet:  ");
        System.out.println(getFilms(new HashSet(),size));
        //fil linkedhashset
        System.out.println(">>>LinkedHashSet:  ");
        System.out.println(getFilms(new LinkedHashSet(),size));
        //fil treeset
        System.out.println(">>>TreeSet:  ");
        System.out.println(getFilms(new TreeSet(),size));
    }
}
