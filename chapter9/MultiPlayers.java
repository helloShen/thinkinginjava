/**
 *  Chapter 9 - Interface - Adapter Pattern
 *  MultiPlayer can play both music and video
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter9;
import java.util.*;

class MultiPlayers extends MusicPlayers {
    
    /**
     *  PUBLIC PROXY OF CONSTRUCTOR
     */
    public static MultiPlayers createMultiPlayers(){
        return new MultiPlayers();
    }
    
    /**
     *  PUBLIC METHODS
     */
    public void play(File inFile){
        if(inFile.getType()=="mp3"){
            playMp3(inFile);
        } else if(inFile.getType()=="aac"){
            playAac(inFile);
        } else if(inFile.getType()=="avi"){
            adapteePlayer.playAvi(inFile);
        } else if(inFile.getType()=="mp4"){
            adapteePlayer.playMp4(inFile);
        }
    }
    
    /**
     *  PRIVATE CONSTRUCTOR
     */
    private MultiPlayers(){}
    
    /**
     *  PRIVATE FIELDS
     */
    private VideoPlayer adapteePlayer =  VideoPlayers.createVideoPlayers();
    
    /**
     *  MAIN
     *  @param args void
     */
    public static void main(String[] args){
        File file1=Files.createFiles("Hey Jude","mp3");
        File file2=Files.createFiles("Yesterday","aac");
        File file3=Files.createFiles("Mickle Jackson concert","avi");
        File file4=Files.createFiles("Beatles concert","mp4");
        
        MultiPlayers myPlayer=MultiPlayers.createMultiPlayers();
        myPlayer.play(file1);
        myPlayer.play(file2);
        myPlayer.play(file3);
        myPlayer.play(file4);
    }
    
}