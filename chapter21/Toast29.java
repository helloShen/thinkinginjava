/**
 *  Exercise 29
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;

public class Toast29{
    public static enum Status29{DRY, PBD, JMD, FINISH}
    private static int count=0;
    private int id;
    private Status29 status=Status29.DRY;
    public Toast29(){id=++count;}
    public synchronized void peanutButter(){
        switch(status){
            case DRY:
                status=Status29.PBD; break;
            case PBD:
                System.out.println("ERROR: "+this+" alread PeanutButtered!!!");break;
            case JMD:
                status=Status29.FINISH;break;
            case FINISH:
                System.out.println("ERROR: "+this+" alread finished!!!");break;
        }
    }
    public synchronized void jamme(){
        switch(status){
            case DRY:
                status=Status29.JMD; break;
            case JMD:
                System.out.println("ERROR: "+this+" alread Jammed!!!");break;
            case PBD:
                status=Status29.FINISH;break;
            case FINISH:
                System.out.println("ERROR: "+this+" alread finished!!!");break;
        }
    }
    public Status29 getStatus(){return status;}
    public void setStatus(Status29 s){status=s;}
    public String toString(){return "Toast#"+id+": "+status;}
}