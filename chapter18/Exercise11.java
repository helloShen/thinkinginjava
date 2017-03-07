/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

public class Exercise11{
    public static void main(String[] args){
        GreenhouseControls c=new GreenhouseControls();
        Controller controller=c.getController();
        controller.addEvent((Event)(ControllerHelper.smallEventFactories.get("Bell").create(900)));
        Event[] eventList = ControllerHelper.loadEvents("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter18/Event.txt");
        controller.addEvent((Event)(ControllerHelper.bigEventFactories.get("Restart").create(2000,eventList)));
        controller.addEvent((Event)(ControllerHelper.smallEventFactories.get("Terminate").create(1000)));
        controller.run();
    }
}