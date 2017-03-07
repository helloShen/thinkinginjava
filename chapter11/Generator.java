/**
 *  Chapter 11 Container - Exercise 4
 */

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class Generator {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static Generator getFilmGenerator(){
        String[] FILMNAME={"肖申克的救赎", "这个杀手不太冷", "阿甘正传", "霸王别姬", "美丽人生", "千与千寻", "辛德勒的名单", "海上钢琴师", "机器人总动员", "盗梦空间", "泰坦尼克号", "三傻大闹宝莱坞", "放牛班的春天", "忠犬八公的故事", "大话西游", "龙猫", "教父", "乱世佳人", "天堂电影院", "当幸福来敲门", "搏击俱乐部", "楚门的世界", "触不可及", "指环王3", "罗马假日"};
        return new Generator(FILMNAME);
    }

    /**
     *  PUBLIC METHOD
     */
    //loops around to the beginning of the character list when it runs out of names
    public String next(){
        while(true){
            if(it.hasNext()){
                return it.next();
            } else {
                it=strList.iterator();
            }
        }
    }
    
    //fil array
    public String[] filArray(int times){
        long begin=System.nanoTime();
        String[] resultArray=new String[times];
        for(int i=0;i<times;i++){
            resultArray[i]=next();
        }
        long end=System.nanoTime();
        double diff=(end-begin)/1e6;
        System.out.println(diff);
        return resultArray;
    }
    
    //fil arraylist
    public void filCollection(Collection<String> c, int times){
        long begin=System.nanoTime();
        for(int i=0;i<times;i++){
            c.add(next());
        }
        long end=System.nanoTime();
        double diff=(end-begin)/1e6;
        System.out.println(diff);
    }
    
    public String toString(){
        return strList.toString();
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private Generator(List<String> inList){
        strList=inList;
        it=strList.iterator();
    }
    private Generator(String[] inArray){
        strList.addAll(Arrays.asList(inArray));
        it=strList.iterator();
    }

    
    /**
     *  PRIVATE FILEDS
     */
    private List<String> strList=new ArrayList<String>();
    Iterator<String> it=strList.iterator();
    
    /**
     *  MAIN
     */
    public static void main(String[] args){
        Generator fg=Generator.getFilmGenerator();
        
        //fil array
        System.out.println(">>>Array:  ");
        String[] a=fg.filArray(1000000);
        
        //fil arraylist
        System.out.println(">>>ArrayList:  ");
        List<String> al=new ArrayList<String>();
        fg.filCollection(al,1000000);
        
        //fil lindelist
        System.out.println(">>>LinkedList:  ");
        List<String> ll=new LinkedList<String>();
        fg.filCollection(ll,1000000);
        
        //fil hashset
        System.out.println(">>>HashSet:  ");
        Set<String> hs=new HashSet<String>();
        fg.filCollection(hs,1000000);
        
        //fil linkedhashset
        System.out.println(">>>LinkedHashSet:  ");
        Set<String> lhs=new LinkedHashSet<String>();
        fg.filCollection(lhs,1000000);
        
        //fil treeset
        System.out.println(">>>TreeSet:  ");
        Set<String> ts=new TreeSet<String>();
        fg.filCollection(ts,1000000);
        
    }
    
}