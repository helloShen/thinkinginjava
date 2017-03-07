/**
 *  ConnectionManager manage the Connections.
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

package com.ciaoshen.thinkinjava.chapter6;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *  Only the ConnectionManager class is public visible.
 */
public class ConnectionManager {
    
    /*********************
     *  public methods
     *********************/
    //the only public Object available for users
    //the static interface of singleton pattern
    public static ConnectionManager singleton(){
        return theOnlyManager;
    }
    
    //reset the local IP
    public void setLocalIp(String nowIp){
        this.localIp=nowIp;
        System.out.println("Success! Now local IP is:   "+this.localIp);
    }
    
    //show everthing about the connection we have so far.
    //print the connection info line by line
    public void showConn(){
        //print the number of connection
        System.out.println("==============================");
        System.out.println("We have "+this.connNum+" connections now!   |");
        System.out.println("==============================");
        //print line by line
        for(Connection ele : this.connArray){
            System.out.println("||"+ele.toString()+"\t\t||");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    
        }
    }


    //create a new connection and insert it into the table
    //check if the connection already exist before create it
    public void addConn(String clientIp){
        if(this.hasConn(this.localIp, clientIp)==-1){
            this.connArray.add(new Connection(this.idCounter, this.localIp, clientIp));
            System.out.println("Connection created!");
        } else {
            System.out.println("This connection already exist. Give me another IP please!");
            System.out.println(this.connArray.get(this.hasConn(this.localIp, clientIp)).toString());
        }
        this.connNum=this.connArray.size();
        this.idCounter ++;
    }

    //kill a connection if it exists
    public void killConn(int connId){
        if(this.hasId(connId)!=-1){
            System.out.println("This connection has been killed!");
            System.out.println(this.connArray.get(this.hasId(connId)).toString());
            
            this.connArray.remove(this.hasId(connId));
        } else {
            System.out.println("We cannot find this ID: "+connId+". Please try another one!");
        }
        this.connNum=this.connArray.size();
    }

    /**************************************
     *  private fields and constructor
     **************************************/
    
    //table of Connections
    private int idCounter=1;
    private String localIp="127.0.0.1";  //default
    private List<Connection> connArray=new ArrayList<Connection>();
    //the number of connections
    private int connNum=0;
    
    //the only static connectionManager object
    private static ConnectionManager theOnlyManager=new ConnectionManager();
    
    //static block: initialization
    static{ }
    
    //private constructor: useless for creating static member
    private ConnectionManager(){}
    
    
    /*********************
     *  private methods
     *********************/
    
    //check if this connection id already exist
    //return the index if find the id, otherwise return -1
    private int hasId(int theId){
        int contains = -1;
        for(Connection ele : this.connArray){
            if (ele.id==theId){
                contains = connArray.indexOf(ele);
                break;
            }
        }
        return contains;
    }

    //check if a certain connetion is already exist
    //return the index if find the connection, otherwise return -1
    private int hasConn(String localIp, String directIp){
        int contains = -1;
        for(Connection ele : this.connArray){
            if (ele.myIp==localIp && ele.directIp==directIp){
                contains = connArray.indexOf(ele);
            }
        }
        return contains;
    }

    /**
     *  main test method: for the tests
     *  @param args void
     */
    public static void main(String[] args){
        
        //create connection
        ConnectionManager.singleton().addConn("234.52.234.34");
        ConnectionManager.singleton().addConn("234.52.234.34");
        ConnectionManager.singleton().addConn("34.342.54.345");
        ConnectionManager.singleton().addConn("86.3.34.423.4");
        ConnectionManager.singleton().addConn("37.356.7.4");
        
        //reset current local IP
        ConnectionManager.singleton().setLocalIp("192.168.2.1");
        
        //create some connections again
        ConnectionManager.singleton().addConn("37.565.25.2");
        ConnectionManager.singleton().addConn("678.4.13.889");
        ConnectionManager.singleton().addConn("565.785.243.676");
        ConnectionManager.singleton().addConn("797.224.666.234");
        ConnectionManager.singleton().addConn("45.23.4.85");
        
        //kill connection
        ConnectionManager.singleton().killConn(34);
        ConnectionManager.singleton().killConn(3);
        ConnectionManager.singleton().killConn(8);
        
        //show all connection
        ConnectionManager.singleton().showConn();
    }
}


/**
 *  The Connection class is only accessable in this package.
 */
class Connection {
    /**
     *  important fields of a connection
     */
    int id;
    String myIp;
    String directIp;
    Date birthday;
    
    //simple constructor. Private, no one can create the connection except me!
    Connection(int connId, String localIp, String clientIp){
        this.id=connId;
        this.myIp=localIp;
        this.directIp=clientIp;
        this.birthday=new Date();
    }
    
    //Full constructor. Private, no one can create the connection except me!
    Connection(int connId, String localIp, String clientIp, Date timeNow){
        this.id=connId;
        this.myIp=localIp;
        this.directIp=clientIp;
        this.birthday=timeNow;
    }
    
    //the toString() method in Object class is public, it cannot be protected or friendly here.
    //prepare the info stream for the printer
    public String toString(){
        //to get the template of the date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String result="  ID: "+this.id+"  \t| Local IP: "+this.myIp+"\t\t| Direct IP: "+this.directIp+"  \t| Etablished At: "+dateFormat.format(this.birthday);
        return result;
    }
    
    /**
     *  main test method: nothing in it.
     *  @param args void
     */
    public static void main(String[] args){
        
    }
}