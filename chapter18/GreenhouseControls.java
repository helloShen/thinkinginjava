/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public class GreenhouseControls {
    private static Controller con=new Controller();
    
    public Controller getController(){return con;}
    private static boolean light = false;
    public static class LightOn extends Event {
        public static class Factory implements SmallEventFactory<LightOn>{
            public LightOn create(long delayTime){return new LightOn(delayTime);}
        }
        public LightOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }
        public String toString() { return "Light is on"; }
    }
    public static class LightOff extends Event {
        public static class Factory implements SmallEventFactory<LightOff>{
            public LightOff create(long delayTime){return new LightOff(delayTime);}
        }
        public LightOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }
        public String toString() { return "Light is off"; }
    }
    private static boolean water = false;
    public static class WaterOn extends Event {
        public static class Factory implements SmallEventFactory<WaterOn>{
            public WaterOn create(long delayTime){return new WaterOn(delayTime);}
        }
        public WaterOn(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here.
            water = true;
        }
        public String toString() {
            return "Greenhouse water is on";
        }
    }
    public static class WaterOff extends Event {
        public static class Factory implements SmallEventFactory<WaterOff>{
            public WaterOff create(long delayTime){return new WaterOff(delayTime);}
        }
        public WaterOff(long delayTime) { super(delayTime); }
        public void action() {
            // Put hardware control code here.
            water = false;
        }
        public String toString() {
            return "Greenhouse water is off";
        }
    }
    private static String thermostat = "Day";
    public static class ThermostatNight extends Event {
        public static class Factory implements SmallEventFactory<ThermostatNight>{
            public ThermostatNight create(long delayTime){return new ThermostatNight(delayTime);}
        }
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            thermostat = "Night";
        }
        public String toString() {
            return "Thermostat on night setting";
        }
    }
    public static class ThermostatDay extends Event {
        public static class Factory implements SmallEventFactory<ThermostatDay>{
            public ThermostatDay create(long delayTime){return new ThermostatDay(delayTime);}
        }
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
        public void action() {
            // Put hardware control code here.
            thermostat = "Day";
        }
        public String toString() {
            return "Thermostat on day setting";
        }
    }
    // An example of an action() that inserts a
    // new one of itself into the event list:
    public static class Bell extends Event {
        public static class Factory implements SmallEventFactory<Bell>{
            public Bell create(long delayTime){return new Bell(delayTime);}
        }
        public Bell(long delayTime) { super(delayTime); }
        public void action() {
            con.addEvent(new Bell(delayTime));
        }
        public String toString() { return "Bing!"; }
    }
    public static class Restart extends Event {
        public static class Factory implements BigEventFactory<Restart>{
            public Restart create(long delayTime, Event[] eventList){return new Restart(delayTime, eventList);}
        }
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for(Event e : eventList)
                con.addEvent(e);
        }
        public void action() {
            for(Event e : eventList) {
                e.start(); // Rerun each event
                con.addEvent(e);
            }
            start(); // Rerun this Event
            con.addEvent(this);
        }
        public String toString() {
            return "Restarting system";
        }
    }
    public static class Terminate extends Event {
        public static class Factory implements SmallEventFactory<Terminate>{
            public Terminate create(long delayTime){return new Terminate(delayTime);}
        }
        public Terminate(long delayTime) { super(delayTime); }
        public void action() { System.exit(0); }
        public String toString() { return "Terminating"; }
    }
}