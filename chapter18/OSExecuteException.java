/**
 *  定义一个专用异常
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;

@SuppressWarnings("serial")
public class OSExecuteException extends RuntimeException{
    public OSExecuteException(String why){super(why);}
}

