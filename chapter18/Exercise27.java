/**
 *  Exercise 27
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.nio.*;

public class Exercise27{
    
    private static Random rander=new Random();
    
    public static class Pregnant implements Serializable{
        private static final long serialVersionUID=1L;
        private int month;
        private Baby theBaby;
        public Pregnant(int month){
            this.month=month;
            theBaby=new Baby(month);
        }
        public String toString(){return "Pregnant for "+month+" month!   Baby weights "+theBaby.getWeight()+" KG!";}
    }
    
    public static class Baby implements Serializable{
        private static final long serialVersionUID=1L;
        private float weight;
        private int sex;
        public Baby(int month){
            weight=rander.nextFloat()*rander.nextInt(2)+(float)month;
            sex=rander.nextInt(1);
        }
        public float getWeight(){return weight;}
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Exercise27.Pregnant p=new Pregnant(5);
        File f=new File("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Exercise27.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        //序列化
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f));
        out.writeObject(p);
        
        //反序列化
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
        Pregnant p2=(Pregnant)in.readObject();
        System.out.println(p2);
    }
}