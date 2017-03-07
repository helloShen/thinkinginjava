/**
 *  Exercise 14
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class Exercise14{
    public static void main(String[] args){
        CountingGenerator.Boolean b=new CountingGenerator.Boolean();
        CountingGenerator.Integer ii=new CountingGenerator.Integer();
        CountingGenerator.Long l=new CountingGenerator.Long();
        CountingGenerator.Short s=new CountingGenerator.Short();
        CountingGenerator.Float f=new CountingGenerator.Float();
        CountingGenerator.Double d=new CountingGenerator.Double();
        CountingGenerator.Byte bt=new CountingGenerator.Byte();
        CountingGenerator.Character c=new CountingGenerator.Character();
        
        Boolean[] bb=new Boolean[10];
        Integer[] iii=new Integer[10];
        Long[] ll=new Long[10];
        Short[] ss=new Short[10];
        Float[] ff=new Float[10];
        Double[] dd=new Double[10];
        Byte[] btbt=new Byte[10];
        Character[] cc=new Character[10];
        
        boolean[] ba=new boolean[10];
        int[] ia=new int[10];
        long[] la=new long[10];
        short[] sa=new short[10];
        float[] fa=new float[10];
        double[] da=new double[10];
        byte[] bta=new byte[10];
        char[] ca=new char[10];
        
        for(int i=0;i<10;i++){
            bb[i]=b.next();
            iii[i]=ii.next();
            ll[i]=l.next();
            ss[i]=s.next();
            ff[i]=f.next();
            dd[i]=d.next();
            btbt[i]=bt.next();
            cc[i]=c.next();
        }
        

        ba=PrimConv.toPrim(bb);
        ia=PrimConv.toPrim(iii);
        la=PrimConv.toPrim(ll);
        sa=PrimConv.toPrim(ss);
        fa=PrimConv.toPrim(ff);
        da=PrimConv.toPrim(dd);
        bta=PrimConv.toPrim(btbt);
        ca=PrimConv.toPrim(cc);
        
        for(int i=0;i<10;i++){
            System.out.print(ba[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(ia[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(la[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(sa[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(fa[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(da[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(bta[i]);
        }
        System.out.println("");
        for(int i=0;i<10;i++){
            System.out.print(ca[i]);
        }
    }
}