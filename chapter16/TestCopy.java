/**
 *  测试4中不同拷贝方法的效率
 */
package com.ciaoshen.thinkinjava.chapter16;
import java.util.*;

public class TestCopy{
    public static void main(String[] args){
        int[] ia=new int[100000];
        Random rand=new Random();
        for(int i=0;i<ia.length;i++){
            ia[i]=rand.nextInt(100000);
        }

/**
        //for循环: 466510
        long begin=System.nanoTime();
        for(int j=0;j<10;j++){
            int[] copy=new int[100000];
            for(int i=0;i<ia.length;i++){
                copy[i]=ia[i];
            }
        }
        long end=System.nanoTime();
        System.out.println((end-begin)/10);
*/
 
/**
        //Arrays.copyOf(): 238986
        long begin=System.nanoTime();
        for(int j=0;j<10;j++){
            int[] copy=Arrays.copyOf(ia,ia.length+1);
        }
        long end=System.nanoTime();
        System.out.println((end-begin)/10);
 */

/**
        //System.arraycopy(): 54520
        long begin=System.nanoTime();
        int[] copy=new int[100000];
        for(int j=0;j<10;j++){
            System.arraycopy(ia,0,copy,0,ia.length);
        }
        long end=System.nanoTime();
        System.out.println((end-begin)/10);
 */

/**
        //Object.clone(): 227170
        long begin=System.nanoTime();
        int[] copy=new int[100000];
        for(int j=0;j<10;j++){
            copy=ia.clone();
        }
        long end=System.nanoTime();
        System.out.println((end-begin)/10);
 */
        
        int[] a={1,2,3};
        int[] b=Arrays.copyOf(a,4);
        b[3]=4;
        //b=a.clone();
        System.out.println(Arrays.toString(b));

        
    }
}