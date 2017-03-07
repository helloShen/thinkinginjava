/**
 *  证明会自动调动构造器
 *  @author wei.shen
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter7;

import java.util.*;


//main class
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
    public static void main(String[] args) {
        Chess x = new Chess();
    }
}

//only visible in package
class BoardGame extends Game {
    BoardGame(int i) {
        //super(i);
        System.out.println("BoardGame constructor");
    }
}

//only visible in package
class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}