/**
 *  To test the final parameter problem of inner class
 */

package com.ciaoshen.thinkinjava.chapter10;
import java.util.*;


class TestInnerFinalProblem {

    public Window getWindow(int paramNum, int[] boxingNum){
        return new Window(){
            int copieNumber=number;
            @Override
            public void haveALook(){
                System.out.println("From window: "+number+" param: "+paramNum+"    copieNumber: "+copieNumber);
                boxingNum[0]=0;
                System.out.println("I want to touch the content from the window: "+number+" param: "+paramNum+"    copieNumber: "+copieNumber+"    boxingNum: "+boxingNum[0]);
            }
        };
    }
    
    private class Inner {
        public void checkNumber(){
            System.out.println("From inner class: "+number+" (direct)");
            System.out.println("From inner class: "+TestInnerFinalProblem.this.number+" (by pointer)");
        }
    }
    
    public void changeMyNumber(int newNumber){
        number=newNumber;
    }
    
    private int number=100;
    
    public static void main(String[] args){
        TestInnerFinalProblem tester=new TestInnerFinalProblem();
        
        //Inner先查看
        Inner oldInner=tester.new Inner();
        System.out.println(">>> Old Inner");
        oldInner.checkNumber();
        
        //匿名类再查看
        System.out.println(">>> Old Anonymous");
        int[] boxingNum={1000};
        Window oldWindow=tester.getWindow(tester.number,boxingNum);
        oldWindow.haveALook();
        
        //changeMyNumber再修改
        tester.changeMyNumber(200);
        
        //Inner再查看
        System.out.println(">>> Old Inner again");
        oldInner.checkNumber();
        
        //匿名类再查看
        System.out.println(">>> Old Anonymous again");
        oldWindow.haveALook();
        
        //再建新Inner查看
        Inner newInner=tester.new Inner();
        System.out.println(">>> New Inner");
        newInner.checkNumber();
        
        //再建新匿名类查看
        System.out.println(">>> New Anonymous");
        boxingNum[0]=2000;
        Window newWindow=tester.getWindow(tester.number,boxingNum);
        newWindow.haveALook();
        
    }
    
    
}