/**
 * typeinfo/pets library
 */
package com.ciaoshen.thinkinjava.newchapter15;
import java.util.*;

public class TypeInfoSpeak {
    public static class Individual implements Comparable<Individual> {
        private static long counter = 0;
        private final long id = counter++;
        private String name;
        public Individual(String name) { this.name = name; }
        public Individual() {}
        public String toString() {
            return getClass().getSimpleName() + (name == null ? "" : " " + name);
        }
        public long id() { return id; }
        public boolean equals(Object o) {
            return o instanceof Individual && id == ((Individual)o).id;
        }
        public int hashCode() {
            int result = 17;
            if(name != null)
                result = 37 * result + name.hashCode();
                result = 37 * result + (int)id;
                return result;
            }
        public int compareTo(Individual arg) { // 1. type name, 2. name 3. id
            // Compare by class name first:
            String first = getClass().getSimpleName();
            String argFirst = arg.getClass().getSimpleName();
            int firstCompare = first.compareTo(argFirst);
            if(firstCompare != 0){
                return firstCompare;
            }
            if(name != null && arg.name != null) {
                int secondCompare = name.compareTo(arg.name);
                if(secondCompare != 0) {
                    return secondCompare;
                }
            }
            return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
        }
    }
    public static class Person extends Individual {
        public Person(String name) { super(name); }
    }
    public static class Pet extends Individual {
        public Pet(String name) { super(name); }
        public Pet() { super(); }
        public void speak() {
            System.out.println("...");
        }
    }
    public static class Dog extends Pet {
        public Dog(String name) { super(name); }
        public Dog() { super(); }
        public void speak() {
            System.out.println("WongWong");
        }
    }
    public static class Mutt extends Dog {
        public Mutt(String name) { super(name); }
        public Mutt() { super(); }
    }
    public static class Pug extends Dog {
        public Pug(String name) { super(name); }
        public Pug() { super(); }
    }
    public static class Cat extends Pet {
        public Cat(String name) { super(name); }
        public Cat() { super(); }
        public void speak() {
            System.out.println("MiewMiew");
        }
    }
    public static class EgyptianMau extends Cat {
        public EgyptianMau(String name) { super(name); }
        public EgyptianMau() { super(); }
    }
    public static class Manx extends Cat {
        public Manx(String name) { super(name); }
        public Manx() { super(); }
    }
    public static class Cymric extends Manx {
        public Cymric(String name) { super(name); }
        public Cymric() { super(); }
    }
    public static class Rodent extends Pet {
        public Rodent(String name) { super(name); }
        public Rodent() { super(); }
        public void speak() {
            System.out.println("ZzZz");
        }
    }
    public static class Rat extends Rodent {
        public Rat(String name) { super(name); }
        public Rat() { super(); }
    }
    public static class Mouse extends Rodent {
        public Mouse(String name) { super(name); }
        public Mouse() { super(); }
    }
    public static class Hamster extends Rodent {
        public Hamster(String name) { super(name); }
        public Hamster() { super(); }
    }
    public static abstract class PetCreator { // 静态工厂
        private Random rand = new Random();
        // The List of the different types of Pet to create:
        public abstract List<Class<? extends Pet>> types();
        public Pet randomPet() { // Create one random Pet
            int n = rand.nextInt(types().size());
            try {
                return types().get(n).newInstance();
            } catch(InstantiationException e) {
                throw new RuntimeException(e);
            } catch(IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        public Pet[] createArray(int size) {
            Pet[] result = new Pet[size];
            for(int i = 0; i < size; i++)
                result[i] = randomPet();
                return result;
            }
        public ArrayList<Pet> arrayList(int size) {
            ArrayList<Pet> result = new ArrayList<Pet>();
            Collections.addAll(result, createArray(size));
            return result;
        }
    }
    public static class ForNameCreator extends PetCreator {
        private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
        // Types that you want to be randomly created:
        private static String[] typeNames = {
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Mutt",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Pug",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$EgyptianMau",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Manx",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Cymric",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Rat",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Mouse",
            "com.ciaoshen.thinkinjava.newchapter15.TypeInfoSpeak$Hamster",
        };
        @SuppressWarnings("unchecked")
        private static void loader() {
            try {
                for(String name : typeNames) {
                    types.add((Class<? extends Pet>)Class.forName(name));
                }
            } catch(ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        static { loader(); }
        public List<Class<? extends Pet>> types() {return types;}
    }
    public static void main(String[] args) {
        ForNameCreator petsGen = new ForNameCreator();
        int size = 10;
        List<Pet> pets = petsGen.arrayList(size);
        System.out.println(pets);
        for (Pet p : pets) {
            p.speak();
        }
    }
}
