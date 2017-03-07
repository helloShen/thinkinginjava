/**
 *  Primitive Generator
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class PrimConv{
        public static boolean[] toPrim(Boolean[] ba){
            boolean[] b=new boolean[ba.length];
            for(int j=0;j<ba.length;j++){
                b[j]=ba[j];
            }
            return b;
        }

        public static int[] toPrim(Integer[] ia){
            int[] i=new int[ia.length];
            for(int j=0;j<ia.length;j++){
                i[j]=ia[j];
            }
            return i;
        }
    
        public static long[] toPrim(Long[] la){
            long[] l=new long[la.length];
            for(int j=0;j<la.length;j++){
                l[j]=la[j];
            }
            return l;
        }
    
        public static short[] toPrim(Short[] sa){
            short[] s=new short[sa.length];
            for(int j=0;j<sa.length;j++){
                s[j]=sa[j];
            }
            return s;
        }
    
        public static float[] toPrim(Float[] fa){
            float[] f=new float[fa.length];
            for(int j=0;j<fa.length;j++){
                f[j]=fa[j];
            }
            return f;
        }

        public static double[] toPrim(Double[] da){
            double[] d=new double[da.length];
            for(int j=0;j<da.length;j++){
                d[j]=da[j];
            }
            return d;
        }
    
        public static byte[] toPrim(Byte[] ba){
            byte[] b=new byte[ba.length];
            for(int j=0;j<ba.length;j++){
                b[j]=ba[j];
            }
            return b;
        }
    
        public static char[] toPrim(Character[] ca){
            char[] c=new char[ca.length];
            for(int j=0;j<ca.length;j++){
                c[j]=ca[j];
            }
            return c;
        }
    
    public static void main(String[] args){
        
    }
}