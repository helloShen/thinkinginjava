/**
 * Exercise 13
 */
package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

public class Exercise13 {
    public static class Controller {
        private List<Event> eventList = new ArrayList<Event>();
        public void addEvent(Event c) { eventList.add(c); }
        public void run() {
            while(eventList.size() > 0) {
                // Make a copy so you’re not modifying the list
                // while you’re selecting the elements in it:
                for(Event e : new ArrayList<Event>(eventList)) {
                    if(e.ready()) {
                        System.out.println(e);
                        e.action();
                        eventList.remove(e);
                    }
                }
            }
        }
    }
    public static abstract class Event {
        private long eventTime;
        protected final long delayTime;
        public Event(long delayTime) {
            this.delayTime = delayTime;
            start();
        }
        public void start() { // Allows restarting
            eventTime = System.nanoTime() + delayTime;
        }
        public boolean ready() {
            return System.nanoTime() >= eventTime;
        }
        public abstract void action();
    }
    public static class GreenhouseControls extends Controller {
        private boolean light = false;
        public class LightOn extends Event {
            public LightOn(long delayTime) { super(delayTime); }
            public void action() {
                // Put hardware control code here to
                // physically turn on the light.
                light = true;
            }
            public String toString() { return "Light is on"; }
        }
        public class LightOff extends Event {
            public LightOff(long delayTime) { super(delayTime); }
            public void action() {
                // Put hardware control code here to
                // physically turn off the light.
                light = false;
            }
            public String toString() { return "Light is off"; }
        }
        private boolean water = false;
        public class WaterOn extends Event {
            public WaterOn(long delayTime) { super(delayTime); }
            public void action() {
                // Put hardware control code here.
                water = true;
            }
            public String toString() {
                return "Greenhouse water is on";
            }
        }
        public class WaterOff extends Event {
            public WaterOff(long delayTime) { super(delayTime); }
            public void action() {
                // Put hardware control code here.
                water = false;
            }
            public String toString() {
                return "Greenhouse water is off";
            }
        }
        private String thermostat = "Day";
        public class ThermostatNight extends Event {
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
        public class ThermostatDay extends Event {
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
        public class Bell extends Event {
            public Bell(long delayTime) { super(delayTime); }
            public void action() {
                addEvent(new Bell(delayTime));
            }
            public String toString() { return "Bing!"; }
        }
        public class Restart extends Event {
            private List<Event> eventList;
            public Restart(long delayTime, List<Event> eventList) {
                super(delayTime);
                this.eventList = eventList;
                for(Event e : eventList)
                    addEvent(e);
                }
            public void action() {
                for(Event e : eventList) {
                    e.start(); // Rerun each event
                    addEvent(e);
                }
                start(); // Rerun this Event
                addEvent(this);
            }
            public String toString() {
                return "Restarting system";
            }
        }
        public static class Terminate extends Event {
            public Terminate(long delayTime) { super(delayTime); }
            public void action() { System.exit(0); }
            public String toString() { return "Terminating"; }
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        // Instead of hard-wiring, you could parse
        // configuration information from a text file here:
        gc.addEvent(gc.new Bell(900));
        List<Event> eventList = new LinkedList<Event>();
        eventList.add(gc.new ThermostatNight(0));
        eventList.add(gc.new LightOn(200));
        eventList.add(gc.new LightOff(400));
        eventList.add(gc.new WaterOn(600));
        eventList.add(gc.new WaterOff(800));
        eventList.add(gc.new ThermostatDay(1400));
        gc.addEvent(gc.new Restart(2000, eventList));
        int delayTime = 5000;
        gc.addEvent(new GreenhouseControls.Terminate(new Integer(delayTime)));
        gc.run();
    }
}
