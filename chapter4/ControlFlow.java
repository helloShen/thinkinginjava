/**
 *  This class is used to test control flow in chapter 4.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter4;

import java.util.*;

/**
 *  Our class
 */
public class ControlFlow {
    //useful tool
    private Random dice = new Random(77);
    
    //default constructor
    public ControlFlow(){ }
    
    //another constructor with random seed as param
    public ControlFlow(int seed){
        this.dice = new Random(seed);
    }
    
    //tool to print List<String> type data
    public static void printList(List<String> inList){
        for(String str : inList){
            System.out.println(str);
        }
    }
    
    //do-while control flow
    public void doWhile(){
        do
            System.out.println("爱美，爱智慧");
        while(dice.nextInt(100)<99);
    }
    
    //exercise 1: print 1-100
    public static void oneToHundred(){
        for(int i=1;i<101;i++){
            System.out.println(i);
        }
    }
    
    //exercise 2: classifier 25 int
    public int[] intClassifier(int times){
        //result container
        int[] resultPool={0,0,0};
        for(int i=0;i<times;i++){
            int first=this.dice.nextInt(100);
            int second=this.dice.nextInt(100);
            if(first<second){
                resultPool[0]+=1;
            } else if(first==second){
                resultPool[1]+=1;
            } else {
                resultPool[2]+=1;
            }
        }
        return resultPool;
    }
    
    //exercise 3: infinite while loop classifier stop when we tape ctrl+c
    public void autoClassifier(){
        //result container
        int[] resultPool={0,0,0};
        while(true){
            int first=this.dice.nextInt(100);
            int second=this.dice.nextInt(100);
            if(first<second){
                resultPool[0]+=1;
            } else if(first==second){
                resultPool[1]+=1;
            } else {
                resultPool[2]+=1;
            }
            System.out.println(Arrays.toString(resultPool));
        }
    }
    
    //exercise 4: prime detector that return all prime number from 1 to the given max number.
    public static List<String> primeFilter(int max){
        List<String> resultPool=new ArrayList<String>(); //面向接口声明更好
        
        //test every number from 1 to max
        for(int currNum=1;currNum<max+1;currNum++){
            //currNum is treated as prime number by default
            boolean isPrime=true;
            int testNum=2;
            for(testNum=2;testNum<currNum;testNum++){
                //currNum is not prime number
                if(currNum%testNum==0){
                    isPrime=false;
                    break;
                }
            }
            if (isPrime){
                System.out.println("Found "+currNum+" is prime!!!");
                resultPool.add(Integer.toString(currNum));
            } else {
                System.out.println(currNum+" pass!!!");
            }
        }
        return resultPool;
    }
    
    //Exercise 5：same to exercise 10 in chapter 3
    public static void bitwise(){
        //original number
        final int NUM1 = 0xaa;
        final int NUM2 = 0x155;
        //print original number
        //System.out.println(Integer.toBinaryString(NUM1));
        //System.out.println(Integer.toBinaryString(NUM2));
        //bitwise operate
        int bitwiseAnd = NUM1 & NUM2;   //与：某一位上，都是1，才输出1。
        int bitwiseOr = NUM1 | NUM2;    //或：某一位上，只要有1，就输出1。
        int bitwiseXor = NUM1 ^ NUM2;   //异或：两个里，一个0，一个1，才输出1。
        int bitwiseNot = ~NUM1;   //非：每一位取反，1变0，0变1。
        //print bitwise result
        System.out.println(Integer.toBinaryString(bitwiseAnd));
        System.out.println(Integer.toBinaryString(bitwiseOr));
        System.out.println(Integer.toBinaryString(bitwiseXor));
        System.out.println(Integer.toBinaryString(bitwiseNot));

        //print by my method
        ControlFlow.printBinaryInt(bitwiseAnd);
        ControlFlow.printBinaryInt(bitwiseOr);
        ControlFlow.printBinaryInt(bitwiseXor);
        ControlFlow.printBinaryInt(bitwiseNot);
    }
    
    //method that print binary string of int, Similar to Integer.toBinaryString()
    public static void printBinaryInt(int inNum){
        //bitwise mask
        int mask=1;
        
        //result container
        int[] myInt = new int[32];
        
        // 1. do "AND" operate
        // 2. compare the result with the mask, to detect the value of each bit
        // 3. left-shift the mask
        for(int i=31;i>=0;i--){
            int bitwiseResult = inNum & mask;
            myInt[i]= bitwiseResult == 0 ? 0 : 1;
            mask <<= 1;
        }
        
        //if is positive: dont print the highest bit.
        //if is negative: print all 32 bit.
        if (myInt[0]==0) {
            //seek to first 1, and print the reste
            int firstNoZero=0;
            while(firstNoZero<=31 && myInt[firstNoZero]==0){
                firstNoZero++;
            }
            if (firstNoZero!=32){
                for(int i=firstNoZero;i<=31;i++){
                    System.out.print(myInt[i]);
                }
            } else {
                System.out.print("0"); //the number is 0
            }
        } else {
            for(int i=0;i<=31;i++){
                System.out.print(myInt[i]);
            }
        }
        System.out.println("");
    }
    
    //exercise 7: print number，using break, and return
    public static void oneToHundredBreak(int breakPoint){
        int i=0;
        lable1:
        //lable和循环语句中间，不能插东西！！！
        while(true){
            if (i > breakPoint){
                break lable1;
                //return;
            }
            System.out.println(i);
            i++;
        }
        System.out.println("Out of the loop!!");
    }
    
    //exercise 8: switch statement
    public static void switchPoetry(int whichNumber){
        for (int i=0;i<whichNumber+1;i++){
            switch(i) {
                case 1: System.out.println("一别之后"); break;
                case 2: System.out.println("两地相悬"); break;
                case 3: System.out.print("只说是三"); break;
                case 4: System.out.println("四月"); break;
                case 5: System.out.print("又谁知五"); break;
                case 6: System.out.println("六年"); break;
                case 7: System.out.println("七弦琴无心弹"); break;
                case 8: System.out.println("八行书无可传"); break;
                case 9: System.out.println("九连环从中折断"); break;
                case 10: System.out.println("十里长亭望眼欲穿"); break;
                case 100: System.out.println("百相思"); break;
                case 1000: System.out.println("千系念"); break;
                case 10000: System.out.println("万般无奈把君怨"); break;
            }
        }
        
    }
    
    /**
     *  Our class
     *  @param args void.
     */
    public static void main(String args[]){
        ControlFlow newTest = new ControlFlow(55);
        //newTest.doWhile();
        
        //exercise 1
        //ControlFlow.oneToHundred();
        
        //exercise 2
        //int[] ex2Result = newTest.intClassifier(25);
        //System.out.println(Arrays.toString(ex2Result));
        
        //exercise 3
        //newTest.autoClassifier();
        
        //exercise 4
        //List<String> testList = ControlFlow.primeFilter(20);
        //ControlFlow.printList(testList);
        
        //exercise 5
        //ControlFlow.bitwise();
        
        //exercise 7
        //ControlFlow.oneToHundredBreak(99);
        
        //exercise 8
        ControlFlow.switchPoetry(10000);
    }

}