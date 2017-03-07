/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  MusicPlayer play mp3 and aac files
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class MusicPlayers implements MusicPlayer {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static MusicPlayers createMusicPlayers(){
        return new MusicPlayers();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void play(File inFile){
        if(inFile.getType()=="mp3"){
            playMp3(inFile);
        } else if(inFile.getType()=="aac"){
            playAac(inFile);
        }
    }
    public void playMp3(File inFile){
        System.out.println(inFile.getInfo());
    }
    public void playAac(File inFile){
        System.out.println(inFile.getInfo());
    }
    
    /**
     *  PACKAGE ACCESS CONSTRUCTOR
     */
    MusicPlayers(){}
    
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