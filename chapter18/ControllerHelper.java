/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ControllerHelper {
    @SuppressWarnings("rawtypes")
    private static Map<String,SmallEventFactory<? extends Event>> smallEventFactories=new HashMap<String,SmallEventFactory<? extends Event>>();
    @SuppressWarnings("rawtypes")
    private static Map<String,BigEventFactory<? extends Event>> bigEventFactories=new HashMap<String,BigEventFactory<? extends Event>>();
    static {
        smallEventFactories.put("LightOn",new GreenhouseControls.LightOn.Factory());
        smallEventFactories.put("LightOff",new GreenhouseControls.LightOff.Factory());
        smallEventFactories.put("WaterOn",new GreenhouseControls.WaterOn.Factory());
        smallEventFactories.put("WaterOff",new GreenhouseControls.WaterOff.Factory());
        smallEventFactories.put("ThermostatNight",new GreenhouseControls.ThermostatNight.Factory());
        smallEventFactories.put("ThermostatDay",new GreenhouseControls.ThermostatDay.Factory());
        smallEventFactories.put("Bell",new GreenhouseControls.Bell.Factory());
        bigEventFactories.put("Restart",new GreenhouseControls.Restart.Factory());
        smallEventFactories.put("Terminate",new GreenhouseControls.Terminate.Factory());
    }
    
    public static Event[] loadEvents(String path){
        File file=new File(path);
        List<Event> list=new ArrayList<Event>();
        BufferedReader bf=null;
        try{
            bf=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=bf.readLine())!=null){
                String[] param=line.split("\\t");
                if(param.length!=2){
                    System.out.println("Args Error:  "+line);
                }else{
                    System.out.println(param[0]+","+param[1]);
                    list.add(smallEventFactories.get(param[0]).create(Integer.parseInt(param[1])));
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(file.getName()+" not found!");
        }catch(IOException ioe){
            System.out.println("have problem when reading lines... ...");
        }finally{
            if(bf!=null){
                try{
                    bf.close();
                }catch(IOException ioe){
                    System.out.println("File can not be close!");
                }
            }
        }
        System.out.println(list);
        return list.toArray(new Event[list.size()]);
    }

}