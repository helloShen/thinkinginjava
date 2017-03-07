/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  Video Player play mp3 and aac files
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class VideoPlayers implements VideoPlayer {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static VideoPlayers createVideoPlayers(){
        return new VideoPlayers();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void play(File inFile){
        if(inFile.getType()=="avi"){
            playAvi(inFile);
        } else if(inFile.getType()=="mp4"){
            playMp4(inFile);
        }
    }
    public void playMp4(File inFile){
        System.out.println(inFile.getInfo());
    }
    public void playAvi(File inFile){
        System.out.println(inFile.getInfo());
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private VideoPlayers(){}
    
    /**
     *  PRIVATE FIELDS
     */
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        
    }
    
}