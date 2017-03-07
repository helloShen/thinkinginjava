/**
 *  递归获取指定节点所有子文件
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        
        String str3 = new StringBuilder("he").append("llo").toString();
        System.out.println(str3.intern() == str3);
        
        String str4 = new StringBuilder("ja").append("r").toString();
        System.out.println(str4.intern() == str4);
        
        String str5 = new StringBuilder("ma").append("in").toString();
        System.out.println(str5.intern() == str5);
        
        String str6 = new StringBuilder("Cl").append("ass").toString();
        System.out.println(str6.intern() == str6);
        
        String str7 = new StringBuilder("vo").append("id").toString();
        System.out.println(str7.intern() == str7);
        
        String str8 = new StringBuilder("pub").append("lic").toString();
        System.out.println(str8.intern() == str8);
        
        String str9 = new StringBuilder("i").append("f").toString();
        System.out.println(str9.intern() == str9);
        
        String str10 = new StringBuilder("re").append("turn").toString();
        System.out.println(str10.intern() == str10);
        
        String str11 = new StringBuilder("pack").append("age").toString();
        System.out.println(str11.intern() == str11);
        
        String str12 = new StringBuilder("imp").append("ort").toString();
        System.out.println(str12.intern() == str12);
        
        String str13 = new StringBuilder("kla").append("ss").toString();
        System.out.println(str13.intern() == str13);
        
        String str14 = new StringBuilder("lo").append("cal").toString();
        System.out.println(str14.intern() == str14);
        
        String str15 = new StringBuilder("su").append("n").toString();
        System.out.println(str15.intern() == str15);
        
        String str16 = new StringBuilder("l").append("ang").toString();
        System.out.println(str16.intern() == str16);
        
        String str17 = new StringBuilder("Sys").append("tem").toString();
        System.out.println(str17.intern() == str17);
        
    }
}