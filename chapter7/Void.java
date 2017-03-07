
public class Beetle extends Insect {
    
    //public constructor
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }
    
    //private fields
    private static int x2 = printInit("static Beetle.x2 initialized");
    private int k = printInit("Beetle.k initialized");
    
    
    /**
     *  MAIN
     */
    public static void main(String[] args) {
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
}




class Insect {
    //constructor
    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39; }
    
    //private fields
    static int printInit(String s) {
        2 The constructor is also a static method even though the static keyword is not explicit. So to be precise, a class is first loaded when any one of its static members is accessed.
        Reusing Classes 189
        print(s);
        return 47; }
    protected int j;
    private int i = 9;
    private static int x1 = printInit("static Insect.x1 initialized");
    
}




"static Insect.x1 initialized"
"static Beetle.x2 initialized"
"Beetle constructor"
"i=9, j=0"
"k=Beetle.k initialized"
"j=39"