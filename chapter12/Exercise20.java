/**
 * Exercise 20
 */
package com.ciaoshen.thinkinjava.chapter12;

public class Exercise20 {
    public static class EmpireArgument extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static class BaseballException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static class Foul extends BaseballException {
        private static final long serialVersionUID = 0;
    }
    public static class Strike extends BaseballException {
        private static final long serialVersionUID = 0;
    }
    public static abstract class Inning {
        public Inning() throws BaseballException {}
        public void event() throws BaseballException {
            // Doesn’t actually have to throw anything
        }
        public abstract void atBat() throws Strike, Foul;
        public void walk() {} // Throws no checked exceptions
    }
    public static class StormException extends Exception {
        private static final long serialVersionUID = 0;
    }
    public static class RainedOut extends StormException {
        private static final long serialVersionUID = 0;
    }
    public static class PopFoul extends Foul {
        private static final long serialVersionUID = 0;
    }
    public static interface Storm {
        public void event() throws RainedOut;
        public void rainHard() throws RainedOut;
    }
    public static class StormyInning extends Inning implements Storm {
        // OK to add new exceptions for constructors, but you
        // must deal with the base constructor exceptions:
        public StormyInning() throws RainedOut, BaseballException {}
        public StormyInning(String s) throws Foul, BaseballException {}
        // Regular methods must conform to base class:
        //! void walk() throws PopFoul {} //Compile error
        // Interface CANNOT add exceptions to existing
        // methods from the base class:
        //! public void event() throws RainedOut {}
        // If the method doesn’t already exist in the
        // base class, the exception is OK:
        public void rainHard() throws RainedOut {}
        // You can choose to not throw any exceptions,
        // even if the base version does:
        public void event() {}
        // Overridden methods can throw inherited exceptions:
        public void atBat() throws PopFoul {}
        public void throwEmpireArgument() throws EmpireArgument {}
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
            si.throwEmpireArgument();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        } catch(EmpireArgument e) {
            System.out.println("Empire Argument exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
