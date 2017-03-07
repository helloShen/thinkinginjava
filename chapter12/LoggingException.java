/**
 *  chapter 12
 */

package com.ciaoshen.thinkinjava.chapter12;
import java.util.*;
import java.util.logging.*;
import java.io.*;


class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger ("LoggingException");
    
    public LoggingException (){
        StringWriter log=new StringWriter();
        printStackTrace(new PrintWriter(log));
        //logger.severe(log.toString());
    }

}