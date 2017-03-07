/**
 *  Vampire number
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter4;

import java.util.*;

/**
 *  our class
 */
public class Vampire{
    /**
     *  fields and methods
     */
    
    
    //default constructor
    public Vampire(){ }


    //only look for 4-digits vampire numbers
    //丑陋暴力解法
    public static List<Integer> getFourDigitsVampire(){
        //the result container
        List<Integer> resultList = new ArrayList<Integer>();
        //for all 4-digits numbers
        for(int currNum=1000;currNum<10000;currNum++){
            //Pairs of trailing zeroes are not allowed.
            if(currNum%100 != 0){
                //permutations of ab*cd： P（4，2）*2
                //2 nested loop
                for(int digit1=0;digit1<4;digit1++){
                    for(int digit2=0;digit2<4;digit2++){
                        if(digit2!=digit1){
                            //call split(inNum,digit1,digit2)
                            // abcd(1,3) --> {ac,bd,db}
                            // abcd(2,4) --> {bd,ac,ca}
                            List<Integer> halfHalf = split(currNum,digit1,digit2);
                        
                            //check the product
                            if(halfHalf.get(0)*halfHalf.get(1)==currNum){
                                if(!resultList.contains(currNum)){
                                    resultList.add(currNum);
                                }
                                System.out.println(currNum+" = "+halfHalf.get(0)+" * "+halfHalf.get(1));
                            }
                        }
                    }
                }
            }
        }
        //return
        return resultList;
    }
    
    //another method to get the 4 digits vampire number
    public static List<Integer> getFourDigitsVampireV2(){
        //result container
        List<Integer> vampireList = new ArrayList<Integer>();
        //nested loop: check each ab and cd
        for(int part1=10;part1<100L;part1++){
            for(int part2=part1;part2<100L;part2++){
                int product = part1*part2;
                if (!(product<1000 || product >= 10000 || product%100==0)){   //only need 4 digits number and those end with 00
                    //split to list of int 1234 -->{4,3,2,1}
                    List<Integer> origList = toInvertDigits(part1*100+part2);
                    List<Integer> productList = toInvertDigits(product);
                    //sort
                    Collections.sort(origList);
                    Collections.sort(productList);
                    //compaire the sorted list
                    if (origList.equals(productList)){
                        System.out.println("found "+part1+" * "+part2+" = "+product);
                        vampireList.add(product);
                    }
                }
            }
        }
        return vampireList;
    }
 

    // abcd(1,3) --> {ac,bd,db}
    // abcd(2,4) --> {bd,ac,ca}
    public static List<Integer> split (int inNum, int digit1, int digit2) {
        //result container
        List<Integer> resultList = new ArrayList<Integer>();
        
        //convert to digits
        List<Integer> fourDigits=toDigits(inNum);
        
        //get the rest number of digit1, digit2
        List<Integer> restDigit = new ArrayList<Integer>();
        for(int digit=0;digit<4;digit++){
            if(digit!=digit1 && digit!=digit2){
                restDigit.add(digit);
            }
        }
        int rest1=restDigit.get(0);
        int rest2=restDigit.get(1);
        
        //get {ac,bd,db}
        int part1=fourDigits.get(digit1)*10+fourDigits.get(digit2);
        int part2=fourDigits.get(rest1)*10+fourDigits.get(rest2);
        //int part3=fourDigits.get(rest2)*10+fourDigits.get(rest1);
        
        //insert into result container
        resultList.add(part1);
        resultList.add(part2);
        //resultList.add(part3);
        
        //return
        return resultList;
    }
    
    
    //input:1234 --> output:{1,2,3,4}
    public static List<Integer> toDigits(int inNum){
        //get 4 digital number
        List<Integer> fourNum = new ArrayList<Integer>();
        fourNum.add(0,(inNum%10000-inNum%1000)/1000);
        fourNum.add(1,(inNum%1000-inNum%100)/100);
        fourNum.add(2,(inNum%100-inNum%10)/10);
        fourNum.add(3,inNum%10);
        
        //return
        return fourNum;
    }
    
    //input:1234 --> output: {4,3,2,1}
    public static List<Integer> toInvertDigits(int inNum){
        List<Integer> resultList = new ArrayList<Integer>();
        while(inNum>0){
            resultList.add(inNum%10);
            inNum/=10;
        }
        return resultList;
    }
    
    //to print the arraylist of integer
    public static void printList(List<Integer> inList){
        for (int ele : inList){
            System.out.println(ele);
        }
    }
    
    /**
     *  main method
     *  @param args void
     */
    public static void main(String args[]){
        /*
        //test split method
        int myNum = 2016;
        List<Integer> threeNumber = Vampire.split(myNum,1,3);
        Vampire.printList(threeNumber);
        */
        
        //test getVampire
        //List<Integer> vampireResult = Vampire.getFourDigitsVampire();
        List<Integer> vampireResult = Vampire.getFourDigitsVampireV2();
        System.out.println("Voila, here is our 4-digits vampire numbers: ");
        Vampire.printList(vampireResult);
        
    }
}