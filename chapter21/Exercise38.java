/**
 *  Exercise 38 house building with concurrent
 */
package com.ciaoshen.thinkinjava.chapter21;
import java.util.concurrent.*;
import java.util.*;
import java.io.*;
public class Exercise38{

    /**
     *  House
     */
    public class House{
        private String owner;
        private Draw draw;
        private boolean designed=false, base=false, structure=false, pipeline=false, wall=false, decoration=false;
        public House(String name){
            owner=name;
        }
        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append("["+owner);
            if(designed){sb.append(" Designed!");}
            if(base){sb.append(" Based!");}
            if(structure){sb.append(" Structured!");}
            if(pipeline){sb.append(" Pipelined!");}
            if(wall){sb.append(" Walled!");}
            if(decoration){sb.append(" Decorated!");}
            return sb.append("]").toString();
        }
        //all atomic
        public synchronized void bindingDraw(Draw d){
            draw=d;
            designed=true;
        }
        public synchronized void addBase(){base=true;}
        public synchronized void addStructure(){structure=true;}
        public synchronized void addPipeline(){pipeline=true;}
        public synchronized void addWall(){wall=true;}
        public synchronized void addDecoration(){decoration=true;}
        public synchronized boolean getBase(){return base;}
        public synchronized boolean getStructure(){return structure;}
        public synchronized boolean getPipeline(){return pipeline;}
        public synchronized boolean getWall(){return wall;}
        public synchronized boolean getDecoration(){return decoration;}
    }
    public class Market implements Runnable{
        private HouseQueue orders;
        public Market(HouseQueue q){orders=q;}
        public void run(){
            try{
               for(int i=0;i<10;i++){
                    House house=new House(getName(10));
                    System.out.println("New house Order: "+house);
                    orders.put(house);
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }catch(InterruptedException ie){
                System.out.println("Test interrupted!");
            }
            System.out.println("Test exit!");
        }
    }
    /**
     *  Two main queues
     */
    public class HouseQueue extends LinkedBlockingQueue<House>{
        private static final long serialVersionUID=0;
    }
    /**
     *  Designer
     */
    public class Draw{
        private House house;
        private Designer designer;
        public Draw(House h,Designer d){house=h;designer=d;}
        public String toString(){return house+" designed by "+designer;}
        public Designer getDesigner(){return designer;}
        public House getHouse(){return house;}
    }
    public class Designer implements Runnable{
        private String name;
        private HouseQueue orders;
        private HouseQueue creations;
        public Designer(String n,HouseQueue o,HouseQueue c){name=n;orders=o;creations=c;}
        public String toString(){return "Designer "+name;}
        public String getName(){return name;}
        public synchronized void draw(House h) throws InterruptedException{
            TimeUnit.MILLISECONDS.sleep(100);
            h.bindingDraw(new Draw(h,this));
        }
        public void run(){
            try{
                while(!Thread.interrupted()){
                    House h=orders.take();  //block
                    System.out.println(this+" get new order: "+h);
                    draw(h);
                    System.out.println(h+" designed by "+this);
                    creations.put(h);   //block
                }
            }catch(InterruptedException ie){
                System.out.println("Designer interrupted!");
            }
            System.out.println("Designer exit!");
        }
    }

    /**
     *  Manager
     */
    public class Manager implements Runnable{
        private String name;
        private HouseQueue creations;
        private HouseQueue finished;
        private List<Class<? extends Contractor>> plan;
        private House project;
        private ContractorPool humanResource;

        public Manager(String n,HouseQueue c,HouseQueue f,List<Class<? extends Contractor>> p,ContractorPool h){
            name=n;
            creations=c;
            finished=f;
            plan=p;
            humanResource=h;
        }
        public String toString(){return "Manager "+name;}
        public House getProject(){return project;}
        public synchronized void bindingProject(House house){project=house;}
        public synchronized void finishProject() throws InterruptedException{
            finished.put(project);  //never block
            project=null;
        }
        public synchronized void vacation() throws InterruptedException{
            TimeUnit.MILLISECONDS.sleep(10);
        }
        public void run(){  //thread
            try{
                while(!Thread.interrupted()){
                    House house=creations.take();   //block
                    System.out.println(this+" take the project of "+house);
                    bindingProject(house);
                    for(Class<? extends Contractor> task:plan){
                        humanResource.hire(task,this);
                    }
                    finishProject();
                    vacation();
                }
            }catch(InterruptedException ie){
                System.out.println("Manager interrupted!");
            }
            System.out.println("Manager exit!");
        }
    }

    /**
     *  Contractor
     */
     public abstract class Contractor implements Runnable{
         private String name;
         private Manager manager;
         private boolean ready=false;
         protected ContractorPool pool;
         public Contractor(String n, ContractorPool p){name=n;pool=p;}
         public synchronized void bindingManager(Manager m){
             pool.remove(this);
             manager=m;
         }
         public synchronized void decouplingManager(){
             pool.add(this);
             manager=null;
         }
         public synchronized Manager getManager(){return manager;}
         public synchronized String getName(){return name;}
         public boolean isReady(){return ready;}
         public synchronized void ready() throws InterruptedException{
             decouplingManager();
             ready=true;
             synchronized(pool){
                 notifyAll();
             }
             System.out.println(this+" is ready!");
             wait();
         }
         public abstract void work() throws InterruptedException;
         public void run(){
             try{
                 while(!Thread.interrupted()){
                     ready();   //block
                     work();
                 }
             }catch(InterruptedException ie){
                 System.out.println(this+" Interrupted!");
             }
             System.out.println(this+" exit!");
         }
     }
     public class BaseContractor extends Contractor{
         public BaseContractor(String n,ContractorPool p){super(n,p);}
         public String toString(){return "Base contractor "+getName();}
         public synchronized void work() throws InterruptedException{
             Manager manager=getManager();
             manager.getProject().addBase();
             System.out.println(manager.getProject()+" Base well constructed by "+this);
             notifyAll();
         }
     }
     public class StructureContractor extends Contractor{
         public StructureContractor(String n,ContractorPool p){super(n,p);}
         public String toString(){return "Structure contractor "+getName();}
         public synchronized void work() throws InterruptedException{
             Manager manager=getManager();
             manager.getProject().addStructure();
             System.out.println(manager.getProject()+" Structure well constructed by "+this);
             notifyAll();
         }
     }
     public class PipelineContractor extends Contractor{
         public PipelineContractor(String n,ContractorPool p){super(n,p);}
         public String toString(){return "Pipeline contractor "+getName();}
         public synchronized void work() throws InterruptedException{
             Manager manager=getManager();
             manager.getProject().addPipeline();
             System.out.println(manager.getProject()+" Pipeline well constructed by "+this);
             notifyAll();
         }
     }
     public class WallContractor extends Contractor{
         public WallContractor(String n,ContractorPool p){super(n,p);}
         public String toString(){return "Wall contractor "+getName();}
         public synchronized void work() throws InterruptedException{
             Manager manager=getManager();
             manager.getProject().addWall();
             System.out.println(manager.getProject()+" Wall well constructed by "+this);
             notifyAll();
         }
     }
     public class DecorationContractor extends Contractor{
         public DecorationContractor(String n,ContractorPool p){super(n,p);}
         public String toString(){return "Decoration contractor "+getName();}
         public synchronized void work() throws InterruptedException{
             Manager manager=getManager();
             manager.getProject().addDecoration();
             System.out.println(manager.getProject()+" Decoration well constructed by "+this);
             notifyAll();   //tell manager this work is done
         }
     }
     public class ContractorPool{
         private List<Contractor> pool=new ArrayList<Contractor>();
         public List<Contractor> getContractors(){return pool;}
         public synchronized void add(Contractor c){pool.add(c);notifyAll();}
         public synchronized void remove(Contractor c){pool.remove(c);}
         public void hire(Class<? extends Contractor> task, Manager manager) throws InterruptedException{
             for(Contractor contractor:pool){
                 if(contractor.getClass().equals(task)){
                     synchronized(contractor){
                         contractor.bindingManager(manager);
                         System.out.println(manager+" hire "+contractor);
                         contractor.notifyAll();    //call contractor to work
                         contractor.wait(); //block, wait contractor to finish the work
                         System.out.println("Bye bye "+contractor);
                         return;
                     }
                 }
                 wait();
                 hire(task,manager);
             }
         }
     }

    /**
     *  Acceptance
     */
    public class Acceptance implements Runnable{
        private String name;
        private HouseQueue finished;
        public Acceptance(String n,HouseQueue h){name=n;finished=h;}
        public String toString(){return "Acceptance "+name;}
        public String getName(){return name;}
        public void run(){
            try{
                 while(!Thread.interrupted()){
                    House house=finished.take();    //block
                    System.out.println(house+" finished!");
                 }
             }catch(InterruptedException ie){
                 System.out.println(this+" Interrupted!");
             }
             System.out.println(this+" exit!");
        }
    }


    public String getName(int length){
        Random rand=new Random();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<length;i++){
            str.append((char)(((int)'a')+rand.nextInt(26)));
        }
        return str.toString();
    }
    public static void main(String[] args){
        System.out.println("Press Entry to exit!");
        Exercise38 ex=new Exercise38();
        ExecutorService exec=Executors.newCachedThreadPool();
        HouseQueue orders=ex.new HouseQueue();
        HouseQueue creations=ex.new HouseQueue();
        HouseQueue finished=ex.new HouseQueue();
        List<Class<? extends Contractor>> plan=new ArrayList<Class<? extends Contractor>>();
        plan.add(BaseContractor.class);
        plan.add(StructureContractor.class);
        plan.add(PipelineContractor.class);
        plan.add(WallContractor.class);
        plan.add(DecorationContractor.class);
        ContractorPool humanResource=ex.new ContractorPool();
        exec.execute(ex.new BaseContractor(ex.getName(1),humanResource));
        exec.execute(ex.new StructureContractor(ex.getName(1),humanResource));
        exec.execute(ex.new PipelineContractor(ex.getName(1),humanResource));
        exec.execute(ex.new WallContractor(ex.getName(1),humanResource));
        exec.execute(ex.new DecorationContractor(ex.getName(1),humanResource));

        exec.execute(ex.new Market(orders));    //market thread
        for(int i=0;i<5;i++) {  //designer thread
            Designer d=ex.new Designer(ex.getName(7),orders,creations);
            exec.execute(d);
        }
        for(int i=0;i<3;i++){   //manager thread
            Manager manager=ex.new Manager(ex.getName(5),creations,finished,plan,humanResource);
            exec.execute(manager);
        }
        exec.execute(ex.new Acceptance(ex.getName(5),finished));
        try{
           System.in.read();
        }catch(IOException ioe){
           System.out.println("Test interrupted!");
        }
        System.out.println("Test exit!");
        exec.shutdownNow();
    }
}
