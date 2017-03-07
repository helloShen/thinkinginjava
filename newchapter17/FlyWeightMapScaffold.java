/**
 * Fly Weight Scafflod
 */
package com.ciaoshen.thinkinjava.newchapter17;
import java.util.*;

// 可以接受任意外部String二维数组作为DATA的数据源。
public class FlyWeightMapScaffold extends AbstractMap<String,String> {
    public final String[][] DATA;
    private int size;
    public FlyWeightMapScaffold(String[][] data, int num) {
        if (data.length == 0 || num <= 0) {
            throw new RuntimeException();
        }
        DATA = data;
        size = num;
        if (size > DATA.length) {
            size = DATA.length;
        }
    }
    public FlyWeightMapScaffold(String[][] data) {
        this(data,data.length);
    }
    public int size() {
        return size;
    }
    public class Pair implements Map.Entry<String,String> {
        private int index=0;
        public Pair(int num) {
            index = num;
        }
        public String getKey() {
            return DATA[index][0];
        }
        public String getValue() {
            return DATA[index][1];
        }
        public String setValue(String str) {
            throw new UnsupportedOperationException();
        }
        public boolean equals(Object o) {
            if (o == null || ! (o instanceof Pair)) {
                return false;
            }
            return DATA[index][0].equals((Pair)o);
        }
        public int hashCode() {
            return DATA[index][0].hashCode();
        }
    }
    public class DataSet extends AbstractSet<Map.Entry<String,String>> {
        private int index = 0;
        private Pair viewWindow = new Pair(-1);
        public Iterator<Map.Entry<String,String>> iterator() {
            return new Iterator<Map.Entry<String,String>>() {
                public boolean hasNext() {
                    return index < size;
                }
                public Map.Entry<String,String> next() {
                    viewWindow.index++;
                    index++;
                    return viewWindow;
                }
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
        public int size() {
            return size;
        }
    }
    public Set<Map.Entry<String,String>> entrySet() {
        return new DataSet();
    }

    public static void main(String[] args) {
        String path = "/Users/Wei/java/com/ciaoshen/thinkinjava/newchapter17/FlyWeightMapScaffold.java";
        // 这里使用的外部数据，由我工具箱里的MyReader.calculWordFreq()方法产生。
        String[][] data = MyReader.calculWordFreq(MyReader.readFile(path));
        FlyWeightMapScaffold dataMap = new FlyWeightMapScaffold(data);
        Formatter f = new Formatter(System.out);
        // 打印整个词频表
        for(Map.Entry<String,String> entry : dataMap.entrySet()) {
            f.format("Word: %1$-20.20s Frequence: %2$-20.20s \n", entry.getKey(), entry.getValue());
        }
        // 只打印单词列表
        for (String word : dataMap.keySet()) {
            f.format("Word: %1$-20.20s \n", word);
        }
    }
}
